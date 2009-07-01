package org.opendls.persistence.hibernate.id;

import java.io.Serializable;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.engine.SessionImplementor;

public class UUIDGeneratorTest extends TestCase
{
    private static final Log log = LogFactory.getLog(UUIDGeneratorTest.class);
    private UUIDGenerator generator = null;
    private SessionImplementor session = null;  // null for the purposes of the test
    private Object object = null;               // null for the purposes of the test

    @Override
    protected void setUp() throws Exception
    {
        generator = new UUIDGenerator();
    }

    @Override
    protected void tearDown() throws Exception
    {
        generator = null;
    }

    public void testGenerate()
    {
        Serializable uuid = generator.generate(session, object);

        log.debug("creating example UUID: " + uuid.toString());

        assertNotNull(uuid);
        // check the length is the same as a Coldfusion UUID
        assertEquals(uuid.toString().length(), 35);
    }

}
