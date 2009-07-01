package org.opendls.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.opendls.model.Content.*;
import static org.junit.Assert.*;

public class ContentTest
{
    private final static Map<String, Object> CONTENT_MAP = new HashMap<String, Object>();
    private Content content = null;

    static {
        CONTENT_MAP.put(LINKS, new ArrayList(

                ));
        CONTENT_MAP.put(SIDEBAR, "<p><a href=\"http://www.opendls.org\">Click to go to out homepage.</a></p>");
        CONTENT_MAP.put(WELCOME, "<p>Welcome to this collection.</p>");
    }

    @Before
    public void setUp()
    {
        content = new Content(CONTENT_MAP);
    }

    @After
    public void tearDown()
    {
        content = null;
    }

    @Test
    public void getAsMap()
    {
        Map<String, Object> contentMap = content.getAsMap();
        //assertEquals(3, contentMap.size());
        assertEquals(CONTENT_MAP, contentMap);
    }
}
