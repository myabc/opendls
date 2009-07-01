package org.opendls.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonInfo component
 *
 * <p>Represents information about an individual.</p>
 *
 * @author alexbcoles
 * @version 1.0
 */
@Embeddable
public class PersonInfo implements Serializable
{
    private static final long serialVersionUID = 7155854551342797238L;
    private String name;
    private String email;

    /**
     * Default constructor
     */
    public PersonInfo()
    {
    }

    /**
     * Full constructor
     *
     * @param name
     * @param email
     */
    public PersonInfo(String name, String email)
    {
        this.name = name;
        this.email = email;
    }

    /**
     * @return name
     */
    @Column(length = 200)
    public String getName()
    {
        return name;
    }

    /**
     * @return email
     */
    @Column(length = 100)
    public String getEmail()
    {
        return email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
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

        final PersonInfo person = (PersonInfo) o;

        if (name != null ? !name.equals(person.getName())
                : person.getName() != null)
            return false;
        if (email != null ? !email.equals(person.getEmail()) : person
                .getEmail() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 21;
        result = 82 * result + name.hashCode();
        result = 82 * result + email.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("Name:  ").append(getName()).append("\n");
        sb.append("Email: ").append(getEmail());

        return sb.toString();
    }
}
