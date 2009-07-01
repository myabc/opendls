package org.opendls.publicclient.command;

public class MoreInfoCommand
{
    private String itemId;
    private String fromName;
    private String fromEmail;
    private String comments;

    public MoreInfoCommand()
    {
    }

    public String getItemId()
    {
        return this.itemId;
    }

    public String getFromName()
    {
        return this.fromName;
    }

    public String getFromEmail()
    {
        return this.fromEmail;
    }

    public String getComments()
    {
        return this.comments;
    }

    public void setItemId(String itemId)
    {
        this.itemId = itemId;
    }

    public void setFromName(String fromName)
    {
        this.fromName = fromName;
    }

    public void setFromEmail(String fromEmail)
    {
        this.fromEmail = fromEmail;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

}
