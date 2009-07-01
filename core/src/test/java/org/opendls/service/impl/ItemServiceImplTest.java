package org.opendls.service.impl;

import org.opendls.dao.ItemDao;
import org.opendls.model.Item;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

public class ItemServiceImplTest extends BaseManagerMockTestCase
{
    private ItemServiceImpl service = new ItemServiceImpl();
    private Mock dao = null;
    private Item item = null;

    @Override
    protected void setUp() throws Exception
    {
        dao = new Mock(ItemDao.class);
        service.setItemDao((ItemDao) dao.proxy());
    }

    @Override
    protected void tearDown() throws Exception
    {
        service = null;
    }

    public void testGetItem()
    {
        log.debug("testing getItem");

        String id = "3924326a-ec6b-11db-8314-0800200c9a66";
        item = new Item();

        // set expected behavior on dao
        dao.expects(once()).method("get").with(eq(id)).will(returnValue(item));

        Item result = service.getItem(id);
        assertSame(item, result);
        dao.verify();
    }

    public void testGetItems()
    {
        log.debug("testing getItems");

        List<Item> items = new ArrayList<Item>();

        // set expected behavior on dao
        dao.expects(once()).method("getAll").will(returnValue(items));

        List result = service.getItems();
        assertSame(items, result);
        dao.verify();
    }

    public void testSaveItem()
    {
        log.debug("testing saveItem");

        item = new Item();

        // set expected behavior on dao
        dao.expects(once()).method("save").with(same(item)).isVoid();

        service.saveItem(item);
        dao.verify();
    }

    public void testRemoveItem()
    {
        log.debug("testing removeItem");

        String id = "3924326b-ec6b-11db-8314-0800200c9a66";
        item = new Item();

        // set expected behavior on dao
        dao.expects(once()).method("remove").with(eq(id)).isVoid();

        service.removeItem(id);
        dao.verify();
    }
}
