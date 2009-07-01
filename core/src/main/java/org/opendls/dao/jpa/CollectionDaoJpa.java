package org.opendls.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.dao.DataAccessException;

import org.opendls.dao.CollectionDao;
import org.opendls.model.Collection;

public class CollectionDaoJpa extends GenericDaoJpa<Collection, String>
        implements CollectionDao
{

    public CollectionDaoJpa()
    {
        super(Collection.class);
    }

    @SuppressWarnings("unchecked")
    public List<Collection> findAllCollections() throws DataAccessException
    {
        Query q = entityManager.createQuery("select c from Collection c");
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Collection> findHiddenCollections() throws DataAccessException
    {
        Query q = entityManager.createQuery("select c from Collection c where c.showInList = false");
        return q.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Collection> findVisibleCollections() throws DataAccessException
    {
        Query q = entityManager.createQuery("select c from Collection c where c.showInList = true");
        return q.getResultList();
    }

    public String getCollectionName(String id) throws DataAccessException
    {
        // TODO Auto-generated method stub
        return null;
    }

}
