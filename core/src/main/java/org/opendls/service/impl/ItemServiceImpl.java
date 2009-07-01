package org.opendls.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//
//import org.springframework.mail.MailException;
//
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessagePreparator;

import org.opendls.dao.ItemDao;
import org.opendls.model.Item;
import org.opendls.model.ItemStatus;
import org.opendls.service.ItemService;

public class ItemServiceImpl implements ItemService
{
    private ItemDao itemDao;

    // private JavaMailSender mailSender;

    public void setItemDao(ItemDao itemDao)
    {
        this.itemDao = itemDao;
    }

    // public void setMailSender(JavaMailSender mailSender)
    // {
    // this.mailSender = mailSender;
    // }

    public List<Item> getItems()
    {
        return itemDao.getAll();
    }

    public List<Item> getItems(ItemStatus itemStatus)
    {
        // TODO Set the Item Status
        return itemDao.getAll();
    }

    public Item getItem(String itemId)
    {
        return itemDao.get(itemId);
    }

    public void saveItem(Item item)
    {
        itemDao.save(item);
    }

    public void publishItem(String itemId)
    {
        // set item status to PUBLISHED
    }

    public void deleteItem(String itemId)
    {
        // set item status to DELETED
    }

    public void restoreItem(String itemId)
    {
        // set item status to STAGED
    }

    public void unpublishItem(String itemId)
    {
        // set item status to STAGED
    }

    public void removeItem(String itemId)
    {
        itemDao.remove(itemId);
    }

    // public void sendMoreInfoRequest(final String id, final String fromName,
    // final String fromEmail, final String comments)
    // {
    // final Item item = itemDao.getItem(id);
    //
    // MimeMessagePreparator preparator = new MimeMessagePreparator()
    // {
    // public void prepare(MimeMessage mimeMessage)
    // throws MessagingException, UnsupportedEncodingException {
    //
    // // Establish who the message is from, and who its going to
    // InternetAddress fromEmailAddress = new InternetAddress(fromEmail);
    //
    // if (fromName.length() > 0)
    // fromEmailAddress.setPersonal(fromName);
    //
    // InternetAddress toEmailAddress = new InternetAddress(
    // item.getCollection().getContactEmail(),
    // item.getCollection().getContactName());
    //
    // // Create Message Text
    // StringBuffer messageText = new StringBuffer();
    //
    // messageText.append("This message is delivered automatically by DLS
    // mail:\n");
    // messageText.append("----------------------------------------------------\n");
    // messageText.append("\n");
    // messageText.append("To:" + item.getCollection().getContactName() + "\n");
    // messageText.append("(contact for" + item.getCollection().getName() +
    // ")\n");
    // messageText.append("\n");
    // messageText.append("A user of the Digital Library System is requesting" +
    // " more information on a resource present in the Digital Library
    // System.\n");
    // messageText.append("\n");
    // messageText.append("USER INFORMATION\n");
    // messageText.append("\n");
    // messageText.append("=================================================/dls\n");
    // messageText.append("\n");
    // if(fromName.length() > 0)
    // messageText.append("From: " + fromName + "\n");
    // else
    // messageText.append("From: An unnamed user\n");
    // messageText.append("Email: " + fromEmail + "\n");
    // messageText.append("\n");
    // messageText.append("RESOURCE INFORMATION" );
    // messageText.append("=================================================/dls\n");
    // messageText.append("Data Id: " + item.getId() +"\n");
    // messageText.append("Title: " + item.getTitle() + "\n");
    // messageText.append("Source: " + item.getSource() + "\n");
    // messageText.append("Collection: " + item.getCollection().getName() +"
    // \n");
    // messageText.append("\n");
    // messageText.append("To view this resource now:\n");
    // messageText.append("Go to http://opendls.org/item.html?id=" +
    // item.getId() + "\n");
    //
    // // Set Message Attributes
    // mimeMessage.setFrom(fromEmailAddress);
    // mimeMessage.setRecipient(Message.RecipientType.TO, toEmailAddress);
    // mimeMessage.setSubject("DLS: Resource Info Request: " +
    // item.getSource());
    // mimeMessage.setSentDate(new Date());
    //
    // // Set the Message text
    // mimeMessage.setText(messageText.toString());
    // }
    // };
    //
    // // Attempt to fire off the Message
    // try
    // {
    // mailSender.send(preparator);
    // }
    // catch(MailException e)
    // {
    // System.err.println(e.getMessage());
    // e.printStackTrace();
    // // LOGGER.error(e.getMessage());
    // }
    // }

}
