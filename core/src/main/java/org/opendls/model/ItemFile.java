package org.opendls.model;

import org.opendls.model.dc.DCFormat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * ItemFile
 *
 * <p>Represents a binary file and its metadata within an {@link Item} in the Digital Library System.</p>
 *
 * @author alexbcoles
 * @version 1.0
 */
@Entity
@Table(name = "files")
public class ItemFile implements Serializable
{
    private static final long serialVersionUID = -3207488374160680322L;
    private String id;
    private String filename; // varchar 100
    private Integer fileSize;
    private String fileInfo;
    private DCFormat format;
    private Integer volumeId;
    private Date dateCreated = new Date(); // defaults to 'now'
    private Date dateModified = new Date(); // defaults to 'now'
    private String userId;
    private String thumbFile;
    private String originalFilename;
    private Item item;

    public ItemFile()
    {
    }

    // ---------------------------------------------------------------- Setters

    /**
     * @return Returns the id.
     */
    @Id
    @Column(name = "file_Id", length = 35)
    @GeneratedValue(generator = "custom-uuid")
    @org.hibernate.annotations.GenericGenerator(
        name = "custom-uuid",
        strategy = "org.opendls.persistence.hibernate.id.UUIDGenerator"
    )
    public String getId() {
        return id;
    }

    @Column(length = 100) // TODO: this should be made null
    public String getFilename() {
        return filename;
    }

    @Column(precision = 4, nullable = false)
    public Integer getFileSize() {
        return fileSize;
    }

    @Lob
    @Column
    public String getFileInfo() {
        return fileInfo;
    }

    @ManyToOne
    @JoinColumn(name = "format_Id", nullable = false)
    public DCFormat getFormat() {
        return format;
    }

    @Column(nullable = false)
    public Integer getVolumeId() {
        return volumeId;
    }

    @Column
    public Date getDateCreated() {
        return dateCreated;
    }

    @Column
    public Date getDateModified() {
        return dateModified;
    }

    @Column(length = 100)
    public String getUserId() {
        return userId;
    }

    @Column(length = 100)
    public String getThumbFile() {
        return thumbFile;
    }

    @Column(length = 100)
    public String getOriginalFilename() {
        return originalFilename;
    }

    @ManyToOne
    @JoinTable(name = "dfIndex",
            joinColumns = @JoinColumn(name = "file_Id"),
            inverseJoinColumns = @JoinColumn(name = "data_Id"))
    public Item getItem() { return item; }

    // ---------------------------------------------------------------- Getters

    @SuppressWarnings("unused")
    private void setId(String id) {
        this.id = id;
    }

    public void setFilename(String fileName) {
        this.filename = fileName;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public void setFileInfo(String fileInfo) {
        this.fileInfo = fileInfo;
    }

    public void setFormat(DCFormat format) {
        this.format = format;
    }

    public void setVolumeId(Integer volumeId) {
        this.volumeId = volumeId;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setThumbFile(String thumbFile) {
        this.thumbFile = thumbFile;
    }

    public void setOriginalFilename(String originalFileName) {
        this.originalFilename = originalFileName;
    }

    public void setItem(Item item) {
        this.item = item;
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

        final ItemFile other = (ItemFile) o;

        if (dateCreated == null)
        {
            if (other.dateCreated != null)
                return false;
        }
        else if (!dateCreated.equals(other.dateCreated))
            return false;
        if (dateModified == null)
        {
            if (other.dateModified != null)
                return false;
        }
        else if (!dateModified.equals(other.dateModified))
            return false;
        if (fileInfo == null)
        {
            if (other.fileInfo != null)
                return false;
        }
        else if (!fileInfo.equals(other.fileInfo))
            return false;
        if (filename == null)
        {
            if (other.filename != null)
                return false;
        }
        else if (!filename.equals(other.filename))
            return false;
        if (fileSize == null)
        {
            if (other.fileSize != null)
                return false;
        }
        else if (!fileSize.equals(other.fileSize))
            return false;
        if (format == null)
        {
            if (other.format != null)
                return false;
        }
        else if (!format.equals(other.format))
            return false;
        if (originalFilename == null)
        {
            if (other.originalFilename != null)
                return false;
        }
        else if (!originalFilename.equals(other.originalFilename))
            return false;
        if (thumbFile == null)
        {
            if (other.thumbFile != null)
                return false;
        }
        else if (!thumbFile.equals(other.thumbFile))
            return false;
        if (userId == null)
        {
            if (other.userId != null)
                return false;
        }
        else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 49;
        result = 13 * result
                + ((dateCreated == null) ? 0 : dateCreated.hashCode());
        result = 13 * result
                + ((dateModified == null) ? 0 : dateModified.hashCode());
        result = 13 * result + ((fileInfo == null) ? 0 : fileInfo.hashCode());
        result = 13 * result + ((filename == null) ? 0 : filename.hashCode());
        result = 13 * result + ((fileSize == null) ? 0 : fileSize.hashCode());
        result = 13 * result + ((format == null) ? 0 : format.hashCode());
        result = 13
                * result
                + ((originalFilename == null) ? 0 : originalFilename.hashCode());
        result = 13 * result + ((thumbFile == null) ? 0 : thumbFile.hashCode());
        result = 13 * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("ID:                ").append(getId()).append("\n");
        sb.append("Filename:          ").append(getFilename()).append("\n");
        sb.append("File Size:         ").append(getFileSize()).append("\n");
        sb.append("File Info:         ").append(getFileInfo()).append("\n");
        sb.append("DCFormat:            ").append(getFormat().toString()).append(
                "\n");
        sb.append("Date Created:      ").append(getDateCreated().toString())
                .append("\n");
        sb.append("Date Modified:     ").append(getDateModified().toString())
                .append("\n");
        sb.append("Original Filename: ").append(getOriginalFilename()).append(
                "\n");
        sb.append("ThumbFile:         ").append(getThumbFile()).append("\n");
        sb.append("User ID:           ").append(getUserId());

        return sb.toString();
    }

}
