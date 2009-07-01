package org.opendls.publicclient.controller;

import org.opendls.model.Item;
import org.opendls.publicclient.command.DisplayItemCommand;
import org.opendls.service.ItemService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

public class ItemDisplayController extends AbstractCommandController
{
    private final Log log = LogFactory.getLog(ItemDisplayController.class);
    private ItemService itemService;

    public ItemDisplayController()
    {
        setCommandClass(DisplayItemCommand.class);
    }

    public void setItemService(ItemService itemService)
    {
        this.itemService = itemService;
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException errors)
            throws Exception
    {
        log.debug("entering 'handle' method...");

        DisplayItemCommand displayCommand = (DisplayItemCommand) command;

        Item item = itemService.getItem(displayCommand.getId());

        return new ModelAndView(".views.displayitem", "item", item);
    }

}
