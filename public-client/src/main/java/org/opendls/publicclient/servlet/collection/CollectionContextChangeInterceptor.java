package org.opendls.publicclient.servlet.collection;

import org.opendls.publicclient.servlet.CollectionContextResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ThemeResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 * Interceptor that allows for changing the collection context on
 * every request, via a configurable parameter.
 *
 * Collection context establishes:
 * <ul>
 *  <li>The theme that will be displayed to the user.</li>
 *  <li>The default scope for browsing and searching (i.e. whether
 *  browsing and searching will display all items in the system,
 *  or just the items in the specified collection).</li>
 * </ul>
 *
 * @author alexbcoles
 *
 */
public class CollectionContextChangeInterceptor extends
  HandlerInterceptorAdapter
{

     /**
      * Default name of the collection context specification parameter: "collection"
      */
    public static final String DEFAULT_PARAM_NAME = "collection";

    private CollectionContextResolver collectionContextResolver;
    private String paramName = DEFAULT_PARAM_NAME;

    public void setCollectionContextResolver(CollectionContextResolver collectionContextResolver)
    {
      this.collectionContextResolver = collectionContextResolver;
    }

     /**
      * Set the name of the parameter that contains a collection context
      * specification in a collection context change request.
      * Default is "collection".
      *
      * @param paramName
      */
    public void setParamName(String paramName)
    {
      this.paramName = paramName;
    }

     /**
      * @see org.springrframework.web.servlet.ThemeChangeInterceptor
      */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
       Object handler) throws ServletException
    {
      String newCollection = request.getParameter(this.paramName);

      ThemeResolver themeResolver = RequestContextUtils.getThemeResolver(request);
      if (themeResolver == null)
      {
       throw new IllegalStateException("No ThemeResolver found: not in a DispatcherServlet request?");
      }

      // CollectionContextResolver collectionContextResolver = this.collectionContextResolver;


      if (newCollection != null)
      {
       // Set up the theme for this collection

       String newTheme = "theme_" + newCollection;
       themeResolver.setThemeName(request, response, newTheme);

       // Set collection context information

       collectionContextResolver.setCollectionId(request, response, newCollection);

       //if (newCollection == this.baseParamValue)
       //{
        // the base collection context
        // TODO: do any other logic
       //}
       //else
       //{
        // load this collection from memory
       //}
       // TODO: set other collection context information

      }

      // always proceed to process the rest of the request
      return true;
    }

}
