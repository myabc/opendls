package org.opendls.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrganizationInfo component.
 *
 * <p>Represents information about a Service organizational unit.</p>
 *
 * @author alexbcoles
 * @version 1.0
 */
@Embeddable
public class OrganizationInfo implements Serializable
{
    private static final long serialVersionUID = -4085507435830611762L;
    private String name;
    private Integer orgCode;    // FWS OrgCode


    public OrganizationInfo()
    {
    }

    public OrganizationInfo(String name, Integer orgCode)
    {
        this.name = name;
        this.orgCode = orgCode;
    }

    // ---------------------------------------------------------------- Getters

    @Column(length = 200)
    public String getName()
    {
        return name;
    }

    @Column(precision = 4)
    public Integer getOrgCode()
    {
        return orgCode;
    }

    // ---------------------------------------------------------------- Setters

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOrgCode(Integer orgCode)
    {
        this.orgCode = orgCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        final OrganizationInfo organizationInfo = (OrganizationInfo) o;

        if (name != null ? !name.equals(organizationInfo.getName())
                : organizationInfo.getName() != null) {
            return false;
        }
        if (orgCode != null ? !orgCode.equals(organizationInfo.getOrgCode()) : organizationInfo.getOrgCode() != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 54;
        result = 41 * result + name.hashCode();
        result = 41 + result + orgCode.hashCode();
        return result;
    }

}
