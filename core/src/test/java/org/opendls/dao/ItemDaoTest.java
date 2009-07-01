package org.opendls.dao;

import org.opendls.model.Collection;
import org.opendls.model.Item;
import org.opendls.model.OrganizationInfo;
import org.opendls.model.PersonInfo;

import javax.persistence.EntityNotFoundException;

public class ItemDaoTest extends BaseDaoTestCase
{
    private Item item = null;
    private ItemDao dao = null;
    private CollectionDao cdao = null;

    public void setItemDao(ItemDao dao)
    {
        this.dao = dao;
    }

    public void setCollectionDao(CollectionDao cdao)
    {
        this.cdao = cdao;
    }

    public void testGetItem() throws Exception
    {
        Item item = dao.get("926E60DA-8354-4852-BA7AED69024D7C26");

        assertNotNull(item);
        assertEquals("Bear in Camp", item.getTitle());
        assertNull(item.getTitleAlternative());
        assertEquals("National Parks Service", item.getCreator());

        OrganizationInfo contributor = new OrganizationInfo("ASSISTANT REGIONAL DIRECTOR-EXTERNAL AFFAIRS", 70160);
        assertEquals(contributor, item.getContributor());

        PersonInfo dataCreator = new PersonInfo("Mathew Fetterolf", "mathew_fetterolf@opendls.org");
        assertEquals(dataCreator, item.getDataCreator());

        assertEquals("National Parks Service", item.getPublisher());
        //assertEquals("", item.getLanguage());
        assertEquals("ad", item.getCollection().getId());
    }

    public void testGetItems() throws Exception
    {
        item = new Item();
        item.setTitle("my DLS record");
        item.setDataCreator(new PersonInfo("alex", "alex@opendls.org"));

        // use an existing collection
        item.setCollection(cdao.get("ac"));

//        ItemFile file = new ItemFile();
//        file.setFileName("johnjpeg");
//
//        item.setThumbFile(file);

        // XXX: get this working
        //dao.save(item);

        //assertTrue(dao.getAllItems().size() >= 1);
        // THIS IS SLOW AS HELL when counting several thousand records
    }

//    public void testSaveItems() throws Exception
//    {
//        item = new Item();
//        item.setTitle("my new DLS record");
//        item.setDataCreator(new PersonInfo("paul", "paul@opendls.org"));
//
//
//        item.setCollection(cdao.get("ad"));
//        dao.save(item);
//        assertTrue("primary key assigned", item.getId() != null);
//
//        assertNotNull(item.getTitle());
//    }

//    public void testAddAndRemoveItem() throws Exception
//    {
//        item = new Item();
//        item.setTitle("another DLS record");
//        item.setDataCreator(new PersonInfo("john", "john@opendls.org"));
//        item.
//
//        Collection c = new Collection();
//        c.setId("ac");
//        assertNotNull(c);
//        item.setCollection(c);
//
//        //item.setCollection(cdao.get("ac"));
//
//        // XXX: Fix NPE in dao.save
//        item = dao.save(item);
//
//        assertEquals("another DLS record", item.getTitle());
//        assertNotNull(item.getId());
//
//        log.debug("removing item...");
//
//        dao.remove(item.getId());
//
//        try
//        {
//            item = dao.get(item.getId());
//            fail("Item found in database");
//        }
//        catch (EntityNotFoundException dae)
//        {
//            log.debug("Expected exception: " + dae.getMessage());
//            assertNotNull(dae);
//        }
//    }

}
