package org.opendls.model;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.opendls.model.UserInterface.*;
import static org.junit.Assert.*;

public class UserInterfaceTest
{
    private final static Map<String, Object> UI_MAP = new HashMap<String, Object>();
    private UserInterface userInterface = null;

    static {
        //UI_MAP.put(FONTS, );
        //UI_MAP.put(COLORS, );
        UI_MAP.put(HTML_HEAD, "<div id=\"header\"><h1>Header</h1></div>");
        UI_MAP.put(HTML_FOOT, "<p class=\"small\">Footer text</p>");
    }

    @Before
    public void setUp()
    {
        userInterface = new UserInterface(UI_MAP);
    }

    @After
    public void tearDown()
    {
        userInterface = null;
    }

    @Test
    public void getAsMap()
    {
        Map<String, Object> uiMap = userInterface.getAsMap();
        //assertEquals(4, uiMap.size());
        assertEquals(UI_MAP, uiMap);
    }
}
