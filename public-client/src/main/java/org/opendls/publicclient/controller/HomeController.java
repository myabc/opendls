package org.opendls.publicclient.controller;

import java.io.IOException;
import java.util.List;

import org.opendls.model.Collection;
import org.opendls.service.CollectionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HomeController implements Controller
{
    private final Log log = LogFactory.getLog(HomeController.class);
    private CollectionService collectionService;

    public void setCollectionService(CollectionService collectionService)
    {
        this.collectionService = collectionService;
    }

    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        log.debug("entering 'handleRequest' method...");

        List<Collection> collections = collectionService
                .findVisibleCollections();

        return new ModelAndView(".views.home", "collections", collections);
    }
}
