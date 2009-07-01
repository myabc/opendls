package org.opendls.publicclient.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.opendls.model.Item;
import org.opendls.publicclient.command.MoreInfoCommand;
import org.opendls.service.ItemService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ItemMoreInfoController extends SimpleFormController
{
    private final Log log = LogFactory.getLog(ItemMoreInfoController.class);
    private ItemService itemService;

    public ItemMoreInfoController()
    {
        setCommandClass(MoreInfoCommand.class);
    }

    public void setItemService(ItemService itemService)
    {
        this.itemService = itemService;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.web.servlet.mvc.SimpleFormController#referenceData(javax.servlet.http.HttpServletRequest,
     *      java.lang.Object, org.springframework.validation.Errors)
     */
    @Override
    protected Map referenceData(HttpServletRequest request, Object command,
            Errors errors) throws Exception
    {
        Item item = itemService.getItem((String) request.getParameter("id"));
        HashMap model = new HashMap();
        model.put("Item", item);

        return model;
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception
    {
        MoreInfoCommand moreInfoCommand = (MoreInfoCommand) command;
        //
        // itemService.sendMoreInfoRequest(moreInfoCommand.getItemId(),
        // moreInfoCommand.getFromName(),
        // moreInfoCommand.getFromEmail(),
        // moreInfoCommand.getComments());

        // does not return a model and view
    }
}
