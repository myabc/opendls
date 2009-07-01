package org.opendls.model.dc;

import java.util.ArrayList;
import java.util.List;

/**
 * DCType enum
 *
 * <p>
 * DCType contains an id field, for compatibility with the legacy database.
 * <br/> It replaces the legacy database table
 * <dt>types</dt>: Dublin Core type values are now defined statically,
 * primarily to allow them to be referenced easily in programmatic code:
 *
 * <code>if (type = DCType.SERVICE)</code>
 *
 * There may be some performance benefits with this design.
 *
 * However, because of the following issues, an instance of DCType can
 * not be referenced by its ordinal from the linked <dt>formats</dt>
 * table:
 * <ul>
 *  <li>there was no value with an id of 11 in the legacy DB</li>
 *  <li>ordinals begin with 0. 'types' table id values start at 1</li>
 * </ul>
 * </p>
 *
 * @author alexbcoles
 *
 */
public enum DCType
{
    COLLECTION           (1, "collection"), // 1
    DATASET              (2, "dataset"), // 2
    EVENT                (3, "event"), // 3
    INTERACTIVE_RESOURCE (4, "interactive_resource"), // 4
    INTERNET             (5, "internet"), // 5
    MAP                  (6, "map"), // 6
    OBJECT               (7, "object"), // 7
    SERVICE              (8, "service"), // 8
    SOFTWARE             (9, "software"), // 9
    SOUND                (10, "sound"), // 10
    TEXT                 (12, "text"), // 12
    VIDEO                (13, "video"), // 13
    STILL_IMAGE          (14, "still_image"); // 14

    private final int id;
    private final String key;
    private static final List<DCType> types = new ArrayList<DCType>();

    static
    {
        for(DCType type : DCType.values())
        {
            types.add(type);
        }
    }

    DCType(int id, String key)
    {
        this.id = id;
        this.key = key;
    }

    public int getId()
    {
        return id;
    }

    public String getKey()
    {
        return key;
    }

    // legacy database values require us to return an instanced based
    // on the database value (represented as id) and NOT the ordinality
    // of the enum.
    public static DCType getInstance(int id)
    {
        for(DCType type : DCType.values())
        {
            if(type.id == id)
                return type;
        }
        throw new IllegalArgumentException("No such " + DCType.class.getName());
    }

}
