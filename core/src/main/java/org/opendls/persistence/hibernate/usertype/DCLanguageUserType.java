package org.opendls.persistence.hibernate.usertype;

import org.hibernate.usertype.UserType;
import org.hibernate.HibernateException;

import java.sql.Types;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.Serializable;

import org.opendls.model.dc.DCLanguage;

/**
 * UserType class for {@link DCLanguage}
 *
 * @see {@link DCLanguage)
 * @author alexbcoles
 * @version 1.0
 *
 */
public class DCLanguageUserType implements UserType
{
    private static final int[] SQL_TYPES = { Types.VARCHAR };

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#sqlTypes()
     */
    public int[] sqlTypes()
    {
        return SQL_TYPES;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#returnedClass()
     */
    public Class returnedClass()
    {
        return DCLanguage.class;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#nullSafeGet(java.sql.ResultSet,
     *      java.lang.String[], java.lang.Object)
     */
    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
            throws HibernateException, SQLException {
        String language = resultSet.getString(names[0]);
        DCLanguage result = null;
        if (!resultSet.wasNull())
        {
            result = new DCLanguage(language);
        }
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#nullSafeSet(java.sql.PreparedStatement,
     *      java.lang.Object, int)
     */
    public void nullSafeSet(PreparedStatement preparedStatement, Object value,
            int index) throws HibernateException, SQLException
    {
        if (value == null)
        {
            preparedStatement.setNull(index, Types.VARCHAR);
        }
        else
        {
            preparedStatement.setString(index, ((DCLanguage) value).getLanguage());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#deepCopy(java.lang.Object)
     */
    public Object deepCopy(Object value) throws HibernateException
    {
        return value;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#isMutable()
     */
    public boolean isMutable()
    {
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#assemble(java.io.Serializable,
     *      java.lang.Object)
     */
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException
    {
        return cached;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#disassemble(java.lang.Object)
     */
    public Serializable disassemble(Object value) throws HibernateException
    {
        return (Serializable) value;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#replace(java.lang.Object,
     *      java.lang.Object, java.lang.Object)
     */
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException
    {
        return original;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#hashCode(java.lang.Object)
     */
    public int hashCode(Object x) throws HibernateException
    {
        return x.hashCode();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.hibernate.usertype.UserType#equals(java.lang.Object,
     *      java.lang.Object)
     */
    public boolean equals(Object x, Object y) throws HibernateException
    {
        if (x == y)
            return true;
        if (null == x || null == y)
            return false;
        return x.equals(y);
    }
}
