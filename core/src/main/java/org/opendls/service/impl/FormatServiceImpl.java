package org.opendls.service.impl;

import java.util.List;

import org.opendls.dao.FormatDao;
import org.opendls.model.dc.DCFormat;
import org.opendls.service.FormatService;

public class FormatServiceImpl implements FormatService
{
    private FormatDao formatDao;

    public void setFormatDao(FormatDao formatDao)
    {
        this.formatDao = formatDao;
    }

    public DCFormat getFormat(String formatId)
    {
        return formatDao.get(formatId);
    }

    public List<DCFormat> getFormats()
    {
        return formatDao.getAll();
    }

    public void removeFormat(String formatId)
    {
        formatDao.remove(formatId);
    }

    public void saveFormat(DCFormat format)
    {
        formatDao.save(format);
    }

}
