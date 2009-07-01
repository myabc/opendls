package org.opendls.model;

/**
 * ItemStatus enum
 *
 * <p>Enum representing the current status of an Item.</p>
 *
 * @author alexbcoles
 * @version 1.0
 */
public enum ItemStatus
{
    STAGED      ("Staged"), //
    PUBLISHED   ("Published"), //
    DELETED     ("Deleted");

    private final String label;

    ItemStatus(String label)
    {
        this.label = label;
    }

    /**
     *
     * @return label
     */
    public String getLabel()
    {
        return label;
    }

}
