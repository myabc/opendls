/*
 *
 *
 */
package org.opendls.persistence.hibernate.id;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.exception.JDBCExceptionHelper;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerationException;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.mapping.Table;
import org.hibernate.type.Type;
import org.hibernate.util.PropertiesHelper;
import org.hibernate.util.StringHelper;

/**
 * CharIncrementGenerator
 *
 * @author alexbcoles
 */
public class CharIncrementGenerator implements IdentifierGenerator, Configurable
{
    private static final Log log = LogFactory.getLog(CharIncrementGenerator.class);
    private static final int DEFAULT_LENGTH = 2;
    private static final String INCREMENT_START;

    static
    {
        INCREMENT_START = "aa"; // make this configurable based on length
    }

    private int length = DEFAULT_LENGTH;
    private String next;
    private String sql;
    private Class returnClass;

    public synchronized Serializable generate(SessionImplementor session, Object object)
            throws HibernateException
    {
        if (sql != null)
        {
            getNext(session);
        }

        return next;
    }

    public void configure(Type type, Properties params, Dialect dialect)
  throws MappingException
    {
        // property for setting length
        length = PropertiesHelper.getInt("length", params, DEFAULT_LENGTH);

        // standard properties for table-level config
        String tableList = params.getProperty("tables");
        if (tableList == null)
            tableList = params
                    .getProperty(PersistentIdentifierGenerator.TABLES);
        String[] tables = StringHelper.split(", ", tableList);
        String column = params.getProperty("column");
        if (column == null)
            column = params.getProperty(PersistentIdentifierGenerator.PK);
        String schema = params
                .getProperty(PersistentIdentifierGenerator.SCHEMA);
        String catalog = params
                .getProperty(PersistentIdentifierGenerator.CATALOG);
        returnClass = type.getReturnedClass();

        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < tables.length; i++)
        {
            if (tables.length > 1)
            {
                buf.append("select ").append(column).append(" from ");
            }
            buf.append(Table.qualify(catalog, schema, tables[i]));
            if (i < tables.length - 1)
                buf.append(" union ");
        }
        if (tables.length > 1)
        {
            buf.insert(0, "( ").append(" ) ids_");
            column = "ids_." + column;
        }

        sql = "select max(" + column + ") from " + buf.toString();
 }

 private void getNext(SessionImplementor session)
 {
  log.debug("fetching initial value: " + sql);

        try
        {
            PreparedStatement st = session.getBatcher().prepareSelectStatement(
                    sql);
            try
            {
                ResultSet rs = st.executeQuery();
                try
                {
                    if (rs.next())
                    {
                        next = incrementString(rs.getString(1));

                        if (rs.wasNull())
                            next = INCREMENT_START;
                    }
                    else
                    {
                        next = INCREMENT_START;
                    }
                    sql = null;
                    log.debug("first free id: " + next);
                }
                finally
                {
                    rs.close();
                }
            }
            finally
            {
                session.getBatcher().closeStatement(st);
            }

        }
        catch(IncrementStringException ise)
        {
            throw new IdentifierGenerationException(ise.getMessage());
        }
        catch (SQLException sqle)
        {
            throw JDBCExceptionHelper.convert(session.getFactory()
                    .getSQLExceptionConverter(), sqle,
                    "could not fetch initial value for char increment generator",
                    sql);
        }

 }

    /**
     * Increments a string counter.
     *
     * @see #incrementString(String)
     * @param str the String to increment, assumed to be lower-case alphabetic
     * @return the incremented String
     * @throws IncrementStringException
     */
    public static String incrementString(String str)
            throws IncrementStringException
    {
        return incrementString(str, true);
    }

    /**
     * Increments a string counter:
     *
     * e.g.
     * <code>
     * "a" -> "b"
     * "az" -> "a0"
     * "a9" -> "ba"
     * "zzz" -> "aaaa"
     * </code>
     *
     * <p>
     * Ported to Java / based loosely on the algorithm from a VB example: <br/>
     * http://www.freevbcode.com/ShowCode.asp?ID=5440.
     * </p>
     *
     * @param strString
     *            the String to increment, assumed to be lower-case alphabetic
     * @param fixedSize
     *            whether the String should be appended (e.g. "999" --> "aaaa")
     * @return the incremented String
     * @throws IncrementStringException
     */
    public static String incrementString(String str, boolean fixedSize)
            throws IncrementStringException
    {
        final char startChar = 'a';  // lowercase a
        final char endChar = 'z';    // lowercase z
        final char startDigit = '0'; // digits follow letters
        final char endDigit = '9';   //
        final int length = str.length();
        StringBuffer buf = new StringBuffer(str);

        // Check incoming argument contains at least 1 character
        if (length < 1)
            throw new IllegalArgumentException(
                    "Argument must contain at least 1 character");

        // Check incoming argument contains only chars between 'a' and 'z'
        // TODO: check to see if this checking can be performed within main loop.
        //       Two loops may not be an optimal way of doing things.
        // TODO: replace this with a RegEx.
        for (char c : str.toCharArray())
        {
            if (!(Character.isLowerCase(c) || Character.isDigit(c)))
            {
                throw new IllegalArgumentException(
                        "Argument ["
                                + str
                                + "] may only contain characters that lie" +
                                " between lowercase 'a' and 'z', or" +
                                " digits 0 - 9.");
            }
        }

        search:
            // Start at far right of the String
            for (int i = length - 1; i >= 0; i--)
            {
                char c = str.charAt(i);

                // if the far left is reached, and the farthest left character is a 'z',
                // then throw an IncrementStringException, if the String returned must
                // be a fixed size, or if not, prepend an 'a' character and exit the
                // for statement.
                if (i == 0 && c == endDigit)
                {
                    if (fixedSize)
                    {
                        throw new IncrementStringException(
                                "The String ["
                                + str
                                + "] is a fixed size, and may not be incremented further");
                    }
                    else
                    {
                        //if (c == endChar)
                        //{
                            // replace the first 'z' with an 'a' and prepend an 'a'
                            buf.replace(i, i + 1, Character.toString(startChar));
                            buf.insert(0, startChar);

                           // break search;
                        //}
                    }
                }

                // consider next character
                if (c == endChar)
                {
                    // If 'z' is found then increment this to 'a', and increment the
                    // character after this (in next loop iteration)

                    buf.replace(i, i + 1, Character.toString(startDigit));
                    break search;
                }
                else if (c == endDigit)
                {
                    buf.replace(i, i + 1, Character.toString(startChar));
                }
                else
                {
                    // Increment this non-'z' and exit

                    c++; // increment char

                    buf.replace(i, i + 1, Character.toString(c));
                    break search;
                }
            }

        return buf.toString();
    }

}
