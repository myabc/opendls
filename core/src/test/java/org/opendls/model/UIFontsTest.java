package org.opendls.model;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.opendls.model.UIFonts.*;
import static org.junit.Assert.*;

public class UIFontsTest
{
    private final static Map<String, String> FONT_MAP = new HashMap<String, String>();
    private UIFonts fonts = null;

    static {
        FONT_MAP.put(BODY, "\"Lucida Grande\", Lucida, Verdana, sans-serif");
        FONT_MAP.put(HEADERS, "Georgia, \"Times New Roman\", Times, serif");
        FONT_MAP.put(CONTROLS, "\"Courier New\", Courier, mono");
    }

    @Before
    public void setUp()
    {
        fonts = new UIFonts(FONT_MAP);
    }

    @After
    public void tearDown()
    {
        fonts = null;
    }

    @Test
    public void getAsMap()
    {
        Map<String, String> fontsMap = fonts.getAsMap();
        assertEquals(3, fontsMap.size());
        assertEquals(FONT_MAP, fontsMap);
    }

    @Test
    public void getValues()
    {
        assertEquals(fonts.getBody(), "\"Lucida Grande\", Lucida, Verdana, sans-serif");
        assertEquals(fonts.getHeaders(), "Georgia, \"Times New Roman\", Times, serif");
        assertEquals(fonts.getControls(), "\"Courier New\", Courier, mono");
    }

}
