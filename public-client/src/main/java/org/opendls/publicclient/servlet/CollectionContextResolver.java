package org.opendls.publicclient.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CollectionContextResolver
{
    String resolveCollectionId(HttpServletRequest request);

    void setCollectionId(HttpServletRequest request,
        HttpServletResponse response, String collectionId);
}
