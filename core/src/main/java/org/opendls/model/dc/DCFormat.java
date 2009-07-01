package org.opendls.model.dc;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * DCFormat Entity
 *
 * @author alexbcoles
 * @version 1.0
 */
@Entity
@Table(name = "formats")
public class DCFormat implements Serializable
{
    private static final long serialVersionUID = 8228148950110109167L;
    private String id;
    private String name;
    private String defaultExtension;
    private Boolean openInBrowser = Boolean.TRUE; // default
    private String embedObjectCode;
    private Boolean generateThumbnail = Boolean.FALSE; //default
    private DCType type;

    public DCFormat()
    {
    }

    @Id
    @Column(name = "format_Id", length = 50)
    public String getId()
    {
        return id;
    }

    @Column(name = "formatName", length = 50)
    public String getName()
    {
        return name;
    }

    @Column(name = "defaultExtension", length = 4)
    public String getDefaultExtension()
    {
        return defaultExtension;
    }

    @Column(name = "openInBrowser", nullable = false)
    public Boolean isOpenInBrowser()
    {
        return openInBrowser;
    }

    @Column(name = "embedObjectCode")
    public String getEmbedObjectCode()
    {
        return embedObjectCode;
    }

    @Column(name = "generateThumbnail")
    public Boolean getGenerateThumbnail()
    {
        return generateThumbnail;
    }

    @org.hibernate.annotations.Type(type = "org.opendls.persistence.hibernate.usertype.DCTypeUserType")
    @Column(name = "type_Id", nullable = false)
    public DCType getType()
    {
        return type;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDefaultExtension(String defaultExtension)
    {
        this.defaultExtension = defaultExtension;
    }

    public void setOpenInBrowser(Boolean openInBrowser)
    {
        this.openInBrowser = openInBrowser;
    }

    public void setEmbedObjectCode(String embedObjectCode)
    {
        this.embedObjectCode = embedObjectCode;
    }

    public void setGenerateThumbnail(Boolean generateThumbnail)
    {
        this.generateThumbnail = generateThumbnail;
    }

    public void setType(DCType type)
    {
        this.type = type;
    }


    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        final DCFormat format = (DCFormat) o;

        if (name != null ? !name.equals(format.getName())
                : format.getName() != null)
            return false;
        if (defaultExtension != null ? !defaultExtension.equals(format
                .getDefaultExtension()) : format.getDefaultExtension() != null)
            return false;
        if (openInBrowser != null ? !openInBrowser.equals(format
                .isOpenInBrowser()) : format.isOpenInBrowser() != null)
            return false;
        if (embedObjectCode != null ? !embedObjectCode.equals(format
                .getEmbedObjectCode()) : format.getEmbedObjectCode() != null)
            return false;
        if (generateThumbnail != null ? !generateThumbnail.equals(format
                .getGenerateThumbnail())
                : format.getGenerateThumbnail() != null)
            return false;
        if (type != null ? !type.equals(format.getType()) : format
                .getType() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 67;
        result = 49 * result + name.hashCode();
        result = 49 * result + defaultExtension.hashCode();
        result = 49 * result + openInBrowser.hashCode();
        result = 49 * result + embedObjectCode.hashCode();
        result = 49 * result + generateThumbnail.hashCode();
        result = 49 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("ID:                 ").append(getId()).append("\n");
        sb.append("Name:               ").append(getName()).append("\n");
        sb.append("Default Extension:  ").append(getDefaultExtension()).append(
                "\n");
        sb.append("Open in Browser:    ").append(isOpenInBrowser())
                .append("\n");
        sb.append("Embed Object Code:  ").append(getEmbedObjectCode()).append(
                "\n");
        sb.append("Generate Thumbnail: ").append(getGenerateThumbnail())
                .append("\n");
        sb.append("Dublin Core Type:   ").append(getType());

        return sb.toString();
    }

}
