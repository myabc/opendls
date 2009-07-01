package org.opendls.dao;

import org.opendls.model.Collection;
import org.opendls.model.OrganizationInfo;
import org.opendls.model.PersonInfo;

import java.util.List;

import javax.persistence.EntityNotFoundException;

public class CollectionDaoTest extends BaseDaoTestCase
{
    private Collection collection = null;
    private CollectionDao dao;

    private static final String INTERFACE_EXAMPLE_WDDX_STRING = "<wddxPacket version='1.0'><header/><data><struct><var name='COLORS'><struct><var name='TABS'><string>663300</string></var><var name='LEFTBOXHEAD'><string>ffffee</string></var><var name='RESULTSCELL2A'><string>ffffff</string></var><var name='CONTENTBACKGROUND'><string>FFFFCC</string></var><var name='BODYBACKGROUND'><string>ffffff</string></var><var name='RESULTSCELL1'><string>FFFFCC</string></var><var name='HEADERS'><string>663300</string></var><var name='ALINKBACKGROUND'><string>ffffff</string></var><var name='CONTROLS2'><string>FFFFFF</string></var><var name='LEFTAREABACKGROUND'><string>ffffee</string></var><var name='RESULTSCELL1A'><string>ffffff</string></var><var name='TABSBACKGROUND'><string>eeeecc</string></var><var name='BODY'><string>000000</string></var><var name='LEFTBOX'><string>663300</string></var><var name='LEFTBOXHEADBACKGROUND'><string>663300</string></var><var name='CONTROLS2BACKGROUND'><string>996633</string></var><var name='RESULTSCELL2'><string>FFFFCC</string></var><var name='CONTROLS1'><string>FFFFFF</string></var><var name='LEFTBOXBACKGROUND'><string>ffffee</string></var><var name='CONTROLS1BACKGROUND'><string>999966</string></var><var name='AHOVER'><string>ffffff</string></var><var name='LEFTAREA'><string>000000</string></var><var name='AHOVERBACKGROUND'><string>663300</string></var><var name='ALINK'><string>663300</string></var></struct></var><var name='HTMLHEAD'><string><char code='0d'/><char code='0a'/>&lt;table width=\"710\" cellspacing=\"0\" cellpadding=\"0\"&gt;<char code='0d'/><char code='0a'/><char code='09'/>&lt;tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;td&gt;&lt;img src=\"http://alaska.fws.gov//images/generic_usfwslogos.gif\" width=\"169\" height=\"85\" border=\"0\"<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>alt=\"DOI and USFWS logos\" usemap=\"#logolinks\" /&gt;&lt;/td&gt;&lt;td&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;td&gt;&lt;img src=\"/lib_assets/ad/libtitle.gif\" width=\"541\" height=\"85\" border=\"0\" alt=\"National Parks Service Historic Image Library\"&gt;&lt;/td&gt;<char code='0d'/><char code='0a'/><char code='09'/>&lt;/tr&gt;<char code='0d'/><char code='0a'/>&lt;/table&gt;</string></var><var name='HTMLFOOT'><string><char code='09'/><char code='09'/><char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;table width=\"750\"  cellspacing=\"0\" cellpadding=\"5\"&gt;&lt;tr&gt;&lt;td class=\"\"&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;/td&gt;&lt;/tr&gt;&lt;/table&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/></string></var><var name='FONTS'><struct><var name='BODY'><string>Tahoma,Verdana,Arial,Helvetica,sans-serif</string></var><var name='CONTROLS'><string>Verdana,Arial,Helvetica,sans-serif</string></var><var name='HEADERS'><string>Helvetica,Arial,Geneva,sans-serif</string></var></struct></var></struct></data></wddxPacket>";
    private static final String CONTENT_EXAMPLE_WDDX_STRING = "<wddxPacket version='1.0'><header/><data><struct><var name='LINKS'><array length='2'><array length='3'><string>Homepage</string><string>Privacy Policy</string><string>USFWS History Pages</string></array><array length='3'><string>http://www.fws.gov/</string><string>http://www.fws.gov/help/policies.html</string><string>http://training.fws.gov/history/index.html</string></array></array></var><var name='WELCOME'><string>&lt;table width=\"589\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td colspan=\"2\"&gt;&lt;img src=\"lib_assets/r7/splashpage_02.jpg\" width=\"589\" height=\"223\" alt=\"\" /&gt;&lt;/td&gt;&lt;/tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;tr valign=\"top\"&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td&gt;&lt;img src=\"lib_assets/r7/splashpage_02.jpg\" width=\"461\" height=\"1\" alt=\"Welcome to a glimpse of our wildlife heritage  through images of the past\" /&gt;&lt;/td&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td rowspan=\"2\"&gt;&lt;img src=\"lib_assets/r7/splashpage_03.jpg\" width=\"128\" height=\"117\" alt=\"\" /&gt;&lt;/td&gt;&lt;/tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;tr&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;td width=\"461\" height=\"116\" bgcolor=\"#ffffCC\"&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/>&lt;p style=\"font-family:Georgia,'Times New Roman',serif;font-size:12px\"&gt;This collection of  photographs is like looking through a window on the past. The images offer a visual history of the National Parks Service and wildlife conservation.  While a few of the images date back to settlement of theWest and some from  the turn of the last century, most are from the 1940Õs through the 1980Õs.&lt;/p&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/>&lt;p style=\"font-family:Georgia,'Times New Roman',serif;font-size:12px\"&gt;We will be adding to the 700 images as time and funding permits. If you have an era, species or particular subject you would like to see highlighted, please contact us and let us know how we can better serve you.&lt;/p&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/>&lt;p style=\"font-family:Georgia,'Times New Roman',serif;font-size:12px\"&gt;Contact: &lt;a href=\"mailto:images@fws.gov\"&gt;images@fws.gov&lt;/a&gt;&lt;/p&gt;<char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='0d'/><char code='0a'/><char code='09'/><char code='09'/><char code='09'/>&lt;/td&gt;<char code='0d'/><char code='0a'/><char code='09'/><char code='09'/>&lt;/tr&gt;<char code='0d'/><char code='0a'/><char code='09'/>&lt;/table&gt;</string></var><var name='SIDEBAR'><string></string></var></struct></data></wddxPacket>";

    public void setCollectionDao(CollectionDao collectionDao)
    {
        this.dao = collectionDao;
    }

    public void testGetCollection() throws Exception
    {
        Collection collection = dao.get("ad");

        assertNotNull(collection);
        assertEquals("Historic Image Library", collection.getName());
        assertTrue(collection.isShowInList());
    }

    public void testGetCollectionInvalid() throws Exception
    {
        try
        {
            dao.get("xx");
            fail("'non existent collection' found in database");
        }
        catch(EntityNotFoundException enfe)
        {
            log.debug("Expected exception: " + enfe.getMessage());
            assertNotNull(enfe);
        }
    }

    public void testFindAllCollections() throws Exception
    {
        List<Collection> collections = dao.findAllCollections();
        assertTrue(collections.size() > 0);
    }

    public void testFindVisibleCollections() throws Exception
    {
        List<Collection> collections = dao.findVisibleCollections();
        assertTrue(collections.size() > 0);
    }

    public void testFindHiddenCollections() throws Exception
    {
        List<Collection> collections = dao.findHiddenCollections();
        assertTrue(collections.size() > 0);
    }

    public void testCollectionExists() throws Exception
    {
        assertTrue(dao.exists("ad"));
    }

    public void testCollectionDoesNotExist() throws Exception
    {
        assertFalse(dao.exists("xx"));
    }

    public void testGetCollections() throws Exception
    {
        collection = new Collection();
        //collection.setId("XY");
        collection.setName("Alaska Image Library");
        collection.setContactPerson(new PersonInfo("John Billson", "johnbllson@fws.gov"));
        collection.setOwnerOrganization(new OrganizationInfo("Jeremy Files", 2019));
        collection.setShowInList(false);

        dao.save(collection);

        assertTrue(dao.findAllCollections().size() >= 1);
    }

    public void testSaveCollection() throws Exception
    {
        collection = new Collection();
        //collection.setId("RE");
        collection.setName("Alaska Image Library");
        collection.setContactPerson(new PersonInfo("John Fishkill", "johnbllson@fws.gov"));
        collection.setOwnerOrganization(new OrganizationInfo("Jeremy Files", 2019));
//
//        Map<String, Object> ui = new Hashtable<String, Object>();
//        ui.put("TABS", "664400");
//        ui.put("LEFTBOXHEAD", "sfgdsfg");
//        // collection.setUserInterface(ui);
//        collection.setUserInterfaceInternal(INTERFACE_EXAMPLE_WDDX_STRING);
//        collection.setPageContentInternal(CONTENT_EXAMPLE_WDDX_STRING);
//
//        Map<String, Object> pg = new Hashtable<String, Object>();
//        pg.put("TITLE", "ALASKA IMAGES");
//        // collection.setPageContent(pg);
//
//        // System.out.print("\n\n");
//        // System.out.print(collection.getUserInterface().toString());
//        // System.out.print("\n\n");
//        // System.out.print(collection.getPageContent().toString());
//        // System.out.print("\n\n");
//
//        System.out.print(collection.getPageContent().get("LINKS").getClass()
//                .getName()); // java.util.Vector
//        System.out.print(collection.getPageContent().get("SIDEBAR").getClass()
//                .getName()); // String
//        System.out.print(collection.getPageContent().get("WELCOME").getClass()
//                .getName()); // String
//
//        System.out.print(collection.getUserInterface().get("HTMLHEAD")
//                .getClass().getName()); // String
//        System.out.print(collection.getUserInterface().get("HTMLFOOT")
//                .getClass().getName()); // String
//        System.out.print(collection.getUserInterface().get("COLORS").getClass()
//                .getName()); // hashtable
//        System.out.print(collection.getUserInterface().get("FONTS").getClass()
//                .getName()); // hashtable

        collection = dao.save(collection);

        assertTrue("primary key assigned", collection.getId() != null);

        assertNotNull(collection.getName());
        assertNotNull(collection.getContactPerson());
        assertNotNull(collection.getOwnerOrganization());
//        assertNotNull(collection.getUserInterface());
//        assertNotNull(collection.getPageContent());
    }

    public void testAddAndRemoveCollection() throws Exception
    {
        collection = new Collection();
        //collection.setId("XD");
        collection.setName("Regional Document Library");
        collection.setContactPerson(new PersonInfo("Jerry Walton", "jerry_walton@fws.gov"));
        collection.setOwnerOrganization(new OrganizationInfo("John Doe", 3019));

        collection = dao.save(collection);

        collection = dao.get(collection.getId());

        assertEquals("Regional Document Library", collection.getName());
        assertEquals("jerry_walton@fws.gov", collection.getContactPerson().getEmail());
        assertEquals("Jerry Walton", collection.getContactPerson().getName());
        assertEquals("John Doe", collection.getOwnerOrganization().getName());
        assertEquals(Integer.valueOf(3019), collection.getOwnerOrganization().getOrgCode());

        log.debug("removing collection...");

        dao.remove(collection.getId());

        try
        {
            collection = dao.get(collection.getId());
            fail("Collection found in database");
        }
        catch (EntityNotFoundException dae)
        {
            log.debug("Expected exception: " + dae.getMessage());
            assertNotNull(dae);
        }
    }

}
