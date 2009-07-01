package org.opendls.model;

import org.opendls.model.dc.DCCoverage;
import org.opendls.model.dc.DCDescription;
import org.opendls.model.dc.DCLanguage;
import org.opendls.model.dc.DCRelations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

//import org.hibernate.annotations.GenericGenerator;
//import org.hibernate.annotations.Parameter;
//import org.hibernate.search.annotations.DocumentId;
//import org.hibernate.search.annotations.Indexed;

/**
 * Item
 *
 * <p>Represents a digital asset within the Digital Library System.</p>
 *
 * @author alexbcoles
 * @version 1.0
 */
@Entity
@Table(name = "data")
//@Indexed(index = "indexes/items")
public class Item implements Serializable
{
    private static final long serialVersionUID = 3686744260158018649L;
    private String id;
    private String title;
    private String titleAlternative;
    private String creator;
    private DCDescription description;
    private String subject;
    private String publisher;
    private OrganizationInfo contributor;
    private Date dateCreated;
    private Date dateValid;
    private Date dateAvailable;
    private Date dateIssued = new Date(); // defaults to 'now'
    private Date dateModified = new Date(); // defaults to 'now'
    private String source;
    private DCLanguage language = new DCLanguage(java.util.Locale.getDefault()
            .getISO3Country());
    private DCRelations relations;
    private DCCoverage coverage;
    private String rights;
    private String audience;
    private Collection collection;
    private ItemStatus status = ItemStatus.STAGED; // defaults to STAGED
    private PersonInfo dataCreator;
    private ItemFile thumbFile;
    private Set<ItemFile> files = new HashSet<ItemFile>();

    public Item()
    {
    }

    // ---------------------------------------------------------------- Getters

    @Id
    @Column(name = "data_Id", length = 35)
    @GeneratedValue(generator = "custom-uuid")
    @org.hibernate.annotations.GenericGenerator(
        name = "custom-uuid",
        strategy = "org.opendls.persistence.hibernate.id.UUIDGenerator"
    )
    //@DocumentId
    public String getId()
    {
        return id;
    }

    @Column(name = "title", length = 200, nullable = false)
    public String getTitle()
    {
        return title;
    }

    @Column(name = "title_alternative", length = 200)
    public String getTitleAlternative()
    {
        return titleAlternative;
    }

    @Column(name = "creator", length = 200)
    public String getCreator()
    {
        return creator;
    }

    @Embedded
    public DCDescription getDescription()
    {
        return description;
    }

    @Column(name = "subject", length = 255)
    public String getSubject()
    {
        return subject;
    }

    @Column(name = "publisher", length = 200)
    public String getPublisher()
    {
        return publisher;
    }

    @Embedded
    @AttributeOverrides( {
        @AttributeOverride(name = "name", column = @Column(name = "contributor")),
        @AttributeOverride(name = "orgCode", column = @Column(name = "contributor_orgCode")) })
    public OrganizationInfo getContributor()
    {
        return contributor;
    }

    @Column(name = "date_created")
    public Date getDateCreated()
    {
        return dateCreated;
    }

    @Column(name = "date_valid")
    public Date getDateValid()
    {
        return dateValid;
    }

    @Column(name = "date_available")
    public Date getDateAvailable()
    {
        return dateAvailable;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_issued", nullable = false, updatable = false)
    public Date getDateIssued()
    {
        return dateIssued;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modified", nullable = false)
    public Date getDateModified()
    {
        return dateModified;
    }

    @Column(name = "source", length = 200)
    public String getSource()
    {
        return source;
    }

    @org.hibernate.annotations.Type(type = "org.opendls.persistence.hibernate.usertype.DCLanguageUserType")
    @Column(name = "language_Id", length = 2, nullable = false)
    public DCLanguage getLanguage()
    {
        return language;
    }

    @Embedded
    public DCRelations getRelations()
    {
        return relations;
    }

    @Embedded
    public DCCoverage getCoverage()
    {
        return coverage;
    }

    @Column(name = "rights", length = 200)
    public String getRights()
    {
        return rights;
    }

    @Column(name = "audience")
    public String getAudience()
    {
        return audience;
    }

    @ManyToOne
    @JoinColumn(name = "library_Id", nullable = false)
    public Collection getCollection()
    {
        return collection;
    }

    @Enumerated(EnumType.ORDINAL)
    public ItemStatus getStatus()
    {
        return status;
    }

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name = "name", column = @Column(name = "dataCreator_name", nullable = false)),
            @AttributeOverride(name = "email", column = @Column(name = "dataCreator_email", nullable = false)) })
    public PersonInfo getDataCreator()
    {
        return dataCreator;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "thumbIndex", joinColumns = @JoinColumn(name = "data_Id"), inverseJoinColumns = @JoinColumn(name = "file_Id"))
    public ItemFile getThumbFile()
    {
        return thumbFile;
    }

    @OneToMany(mappedBy = "item")
    @JoinTable(name = "dfIndex", joinColumns = @JoinColumn(name = "data_Id"), inverseJoinColumns = @JoinColumn(name = "file_Id"))
    public Set<ItemFile> getFiles()
    {
        return files;
    }

    // ---------------------------------------------------------------- Setters

    @SuppressWarnings("unused")
    private void setId(String id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setTitleAlternative(String titleAlternative) { this.titleAlternative = titleAlternative; }
    public void setCreator(String creator) { this.creator = creator; }
    public void setDescription(DCDescription description) { this.description = description; }
    public void setSubject(String subject){ this.subject = subject; }
    public void setPublisher(String publisher){ this.publisher = publisher; }
    public void setContributor(OrganizationInfo contributor){ this.contributor = contributor; }
    @SuppressWarnings("unused")
    private void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }
    public void setDateValid(Date dateValid) { this.dateValid = dateValid; }
    public void setDateAvailable(Date dateAvailable) { this.dateAvailable = dateAvailable; }
    public void setDateIssued(Date dateIssued) { this.dateIssued = dateIssued; }
    public void setDateModified(Date dateModified){ this.dateModified = dateModified; }
    public void setSource(String source) { this.source = source; }
    public void setLanguage(DCLanguage language) { this.language = language; }
    public void setRelations(DCRelations relations) { this.relations = relations; }
    public void setCoverage(DCCoverage coverage) { this.coverage = coverage; }
    public void setRights(String rights) { this.rights = rights; }
    public void setAudience(String audience) { this.audience = audience; }
    public void setCollection(Collection collection) { this.collection = collection; }
    public void setStatus(ItemStatus status){ this.status = status; }
    public void setDataCreator(PersonInfo dataCreator) { this.dataCreator = dataCreator; }
    public void setThumbFile(ItemFile thumbFile) { this.thumbFile = thumbFile; }

    /**
     * @param files
     */
    @SuppressWarnings("unused")
    private void setFiles(Set<ItemFile> files)
    {
        this.files = files;
    }

    /**
     * Add a new ItemFile to an Item
     *
     * @param newFile
     */
    public void addFile(ItemFile newFile)
    {
        if (newFile == null)
            throw new IllegalArgumentException("Null file");
        this.getFiles().add(newFile);
    }

    /**
     * Add a List of ItemFile to an Item
     *
     * @param fileList
     */
    public void setFileList(List<ItemFile> fileList)
    {
        if (fileList == null)
            throw new IllegalArgumentException("Null list");
        this.getFiles().addAll(fileList);
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

        final Item item = (Item) o;

        if (title != null ? !title.equals(item.getTitle())
                : item.getTitle() != null)
            return false;
        if (titleAlternative != null ? !titleAlternative.equals(item
                .getTitleAlternative()) : item.getTitleAlternative() != null)
            return false;
        if (creator != null ? !creator.equals(item.getCreator()) : item
                .getCreator() != null)
            return false;
         if (description != null ? !description.equals(item.getDescription())
         : item.getDescription() !=null) return false;
        if (subject != null ? !subject.equals(item.getSubject()) : item
                .getSubject() != null)
            return false;
        if (publisher != null ? !publisher.equals(item.getPublisher()) : item
                .getPublisher() != null)
            return false;
        if (contributor != null ? !contributor.equals(item.getContributor())
                : item.getContributor() != null)
            return false;
        if (dateCreated != null ? !dateCreated.equals(item.getDateCreated())
                : item.getDateCreated() != null)
            return false;
        if (dateValid != null ? !dateValid.equals(item.getDateValid()) : item
                .getDateValid() != null)
            return false;
        if (dateAvailable != null ? !dateAvailable.equals(item
                .getDateAvailable()) : item.getDateAvailable() != null)
            return false;
        if (dateIssued != null ? !dateIssued.equals(item.getDateIssued())
                : item.getDateIssued() != null)
            return false;
        if (dateModified != null ? !dateModified.equals(item.getDateModified())
                : item.getDateModified() != null)
            return false;
        if (source != null ? !source.equals(item.getSource()) : item
                .getSource() != null)
            return false;
        if (language != null ? !language.equals(item.getLanguage()) : item
                .getLanguage() != null)
            return false;
        if (relations != null ? !relations.equals(item.getRelations()) : item
                .getRelations() != null)
            return false;
        if (coverage != null ? !coverage.equals(item.getCoverage()) : item
                .getCoverage() != null)
            return false;
        if (rights != null ? !rights.equals(item.getRights()) : item
                .getRights() != null)
            return false;
        if (audience != null ? !audience.equals(item.getAudience()) : item
                .getAudience() != null)
            return false;
        if (collection != null ? !collection.equals(item.getCollection())
                : item.getCollection() != null)
            return false;
        if (status != null ? !status.equals(item.getStatus()) : item
                .getStatus() != null)
            return false;
        if (dataCreator != null ? !dataCreator.equals(item.getDataCreator())
                : item.getDataCreator() != null)
            return false;
        if (thumbFile != null ? !thumbFile.equals(item.getThumbFile()) : item
                .getThumbFile() != null)
            return false;
        if (files != null ? !files.equals(item.getFiles())
                : item.getFiles() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 66;
        result = 32 * result + title.hashCode();
        result = 32 * result + titleAlternative.hashCode();
        result = 32 * result + creator.hashCode();
        result = 32 * result + description.hashCode();
        result = 32 * result + subject.hashCode();
        result = 32 * result + publisher.hashCode();
        result = 32 * result + contributor.hashCode();
        result = 32 * result + dateCreated.hashCode();
        result = 32 * result + dateValid.hashCode();
        result = 32 * result + dateAvailable.hashCode();
        result = 32 * result + dateIssued.hashCode();
        result = 32 * result + dateModified.hashCode();
        result = 32 * result + source.hashCode();
        result = 32 * result + language.hashCode();
        result = 32 * result + relations.hashCode();
        result = 32 * result + coverage.hashCode();
        result = 32 * result + rights.hashCode();
        result = 32 * result + audience.hashCode();
        //result = 32 * result + collection.hashCode();
        result = 32 * result + status.hashCode();
        result = 32 * result + dataCreator.hashCode();
        result = 32 * result + thumbFile.hashCode();
        result = 32 * result + files.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("ID:                   ").append(getId()).append("\n");
        sb.append("Title:                ").append(getTitle()).append("\n");
        sb.append("Title Alternative:    ").append(getTitleAlternative())
                .append("\n");
        sb.append("Creator:              ").append(getCreator()).append("\n");
        sb.append("\nDescription: ").append(getDescription()).append("\n");
        sb.append("Subject:              ").append(getSubject()).append("\n");
        sb.append("Publisher:            ").append(getPublisher()).append("\n");
        sb.append("Contributor:          ").append(getContributor()).append(
                "\n");
//        sb.append("Contributor OrgCode:  ").append(getContributorOrgCode())
//                .append("\n");
        sb.append("Date Created:         ").append(getDateCreated().toString())
                .append("\n");
        sb.append("Date Valid:           ").append(getDateValid().toString())
                .append("\n");
        sb.append("Date Available:       ").append(
                getDateAvailable().toString()).append("\n");
        sb.append("Date Issued:          ").append(getDateIssued().toString())
                .append("\n");
        sb.append("Date Modified:        ")
                .append(getDateModified().toString()).append("\n");
        sb.append("Source:               ").append(getSource()).append("\n");
        sb.append("Language:             ").append(getLanguage().toString())
                .append("\n");
        sb.append("DCRelations:            ").append(getRelations().toString())
                .append("\n");
        sb.append("DCCoverage:             ").append(getCoverage().toString())
                .append("\n");
        sb.append("Rights:               ").append(getRights()).append("\n");
        sb.append("Audience:             ").append(getAudience()).append("\n");
        //sb.append("Collection:           ").append(getCollection().toString())
        //        .append("\n");
        // sb.append("").append(getStatus()).append("\n");
        sb.append("Data Creator:         ").append(getDataCreator()).append(
                "\n");
        sb.append("ThumbFile:            ").append(getThumbFile().toString());
        // sb.append("").append(getFiles()).append("\n");

        return sb.toString();
    }

}
