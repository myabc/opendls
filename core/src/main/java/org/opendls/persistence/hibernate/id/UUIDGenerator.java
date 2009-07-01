package org.opendls.persistence.hibernate.id;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 * UUIDGenerator
 *
 * <p>
 * Based on the {@link java.util.UUID#randomUUID()} method, this custom
 * implementation of {@link IdentifierGenerator} returns a 35-character version
 * of the UUID, consistent with the UUIDs used in the legacy Coldfusion version
 * of the DLS.
 * </p>
 *
 * @author alexbcoles
 *
 */
public class UUIDGenerator implements IdentifierGenerator
{

    public Serializable generate(SessionImplementor session, Object object)
            throws HibernateException
    {
        StringBuffer buffer = new StringBuffer(36); // size of a Java UUID
        buffer.append(UUID.randomUUID().toString());

        // JVM 5's inbuilt UUID Generator produces a UUID that looks like this:
        // ef5f43eb-2f0a-4e17-a07f-69125a3771dc
        //
        // This presumes JVM 5's implementation is the fastest. There are
        // alternative implementations that could be investigated.
        //
        // A Coldfusion MX-style UUID looks like this:
        // EB3D376C-1143-3066-401F08EE055218CE
        //
        // To make it match a Coldfusion MX-style UUID, we need to remove out the
        // final hyphen character (character 23).
        buffer.deleteCharAt(23);

        return buffer.toString();
    }

}
