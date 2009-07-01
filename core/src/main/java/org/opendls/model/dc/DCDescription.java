package org.opendls.model.dc;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Transient;

/**
 * DCDescription component
 *
 * @author alexbcoles
 * @version 1.0
 *
 */
@Embeddable
public class DCDescription implements Serializable
{
    private static final long serialVersionUID = -6988332847966848604L;
    private String tableOfContents;
    private String abstractText;    // field cannot be 'abstract', since is a reserved word in Java

    public DCDescription()
    {
    }

    public DCDescription(String tableOfContents, String abstractText)
    {
        this.tableOfContents = tableOfContents;
        this.abstractText = abstractText;
    }

    @Lob
    @Column(name = "description_tableOfContents")
    public String getTableOfContents()
    {
        return tableOfContents;
    }

    @Lob
    @Column(name = "description_abstract")
    public String getAbstract()
    {
        return abstractText;
    }

    @Transient
    public String getAbstractText()
    {
        return getAbstract();
    }

    public void setTableOfContents(String tableOfContents)
    {
        this.tableOfContents = tableOfContents;
    }

    public void setAbstract(String abstractText)
    {
        this.abstractText = abstractText;
    }

    public void setAbstractText(String abstractText)
    {
        setAbstract(abstractText);
    }


}
