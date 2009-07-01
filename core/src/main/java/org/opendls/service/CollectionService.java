package org.opendls.service;

import org.opendls.model.Collection;

import java.util.List;

public interface CollectionService
{
    public List<Collection> findAllCollections();

    public List<Collection> findVisibleCollections();

    public List<Collection> findHiddenCollections();

    public Collection getCollection(String collectionId);

    public void saveCollection(Collection collection);

    public void removeCollection(String collectionId);
}
