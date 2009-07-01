package org.opendls.service.impl;

import java.util.List;

import org.opendls.dao.CollectionDao;
import org.opendls.model.Collection;
import org.opendls.service.CollectionService;

public class CollectionServiceImpl implements CollectionService
{

    private CollectionDao collectionDao;

    public void setCollectionDao(CollectionDao collectionDao)
    {
        this.collectionDao = collectionDao;
    }

    public Collection getCollection(String id)
    {
        return collectionDao.get(id);
    }

    public List<Collection> findAllCollections()
    {
        return collectionDao.findAllCollections();
    }

    public List<Collection> findVisibleCollections()
    {
        return collectionDao.findVisibleCollections();
    }

    public List<Collection> findHiddenCollections()
    {
        return collectionDao.findHiddenCollections();
    }

    public void removeCollection(String collectionId)
    {
        collectionDao.remove(collectionId);
    }

    public void saveCollection(Collection collection)
    {
        collectionDao.save(collection);
    }

}
