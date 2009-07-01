package org.opendls.service.impl;

import org.opendls.dao.CollectionDao;
import org.opendls.model.Collection;
import org.opendls.model.OrganizationInfo;
import org.opendls.model.PersonInfo;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

public class CollectionServiceImplTest extends BaseManagerMockTestCase
{
    private CollectionServiceImpl service = new CollectionServiceImpl();
    private Mock dao = null;
    private Collection collection = null;

    @Override
    protected void setUp() throws Exception
    {
        dao = new Mock(CollectionDao.class);
        service.setCollectionDao((CollectionDao) dao.proxy());
    }

    @Override
    protected void tearDown() throws Exception
    {
        service = null;
    }

//    public void testGetCollections()
//    {
//        Collection collection1 = new Collection();
//        collection1.setId("BN");
//        collection1.setName("Thompson Park Image Library");
//        collection1.setContactPerson(new PersonInfo("John Billson", "johnbllson@opendls.org"));
//        collection1.setOwnerOrganization(new OrganizationInfo("Jeremy Files", 2019));
//
//        Collection collection2 = new Collection();
//        collection2.setId("BW");
//        collection2.setName("Washington Park Image Library");
//        collection2.setContactPerson(new PersonInfo("John Billson", "johnbllson@opendls.org"));
//        collection2.setOwnerOrganization(new OrganizationInfo("Jeremy Files", 2019));
//
//        service.saveCollection(collection1);
//        service.saveCollection(collection2);
//
//        assertNotNull(service.getCollection("BN"));
//        assertNotNull(service.getCollection("BW"));
//    }


    public void testGetCollection()
    {
        log.debug("testing getCollection");

        String id = "XX";
        collection = new Collection();

        // set expected behavior on dao
        dao.expects(once()).method("get").with(eq(id))
                .will(returnValue(collection));

        Collection result = service.getCollection(id);
        assertSame(collection, result);
        dao.verify();
    }

    public void testFindAllCollections()
    {
        log.debug("testing findAllCollections");

        List<Collection> collections = new ArrayList<Collection>();

        // set expected behavior on dao
        dao.expects(once()).method("findAllCollections").will(returnValue(collections));

        List result = service.findAllCollections();
        assertSame(collections, result);
        dao.verify();
    }

    public void testFindVisibleCollections()
    {
        log.debug("testing findVisibleCollections");

        List<Collection> collections = new ArrayList<Collection>();

        // set expected behavior on dao
        dao.expects(once()).method("findVisibleCollections").will(
                returnValue(collections));

        List result = service.findVisibleCollections();
        assertSame(collections, result);
        dao.verify();
    }

    public void testFindHiddenCollections()
    {
        log.debug("testing findHiddenCollections");

        List<Collection> collections = new ArrayList<Collection>();

        // set expected behavior on dao
        dao.expects(once()).method("findHiddenCollections").will(
                returnValue(collections));

        List result = service.findHiddenCollections();
        assertSame(collections, result);
        dao.verify();
    }

    public void testSaveCollection()
    {
        log.debug("testing saveCollection");

        collection = new Collection();

        // set expected behavior on dao
        dao.expects(once()).method("save").with(same(collection)).isVoid();

        service.saveCollection(collection);
        dao.verify();
    }

    public void testRemoveCollection()
    {
        log.debug("testing removeFormat");

        String id = "XP";
        collection = new Collection();

        // set expected behavior on dao
        dao.expects(once()).method("remove").with(eq(id)).isVoid();

        service.removeCollection(id);
        dao.verify();
    }

    public void testAddAndRemoveCollection() throws Exception
    {
        Collection collection = new Collection();
        //collection.setId("XY");
        collection.setName("Alaska Image Library");
        collection.setContactPerson(new PersonInfo("John Billson", "johnbllson@opendls.org"));
        collection.setOwnerOrganization(new OrganizationInfo("Jeremy Files", 2019));
        collection.setShowInList(false);

        // set expected behavior on dao
        dao.expects(once()).method("save").with(same(collection));

        service.saveCollection(collection);

        // verify expectations
        dao.verify();

        assertEquals(collection.getName(), "Alaska Image Library");
        assertEquals(collection.getContactPerson().getEmail(), "johnbllson@opendls.org");

//        if (log.isDebugEnabled())
//        {
//            log.debug("removing Collection...");
//        }

        dao.expects(once()).method("remove")
            .with(eq("XY"));

        service.removeCollection("XY");

        // verify expectations
        dao.verify();

//        try
//        {
//            // set expectations
//            Throwable ex = new ObjectRetrievalFailureException(Collection.class, "XY");
//            dao.expects(once()).method("getCollection")
//                .with(eq("XY")).will(throwException(ex));
//
//            collection = service.getCollection("XY");
//
//            // verify expectations
//            dao.verify();
//            fail("Collection with name 'Alaska Image Library' found in database");
//        }
//        catch (DataAccessException dae)
//        {
//            log.debug("Expected exception: " + dae.getMessage());
//            assertNotNull(dae);
//        }

    }
}
