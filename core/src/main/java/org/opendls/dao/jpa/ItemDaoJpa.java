package org.opendls.dao.jpa;

import org.springframework.dao.DataAccessException;

import org.opendls.dao.ItemDao;
import org.opendls.model.Item;

public class ItemDaoJpa extends GenericDaoJpa<Item, String> implements ItemDao
{
    public ItemDaoJpa()
    {
        super(Item.class);
    }

    public void deleteItem(String id) throws DataAccessException
    {
        // TODO Auto-generated method stub

    }

    public void publishItem(String id) throws DataAccessException
    {
        // TODO Auto-generated method stub

    }

    public void restageItem(String id) throws DataAccessException
    {
        // TODO Auto-generated method stub

    }
}
