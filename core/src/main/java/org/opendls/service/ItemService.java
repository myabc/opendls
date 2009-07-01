package org.opendls.service;

import java.util.List;

import org.opendls.model.Item;
import org.opendls.model.ItemStatus;

public interface ItemService
{
    public List<Item> getItems();

    public List<Item> getItems(ItemStatus itemStatus);

    public Item getItem(String itemId);

    public void saveItem(Item item);

    public void publishItem(String itemId);

    public void deleteItem(String itemId);

    public void restoreItem(String itemId);

    public void unpublishItem(String itemId);

    public void removeItem(String itemId);

//    public void sendMoreInfoRequest(String id, String fromName,
//            String fromEmail, String comments);
}
