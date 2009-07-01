package org.opendls.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.opendls.dao.FormatDao;
import org.opendls.model.dc.DCFormat;

public class FormatDaoJpa extends GenericDaoJpa<DCFormat, String> implements
        FormatDao
{

    public FormatDaoJpa()
    {
        super(DCFormat.class);
    }

    @Deprecated
    public Boolean checkFormatExists(String id)
    {
        return super.exists(id);
    }

    @SuppressWarnings("unchecked")
    public List<DCFormat> findByExtension(String ext)
    {
        Query q = entityManager.createQuery("select f from DCFormat f where f.defaultExtension = ?");
        q.setParameter(1, ext);
        return q.getResultList();
    }

}
