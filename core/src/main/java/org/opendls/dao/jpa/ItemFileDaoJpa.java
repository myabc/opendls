package org.opendls.dao.jpa;

import org.opendls.dao.ItemFileDao;
import org.opendls.model.ItemFile;

public class ItemFileDaoJpa extends GenericDaoJpa<ItemFile, String> implements ItemFileDao
{

    public ItemFileDaoJpa()
    {
        super(ItemFile.class);
    }

}
