package org.opendls.model.dc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * DCRelations component
 *
 * @author alexbcoles
 * @version 1.0
 */
@Embeddable
public class DCRelations implements Serializable
{
    private static final long serialVersionUID = 912037871854828467L;
    private String isVersionOf;
    private String hasVersion;
    private String isReplacedBy;
    private String replaces;
    private String isRequiredBy;
    private String requires;
    private String isPartOf;
    private String hasPart;
    private String isReferencedBy;
    private String references;
    private String isFormatOf;
    private String hasFormat;

    // ----------------------------------------------------------------- Getters

    @Column(name = "relation_isVersionOf", length = 200)
    public String getIsVersionOf()
    {
        return isVersionOf;
    }

    @Column(name = "relation_hasVersion", length = 200)
    public String getHasVersion()
    {
        return hasVersion;
    }

    @Column(name = "relation_isReplacedBy", length = 200)
    public String getIsReplacedBy()
    {
        return isReplacedBy;
    }

    @Column(name = "relation_replaces", length = 200)
    public String getReplaces()
    {
        return replaces;
    }

    @Column(name = "relation_isRequiredBy", length = 200)
    public String getIsRequiredBy()
    {
        return isRequiredBy;
    }

    @Column(name = "relation_requires", length = 200)
    public String getRequires()
    {
        return requires;
    }

    @Column(name = "relation_isPartOf", length = 200)
    public String getIsPartOf()
    {
        return isPartOf;
    }

    @Column(name = "relation_hasPart", length = 200)
    public String getHasPart()
    {
        return hasPart;
    }

    @Column(name = "relation_isReferencedBy", length = 200)
    public String getIsReferencedBy()
    {
        return isReferencedBy;
    }

    @Column(name = "relation_references", length = 200)
    public String getReferences()
    {
        return references;
    }

    @Column(name = "relation_isFormatOf", length = 200)
    public String getIsFormatOf()
    {
        return isFormatOf;
    }

    @Column(name = "relation_hasFormat", length = 200)
    public String getHasFormat()
    {
        return hasFormat;
    }

    // ----------------------------------------------------------------- Setters

    public void setIsVersionOf(String isVersionOf) { this.isVersionOf = isVersionOf; }
    public void setHasVersion(String hasVersion) { this.hasVersion = hasVersion; }
    public void setIsReplacedBy(String isReplacedBy) { this.isReplacedBy = isReplacedBy; }
    public void setReplaces(String replaces) { this.replaces = replaces; }
    public void setIsRequiredBy(String isRequiredBy) { this.isRequiredBy = isRequiredBy; }
    public void setRequires(String requires) { this.requires = requires; }
    public void setIsPartOf(String isPartOf) { this.isPartOf = isPartOf; }
    public void setHasPart(String hasPart) { this.hasPart = hasPart; }
    public void setIsReferencedBy(String isReferencedBy) { this.isReferencedBy = isReferencedBy; }
    public void setReferences(String references) { this.references = references; }
    public void setIsFormatOf(String isFormatOf) { this.isFormatOf = isFormatOf; }
    public void setHasFormat(String hasFormat) { this.hasFormat = hasFormat; }

    @Override
    public boolean equals(Object o)
    {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        final DCRelations relations = (DCRelations) o;

        if (isVersionOf != null ? !isVersionOf.equals(relations
                .getIsVersionOf()) : relations.getIsVersionOf() != null)
            return false;
        if (hasVersion != null ? !hasVersion.equals(relations.getHasVersion())
                : relations.getHasVersion() != null)
            return false;
        if (isReplacedBy != null ? !isReplacedBy.equals(relations
                .getIsReplacedBy()) : relations.getIsReplacedBy() != null)
            return false;
        if (replaces != null ? !replaces.equals(relations.getReplaces())
                : relations.getReplaces() != null)
            return false;
        if (isRequiredBy != null ? !isRequiredBy.equals(relations
                .getIsRequiredBy()) : relations.getIsRequiredBy() != null)
            return false;
        if (requires != null ? !requires.equals(relations.getRequires())
                : relations.getRequires() != null)
            return false;
        if (isPartOf != null ? !isPartOf.equals(relations.getIsPartOf())
                : relations.getIsPartOf() != null)
            return false;
        if (hasPart != null ? !hasPart.equals(relations.getHasPart())
                : relations.getHasPart() != null)
            return false;
        if (isReferencedBy != null ? !isReferencedBy.equals(relations
                .getIsReferencedBy()) : relations.getIsReferencedBy() != null)
            return false;
        if (references != null ? !references.equals(relations.getReferences())
                : relations.getReferences() != null)
            return false;
        if (isFormatOf != null ? !isFormatOf.equals(relations.getIsFormatOf())
                : relations.getIsFormatOf() != null)
            return false;
        if (hasFormat != null ? !hasFormat.equals(relations.getHasFormat())
                : relations.getHasFormat() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 21;
        result = 53 * result
                + (isVersionOf != null ? isVersionOf.hashCode() : 0);
        result = 53 * result + (hasVersion != null ? hasVersion.hashCode() : 0);
        result = 53 * result
                + (isReplacedBy != null ? isReplacedBy.hashCode() : 0);
        result = 53 * result + (replaces != null ? replaces.hashCode() : 0);
        result = 53 * result
                + (isRequiredBy != null ? isRequiredBy.hashCode() : 0);
        result = 53 * result + (requires != null ? requires.hashCode() : 0);
        result = 53 * result + (isPartOf != null ? isPartOf.hashCode() : 0);
        result = 53 * result + (hasPart != null ? hasPart.hashCode() : 0);
        result = 53 * result
                + (isReferencedBy != null ? isReferencedBy.hashCode() : 0);
        result = 53 * result + (references != null ? references.hashCode() : 0);
        result = 53 * result + (isFormatOf != null ? isFormatOf.hashCode() : 0);
        result = 53 * result + (hasFormat != null ? hasFormat.hashCode() : 0);
        return result;
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("Is Version Of:    ").append(getIsVersionOf()).append("\n");
        sb.append("Has Version:      ").append(getHasVersion()).append("\n");
        sb.append("Is Replaced By:   ").append(getIsReplacedBy()).append("\n");
        sb.append("Replaces:         ").append(getReplaces()).append("\n");
        sb.append("Is Required By:   ").append(getIsRequiredBy()).append("\n");
        sb.append("Requires:         ").append(getRequires()).append("\n");
        sb.append("Is Part Of:       ").append(getIsPartOf()).append("\n");
        sb.append("Has Part:         ").append(getHasPart()).append("\n");
        sb.append("Is Referenced By: ").append(getIsReferencedBy())
                .append("\n");
        sb.append("References:       ").append(getReferences()).append("\n");
        sb.append("Is DCFormat Of:     ").append(getIsFormatOf()).append("\n");
        sb.append("Has DCFormat:       ").append(getHasFormat());

        return sb.toString();
    }

}
