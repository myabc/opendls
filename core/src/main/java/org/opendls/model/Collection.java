package org.opendls.model;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.xml.sax.InputSource;

import com.allaire.wddx.WddxDeserializationException;
import com.allaire.wddx.WddxDeserializer;
import com.allaire.wddx.WddxSerializer;

/**
 * Collection
 *
 * <p>Represents a Collection of {@link Item} objects within the Digital Library System.</p>
 *
 * @author alexbcoles
 * @version 1.0
 */
@Entity
@Table(name = "libraries")
public class Collection implements Serializable
{
    private static final long serialVersionUID = -2857215655126991607L;
    private String id;
    private String name;
    private String userInterfaceString; // Internal WDDX String
    private String pageContentString;   // Internal WDDX String
    private PersonInfo contactPerson;
    private String contactTel;
    private String contactFax;
    private OrganizationInfo ownerOrganization;
    private Boolean showInList;
    private Set<Item> items = new HashSet<Item>();

    public Collection()
    {
    }

    /**
     * @return Returns the id.
     */
    @Id @GeneratedValue(generator = "custom-charincrement")
    @org.hibernate.annotations.GenericGenerator(
        name = "custom-charincrement",
        strategy = "org.opendls.persistence.hibernate.id.CharIncrementGenerator"
        )
    @Column(name = "library_Id", length = 2)
    public String getId()
    {
        return id;
    }

    // ---------------------------------------------------------------- Getters

    @Column(name = "libraryName", nullable = false)
    public String getName() {
        return name;
    }
//    public String userInterfaceString() { retu

    //    public String pageContentString;
    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name = "contactName", nullable = false)),
    @AttributeOverride(name = "email", column = @Column(name = "contactEmail", nullable = false))})
    public PersonInfo getContactPerson() {
        return contactPerson;
    }

    @Column(length = 50)
    public String getContactTel() {
        return contactTel;
    }

    @Column(length = 50)
    public String getContactFax() {
        return contactFax;
    }

    @Embedded
    @AttributeOverrides({
    @AttributeOverride(name = "name", column = @Column(name = "ownerName", nullable = false)),
    @AttributeOverride(name = "orgCode", column = @Column(name = "ownerOrgCode", nullable = false))})
    public OrganizationInfo getOwnerOrganization() {
        return ownerOrganization;
    }

    @Column
    public Boolean isShowInList() {
        return showInList;
    }

    @Transient
    public Boolean getShowInList() {
        return showInList;
    }

    // ---------------------------------------------------------------- Setters

    @SuppressWarnings("unused")
    public void setId(String id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

//    public void userInterfaceString; // Internal WDDX String
//    public void pageContentString;   // Internal WDDX String

    public void setContactPerson(PersonInfo contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public void setContactTel(String contactTel)
    {
        this.contactTel = contactTel;
    }

    public void setContactFax(String contactFax)
    {
        this.contactFax = contactFax;
    }

    public void setOwnerOrganization(OrganizationInfo ownerOrganization)
    {
        this.ownerOrganization = ownerOrganization;
    }

    public void setShowInList(Boolean showInList)
    {
        this.showInList = showInList;
    }

    /**
     * @return Returns the pageContent.
     */
    @SuppressWarnings("unused")
    private String getPageContentInternal()
    {
        return pageContentString;
    }

    @Transient
    public Content getPageContent()
    {
        Content pageContent = null;

        if (pageContentString != null)
        {
            InputSource source = new InputSource(
                    new StringReader(pageContentString));
            WddxDeserializer ds;

            try
            {
                ds = new WddxDeserializer("org.apache.xerces.parsers.SAXParser");
                Map<String, Object> contentMap = (Hashtable<String, Object>) ds.deserialize(source);
                pageContent = new Content(contentMap);
            }
            catch (WddxDeserializationException e)
            {
                // TODO: replace with log message
                System.out.println("getPageContent: " + e.getMessage());
            }
            catch (IOException e)
            {
                // e.getMessage();
            }
        }

        return pageContent;
    }



    /**
     * @return Returns the userInterface.
     */
    @SuppressWarnings("unused")
    private String getUserInterfaceInternal()
    {
        return userInterfaceString;
    }

    @Transient
    public UserInterface getUserInterface()
    {
        UserInterface userInterface =  null;

        if (userInterfaceString != null)
        {
            InputSource source = new InputSource(new StringReader(
                    userInterfaceString));
            WddxDeserializer ds;

            try
            {
                ds = new WddxDeserializer("org.apache.xerces.parsers.SAXParser");
                Map<String, Object> uiMap = (Hashtable<String, Object>) ds.deserialize(source);
                userInterface = new UserInterface(uiMap);
            }
            catch (WddxDeserializationException e)
            {
                // TODO: Make this into a log statmeent
                System.out.println("getUserInterface: " + e.getMessage());
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                //e.printStackTrace();
            }
        }

        return userInterface;
    }

    /**
     * @return returns the items in the collection
     */
    @OneToMany
    @JoinColumn(name = "library_Id")
    @SuppressWarnings("unused")
    private Set<Item> getItems()
    {
        return items;
    }
    /**
     * @return returns the items in the collection
     */
    @Transient
    public List<Item> getItemsList()
    {
        return (items != null) ? new ArrayList<Item>(items) : null;
    }



    /**
     * @param pageContent
     *            The pageContent to set.
     */
    @SuppressWarnings("unused")
    protected void setPageContentInternal(String pageContentInternal)
    {
        this.pageContentString = pageContentInternal;
    }

    /**
     * @param pageContent
     */
    public void setPageContent(Content pageContent)
    {
        if (pageContent != null)
        {
            WddxSerializer se = new WddxSerializer();
            StringWriter buf = new StringWriter();

            try
            {
                se.serialize(pageContent.getAsMap(), buf);
            }
            catch (NullPointerException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.pageContentString = buf.toString();
        }
    }

    /**
     * @param userInterface
     *            The userInterface to set.
     */
    @SuppressWarnings("unused")
    protected void setUserInterfaceInternal(String userInterfaceInternal)
    {
        this.userInterfaceString = userInterfaceInternal;
    }

    /**
     * @param userInterface
     */
    public void setUserInterface(UserInterface userInterface)
    {
        if (userInterface != null)
        {
            WddxSerializer se = new WddxSerializer();
            StringWriter buf = new StringWriter();

            try
            {
                se.serialize(userInterface.getAsMap(), buf);
            }
            catch (NullPointerException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            this.userInterfaceString = buf.toString();
        }
    }



    /**
     * @param items
     *            The items to set.
     */
    public void setItems(Set<Item> items)
    {
        this.items = items;
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

        final Collection collection = (Collection) o;

        if (name != null ? !name.equals(collection.getName()) : collection
                .getName() != null)
            return false;
        if (userInterfaceString != null ? !userInterfaceString
                .equals(collection.getUserInterfaceInternal()) : collection
                .getUserInterfaceInternal() != null)
            return false;
        if (pageContentString != null ? !pageContentString.equals(collection
                .getPageContentInternal())
                : collection.getPageContentInternal() != null)
            return false;
//        if (contactName != null ? !contactName.equals(collection
//                .getContactName()) : collection.getContactName() != null)
//            return false;
        if (contactPerson != null ? !contactPerson.equals(collection.getContactPerson()) : collection.getContactPerson() != null)
        if (contactTel != null ? !contactTel.equals(collection.getContactTel())
                : collection.getContactTel() != null)
            return false;
        if (contactFax != null ? !contactFax.equals(collection.getContactFax())
                : collection.getContactFax() != null)
            return false;
        if (ownerOrganization != null ? !ownerOrganization.equals(collection.getOwnerOrganization()) : collection.getOwnerOrganization() != null)
//        if (ownerName != null ? !ownerName.equals(collection.getOwnerName())
//                : collection.getOwnerName() != null)
//            return false;
//        if (ownerOrgCode != null ? !ownerOrgCode.equals(collection
//                .getOwnerOrgCode()) : collection.getOwnerOrgCode() != null)
            return false;
        if (showInList != null ? !showInList.equals(collection.isShowInList())
                : collection.isShowInList() != null)
            return false;

        return false;
    }

    @Override
    public int hashCode()
    {
        int result = 41;
        result = 12 * result + name.hashCode();
        result = 12 * result + userInterfaceString.hashCode();
        result = 12 * result + pageContentString.hashCode();
        result = 12 * result + contactPerson.hashCode();
        result = 12 * result + contactTel.hashCode();
        result = 12 * result + contactFax.hashCode();
        result = 12 * result + ownerOrganization.hashCode();
        result = 12 * result + showInList.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("ID:             ").append(getId()).append("\n");
        sb.append("Name:           ").append(getName()).append("\n");
        sb.append("User Interface: ").append(getUserInterface().toString())
                .append("\n");
        sb.append("Page Content:   ").append(getPageContent().toString())
                .append("\n");
        sb.append("Contact Person: ").append(getContactPerson().toString()).append("\n");
        sb.append("Contact Tel:    ").append(getContactTel()).append("\n");
        sb.append("Contact Fax:    ").append(getContactFax()).append("\n");
        sb.append("Owner Organization: ").append(getOwnerOrganization().toString()).append("\n");
        sb.append("Show in List:   ").append(isShowInList());
        return sb.toString();
    }

}
