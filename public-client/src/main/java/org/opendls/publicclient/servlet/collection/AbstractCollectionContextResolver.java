package org.opendls.publicclient.servlet.collection;

import org.opendls.publicclient.servlet.CollectionContextResolver;

public abstract class AbstractCollectionContextResolver implements
  CollectionContextResolver
{

    /**
     *
     */
    public final static String ORIGINAL_COLLECTION_CONTEXT_ID = "none";

    private String defaultCollectionContext = ORIGINAL_COLLECTION_CONTEXT_ID;

    /**
     *
     */
    public void setDefaultCollectionContext(String defaultCollectionContext)
    {
        this.defaultCollectionContext = defaultCollectionContext;
    }

    /**
     *
     */
    public String getDefaultCollectionContext()
    {
        return defaultCollectionContext;
    }

}
