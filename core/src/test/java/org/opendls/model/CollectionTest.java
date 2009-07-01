/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.opendls.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alexbcoles
 */
public class CollectionTest
{
    private static final String INTERFACE_EXAMPLE_WDDX_STRING = "<wddxPacket version='1.0'><header/><data><struct><var name='COLORS'><struct><var name='TABS'><string>663300</string></var><var name='LEFTBOXHEAD'><string>ffffee</string></var><var name='RESULTSCELL2A'><string>ffffff</string></var><var name='CONTENTBACKGROUND'><string>FFFFCC</string></var><var name='BODYBACKGROUND'><string>ffffff</string></var><var name='RESULTSCELL1'><string>FFFFCC</string></var><var name='HEADERS'><string>663300</string></var><var name='ALINKBACKGROUND'><string>ffffff</string></var><var name='CONTROLS2'><string>FFFFFF</string></var><var name='LEFTAREABACKGROUND'><string>ffffee</string></var><var name='RESULTSCELL1A'><string>ffffff</string></var><var name='TABSBACKGROUND'><string>eeeecc</string></var><var name='BODY'><string>000000</string></var><var name='LEFTBOX'><string>663300</string></var><var name='LEFTBOXHEADBACKGROUND'><string>663300</string></var><var name='CONTROLS2BACKGROUND'><string>996633</string></var><var name='RESULTSCELL2'><string>FFFFCC</string></var><var name='CONTROLS1'><string>FFFFFF</string></var><var name='LEFTBOXBACKGROUND'><string>ffffee</string></var><var name='CONTROLS1BACKGROUND'><string>999966</string></var><var name='AHOVER'><string>ffffff</string></var><var name='LEFTAREA'><string>000000</string></var><var name='AHOVERBACKGROUND'><string>663300</string></var><var name='ALINK'><string>663300</string></var></struct></var><var name='HTMLHEAD'><string><char code='0d'/><char code='0a'/>&lt;table width=\"710\" cellspacing=\"0\" cellpadding=\"0\"&gt;<char code='0d'/><char code='0a'/><char code='09'/>&lt;tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;td&gt;&lt;img src=\"http://alaska.opendls.org//images/generic_usfwslogos.gif\" width=\"169\" height=\"85\" border=\"0\"<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>alt=\"DOI and USFWS logos\" usemap=\"#logolinks\" /&gt;&lt;/td&gt;&lt;td&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;td&gt;&lt;img src=\"/lib_assets/ad/libtitle.gif\" width=\"541\" height=\"85\" border=\"0\" alt=\"National Parks Service Historic Image Library\"&gt;&lt;/td&gt;<char code='0d'/><char code='0a'/><char code='09'/>&lt;/tr&gt;<char code='0d'/><char code='0a'/>&lt;/table&gt;</string></var><var name='HTMLFOOT'><string><char code='09'/><char code='09'/><char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;table width=\"750\"  cellspacing=\"0\" cellpadding=\"5\"&gt;&lt;tr&gt;&lt;td class=\"\"&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/></string></var><var name='FONTS'><struct><var name='BODY'><string>Tahoma,Verdana,Arial,Helvetica,sans-serif</string></var><var name='CONTROLS'><string>Verdana,Arial,Helvetica,sans-serif</string></var><var name='HEADERS'><string>Helvetica,Arial,Geneva,sans-serif</string></var></struct></var></struct></data></wddxPacket>";
    private static final String CONTENT_EXAMPLE_WDDX_STRING = "<wddxPacket version='1.0'><header/><data><struct><var name='LINKS'><array length='2'><array length='3'><string>USFWS Homepage</string><string>Privacy Policy</string><string>USFWS History Pages</string></array><array length='3'><string>http://www.opendls.org/</string><string>http://www.opendls.org/help/policies.html</string><string>http://training.opendls.org/history/index.html</string></array></array></var><var name='WELCOME'><string>&lt;table width=\"589\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td colspan=\"2\"&gt;&lt;img src=\"lib_assets/r7/splashpage_02.jpg\" width=\"589\" height=\"223\" alt=\"\" /&gt;&lt;/td&gt;&lt;/tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;tr valign=\"top\"&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td&gt;&lt;img src=\"lib_assets/r7/splashpage_02.jpg\" width=\"461\" height=\"1\" alt=\"Welcome to a glimpse of our wildlife heritage  through images of the past\" /&gt;&lt;/td&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td rowspan=\"2\"&gt;&lt;img src=\"lib_assets/r7/splashpage_03.jpg\" width=\"128\" height=\"117\" alt=\"\" /&gt;&lt;/td&gt;&lt;/tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td width=\"461\" height=\"116\" bgcolor=\"#ffffCC\"&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/>&lt;p style=\"font-family:Georgia,'Times New Roman',serif;font-size:12px\"&gt;This collection of  photographs is like looking through a window on the past. The images offer a visual history of the National Parks Service and wildlife conservation.  While a few of the images date back to settlement of theWest and some from  the turn of the last century, most are from the 1940Õs through the 1980Õs.&lt;/p&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/>&lt;p style=\"font-family:Georgia,'Times New Roman',serif;font-size:12px\"&gt;We will be adding to the 700 images as time and funding permits. If you have an era, species or particular subject you would like to see highlighted, please contact us and let us know how we can better serve you.&lt;/p&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/>&lt;p style=\"font-family:Georgia,'Times New Roman',serif;font-size:12px\"&gt;Contact: &lt;a href=\"mailto:images@opendls.org\"&gt;images@opendls.org&lt;/a&gt;&lt;/p&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;/td&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;/tr&gt;<char code='0d'/><char code='0a'/><char code='09'/>&lt;/table&gt;</string></var><var name='SIDEBAR'><string></string></var></struct></data></wddxPacket>";
    private static final String BAD_WDDX_STRING = "<malformedWddxPacket>XX<X></Y></Packet>";

    private Collection collection = null;

    @BeforeClass
    public static void setUpClass() throws Exception
    {
    }

    @AfterClass
    public static void tearDownClass() throws Exception
    {
    }

    @Before
    public void setUp()
    {
        collection = new Collection();
    }

    @After
    public void tearDown()
    {
        collection = null;
    }

    // -------------------------------------------------------------------------
    // ---------------------------------------------------- INTERFACE WDDX TESTS
    // -------------------------------------------------------------------------

    @Test
    public void getUserInterface()
    {
        setUpUI();
        assertNotNull(collection.getUserInterface());
    }

    @Test
    public void getUserInterfaceEmpty()
    {
        // do not setUpUI()
        assertNull(collection.getUserInterface());
    }

    @Test
    public void getBadUserInterface()
    {
        collection.setUserInterfaceInternal(BAD_WDDX_STRING);
        assertNull(collection.getUserInterface());
    }

    @Test
    public void getUIHtmlHead()
    {
        setUpUI();
        String htmlHead = collection.getUserInterface().getHtmlHead();

        assertNotNull(htmlHead);
        assertTrue(htmlHead.length() > 0);
        assertTrue(htmlHead.contains("<table"));
        assertTrue(htmlHead.contains("<tr>"));
        assertTrue(htmlHead.contains("<img"));
        assertFalse(htmlHead.contains("<object>"));
    }

    @Test
    public void getUIHtmlFoot()
    {
        setUpUI();
        String htmlFoot = collection.getUserInterface().getHtmlFoot();

        assertNotNull(htmlFoot);
        assertTrue(htmlFoot.length() > 0);
        assertTrue(htmlFoot.contains("<table"));
        assertTrue(htmlFoot.contains("<tr>"));
        assertFalse(htmlFoot.contains("<img"));
        assertFalse(htmlFoot.contains("<object>"));
    }

    @Test
    public void getUIFonts()
    {
        setUpUI();
        UIFonts fonts = collection.getUserInterface().getFonts();

        assertNotNull(fonts);
        assertEquals("Tahoma,Verdana,Arial,Helvetica,sans-serif", fonts.getBody());
        assertEquals("Helvetica,Arial,Geneva,sans-serif", fonts.getHeaders());
        assertEquals("Verdana,Arial,Helvetica,sans-serif", fonts.getControls());
    }

    @Test
    public void getUIColors()
    {
        setUpUI();
        UIColors colors = collection.getUserInterface().getColors();

        assertNotNull(colors);
        // add in more tests

    }

    private void setUpUI()
    {
        collection.setUserInterfaceInternal(INTERFACE_EXAMPLE_WDDX_STRING);
    }

    // -------------------------------------------------------------------------
    // ------------------------------------------------------ CONTENT WDDX TESTS
    // -------------------------------------------------------------------------

    @Test
    public void getContent()
    {
        setUpContent();
        assertNotNull(collection.getPageContent());
    }

    @Test
    public void getContentEmpty()
    {
        // do not setUpContent()
        assertNull(collection.getPageContent());
    }

    @Test public void getBadContent()
    {
        collection.setPageContentInternal(BAD_WDDX_STRING);
        assertNull(collection.getPageContent());
    }

    @Test public void getContentLinks()
    {
        setUpContent();
        List<List<String>> links = collection.getPageContent().getLinks();

        assertNotNull(links);
        assertEquals("USFWS Homepage", links.get(0).get(0));
        assertEquals("http://www.opendls.org/", links.get(1).get(0));
        assertEquals("http://training.opendls.org/history/index.html", links.get(1).get(2));
    }

    @Test public void getContentSidebar()
    {
        setUpContent();
        String sidebar = collection.getPageContent().getSidebar();

        assertNotNull(sidebar); // sidebar is not null
        assertEquals(0, sidebar.length()); // but is a 0-length string
    }

    @Test public void getContentWelcome()
    {
        setUpContent();
        String welcome = collection.getPageContent().getWelcome();

        assertNotNull(welcome);
        assertTrue(welcome.length() > 0);
        assertTrue(welcome.contains("<table"));
        assertTrue(welcome.contains("<tr>"));
        assertTrue(welcome.contains("<img"));
        assertFalse(welcome.contains("<object>"));
    }

    public void setUpContent()
    {
        collection.setPageContentInternal(CONTENT_EXAMPLE_WDDX_STRING);
    }

}
