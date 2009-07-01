package org.opendls.publicclient.servlet.collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.WebUtils;

public class SessionCollectionContextResolver extends
        AbstractCollectionContextResolver
{

     public static final String COLLECTION_CONTEXT_ATTRIBUTE_NAME =
      SessionCollectionContextResolver.class.getName() + ".COLLECTION_CONTEXT";

     public String resolveCollectionId(HttpServletRequest request)
     {
      String collectionId = (String) WebUtils.getSessionAttribute(request,
        COLLECTION_CONTEXT_ATTRIBUTE_NAME);
      // specific collection context, or fallback to default
      return (collectionId != null ? collectionId : getDefaultCollectionContext());
     }

     public void setCollectionId(HttpServletRequest request,
       HttpServletResponse response, String collectionId)
     {
      WebUtils.setSessionAttribute(request, COLLECTION_CONTEXT_ATTRIBUTE_NAME, collectionId);
     }

}
