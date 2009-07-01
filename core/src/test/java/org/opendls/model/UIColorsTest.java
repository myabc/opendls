package org.opendls.model;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.opendls.model.UIColors.*;
import static org.junit.Assert.*;

public class UIColorsTest
{
    private final static Map<String, String> COLOR_MAP = new HashMap<String, String>();
    private UIColors colors = null;

    static {
        COLOR_MAP.put(BODY_BACKGROUND, "928822");
        COLOR_MAP.put(BODY, "EBF1F7");
        COLOR_MAP.put(HEADERS, "030722");
        COLOR_MAP.put(CONTENT_BACKGROUND, "04634E");
        COLOR_MAP.put(TABS_BACKGROUND, "10CA9A");
        COLOR_MAP.put(TABS, "005F66");
        COLOR_MAP.put(LEFT_AREA_BACKGROUND, "00474C");
        COLOR_MAP.put(LEFT_AREA, "F5F3F3");
        COLOR_MAP.put(LEFT_BOX_HEAD_BACKGROUND, "1C011C");
        COLOR_MAP.put(LEFT_BOX_HEAD, "730056");
        COLOR_MAP.put(LEFT_BOX_BACKGROUND, "CA4FAD");
        COLOR_MAP.put(LEFT_BOX, "660054");
        COLOR_MAP.put(A_LINK_BACKGROUND, "4C003F");
        COLOR_MAP.put(A_LINK, "EAD7EE");
        COLOR_MAP.put(A_HOVER_BACKGROUND, "130113");
        COLOR_MAP.put(A_HOVER, "2B006C");
        COLOR_MAP.put(CONTROLS_1_BACKGROUND, "6A33D8");
        COLOR_MAP.put(CONTROLS_1, "320066");
        COLOR_MAP.put(CONTROLS_2_BACKGROUND, "25004C");
        COLOR_MAP.put(CONTROLS_2, "D7E8E1");
        COLOR_MAP.put(RESULTS_CELL_1, "002915");
        COLOR_MAP.put(RESULTS_CELL_1A, "2C3903");
        COLOR_MAP.put(RESULTS_CELL_2, "C5C585");
        COLOR_MAP.put(RESULTS_CELL_2A, "096600");
    }

    @Before
    public void setUp()
    {
        colors = new UIColors(COLOR_MAP);
    }

    @After
    public void tearDown()
    {
        colors = null;
    }

    @Test
    public void getAsMap()
    {
        Map<String, String> colorsMap = colors.getAsMap();
        assertEquals(COLOR_MAP, colorsMap);
    }

    @Test
    public void getValues()
    {
        assertEquals(BODY_BACKGROUND, "928822", colors.getBodyBackground());
        assertEquals(BODY, "EBF1F7", colors.getBody());
        assertEquals(HEADERS, "030722", colors.getHeaders());
        assertEquals(CONTENT_BACKGROUND, "04634E", colors.getContentBackground());
        assertEquals(TABS_BACKGROUND, "10CA9A", colors.getTabsBackground());
        assertEquals(TABS, "005F66", colors.getTabs());
        assertEquals(LEFT_AREA_BACKGROUND, "00474C", colors.getLeftAreaBackground());
        assertEquals(LEFT_AREA, "F5F3F3", colors.getLeftArea());
        assertEquals(LEFT_BOX_HEAD_BACKGROUND, "1C011C", colors.getLeftBoxHeadBackground());
        assertEquals(LEFT_BOX_HEAD, "730056", colors.getLeftBoxHead());
        assertEquals(LEFT_BOX_BACKGROUND, "CA4FAD", colors.getLeftBoxBackground());
        assertEquals(LEFT_BOX, "660054", colors.getLeftBox());
        assertEquals(A_LINK_BACKGROUND, "4C003F", colors.getALinkBackground());
        assertEquals(A_LINK, "EAD7EE", colors.getALink());
        assertEquals(A_HOVER_BACKGROUND, "130113", colors.getAHoverBackground());
        assertEquals(A_HOVER, "2B006C", colors.getAHover());
        assertEquals(CONTROLS_1_BACKGROUND, "6A33D8", colors.getControls1Background());
        assertEquals(CONTROLS_1, "320066", colors.getControls1());
        assertEquals(CONTROLS_2_BACKGROUND, "25004C", colors.getControls2Background());
        assertEquals(CONTROLS_2, "D7E8E1", colors.getControls2());
        assertEquals(RESULTS_CELL_1, "002915", colors.getResultsCell1());
        assertEquals(RESULTS_CELL_1A, "2C3903", colors.getResultsCell1a());
        assertEquals(RESULTS_CELL_2, "C5C585", colors.getResultsCell2());
        assertEquals(RESULTS_CELL_2A, "096600", colors.getResultsCell2a());
    }
}
