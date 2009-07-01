package org.opendls.persistence.hibernate.id;

import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.engine.SessionImplementor;

public class CharIncrementGeneratorTest extends TestCase
{
    private static final Log log = LogFactory.getLog(CharIncrementGeneratorTest.class);
    private CharIncrementGenerator generator = null;
    private SessionImplementor session = null;  // null for the purposes of the test
    private Object object = null;               // null for the purposes of the test

    @Override
    protected void setUp() throws Exception
    {
        generator = new CharIncrementGenerator();
    }

    @Override
    protected void tearDown() throws Exception
    {
        generator = null;
    }

    //
    //
    // EXPECTED EXCEPTIONS
    //
    //
    public void testIncrementStringInvalid()
    {
        // Expect an exception if a blank string is passed in.
        try
        {
            CharIncrementGenerator.incrementString("");
            fail("Blank string should throw an Exception");
        }
        catch(IllegalArgumentException iae)
        {
            log.debug("Expected exception: " + iae.getMessage());
        }
        catch (IncrementStringException ise)
        {
            fail(ise.getMessage());
        }
    }

    public void testIncrementStringInvalid1()
    {
        // Expect an exception if 'ZZ' is passed in:
        // 'ZZ' does not consist of lowercase chars between 'a' and 'z'
        try
        {
            CharIncrementGenerator.incrementString("ZZ");
            fail("ZZ should throw an Exception");
        }
        catch(IllegalArgumentException iae)
        {
            log.debug("Expected exception: " + iae.getMessage());
        }
        catch (IncrementStringException ise)
        {
            fail(ise.getMessage());
        }
    }

    public void testIncrementStringInvalid2()
    {
        // Expect an exception if '$!' is passed in:
        // '$!' does not consist of lowercase chars between 'a' and 'z'
        try
        {
            CharIncrementGenerator.incrementString("$!");
            fail("$! should throw an Exception");
        }
        catch(IllegalArgumentException iae)
        {
            log.debug("Expected exception: " + iae.getMessage());
        }
        catch (IncrementStringException ise)
        {
            fail(ise.getMessage());
        }
    }

    public void testIncrementStringInvalid3()
    {
        // Expect an exception if '9999' is passed in:
        // '9999' is fixed size, and may not be incremented further
        try
        {
            System.out.println(CharIncrementGenerator.incrementString("9999"));
            fail("9999 should throw an Exception");
        }
        catch(IncrementStringException ex)
        {
            log.debug("Expected exception: " + ex.getMessage());
        }
    }

    public void testIncrementStringInvalid4()
    {
        // Expect an exception if '9' is passed in:
        // '9' is fixed size, and may not be incremented further
        try
        {
            System.out.println(CharIncrementGenerator.incrementString("9"));
            fail("9 should throw an Exception");
        }
        catch(IncrementStringException ex)
        {
            log.debug("Expected exception: " + ex.getMessage());
        }
    }

    //
    //
    // EXPECTED TO WORK!
    //
    //
    public void testIncrementString()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("z", false);
            assertNotNull(test);
            assertEquals("0", test);

        }
        catch(Exception ex)
        {
            fail(ex.getMessage());
        }
    }

    public void testIncrementString1()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("9", false);
            assertNotNull(test);
            assertEquals("aa", test); // because false has been set, this should
                                       // prepend an 'a'
        }
        catch(Exception ex)
        {
            fail(ex.getMessage());
        }
    }

    public void testIncrementString2()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("9999", false);
            assertNotNull(test);
            assertEquals("aaaaa", test); // because false has been set, this should
                                          // prepend an 'a'
        }
        catch(Exception ex)
        {
            fail(ex.getMessage());
        }
    }

    public void testIncrementString3()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("aaaaaa");
            assertNotNull(test);
            assertEquals("aaaaab", test);
        }
        catch (IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString4()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("scrum");
            assertNotNull(test);
            assertEquals("scrun", test);
        }
        catch (IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString5()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("dddz");
            assertNotNull(test);
            assertEquals("ddd0", test);
        }
        catch (IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString6()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("ccsa");
            assertNotNull(test);
            assertEquals("ccsb", test);
        }
        catch(IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString7()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("dz");
            assertNotNull(test);
            assertEquals("d0", test);
        }
        catch(IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString8()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("e");
            assertNotNull(test);
            assertEquals("f", test);
        }
        catch(IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString9()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("xyz");
            assertNotNull(test);
            assertEquals("xy0", test);
        }
        catch(IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString10()
    {
        try
        {
            String test = CharIncrementGenerator.incrementString("hhhhhhhhhh");
            assertNotNull(test);
            assertEquals("hhhhhhhhhi", test);
        }
        catch(IncrementStringException ex)
        {
            fail(ex.getMessage());
            //ex.printStackTrace();
        }
    }

    public void testIncrementString11()
    {
        if (log.isDebugEnabled())
        {
            StringBuffer buf = new StringBuffer(17576); // 26^3 - 1 =
            String incrementStr = "aa";

            for (int i = 0; i < 675; i++) // 26^2 - 1 = 675
            {
                try
                {
                    buf.append(incrementStr + "/");
                    incrementStr = CharIncrementGenerator.incrementString(incrementStr);
                }
                catch (IncrementStringException ex)
                {
                    fail(ex.getMessage());
                    //ex.printStackTrace();
                }
            }
            log.debug("Example of incrementing chars: " + buf.toString());
        }
    }

//    public void testGenerate()
//    {
//        //System.out.print(CharIncrementGenerator.incrementString("aa"));
//
//
//
//        // Expect an exception if 'zz' is passed in:
//
////        Serializable uuid = generator.generate(session, object);
//
////        log.debug("creating example UUID: " + uuid.toString());
//
////        assertNotNull(uuid);
//        // check the length is the same as a Coldfusion UUID
////        assertEquals(uuid.toString().length(), 35);
//    }

}
