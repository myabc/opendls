package org.opendls.dao;

import java.util.List;

import org.opendls.model.dc.DCFormat;

public interface FormatDao extends GenericDao<DCFormat, String>
{
    // standard CRUD is inherited from GenericDao

    public List<DCFormat> findByExtension(String ext);

    public Boolean checkFormatExists(String id);

}
