package org.opendls.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import org.opendls.model.Collection;

public interface CollectionDao extends GenericDao<Collection, String>
{
    // standard CRUD is inherited from GenericDao

    public String getCollectionName(String id) throws DataAccessException;

    @Deprecated
    public List<Collection> findAllCollections() throws DataAccessException;

    public List<Collection> findVisibleCollections() throws DataAccessException;

    public List<Collection> findHiddenCollections() throws DataAccessException;

}
