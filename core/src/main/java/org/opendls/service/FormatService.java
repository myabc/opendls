package org.opendls.service;

import java.util.List;

import org.opendls.model.dc.DCFormat;

public interface FormatService
{
    public List<DCFormat> getFormats();

    public DCFormat getFormat(String formatId);

    public void saveFormat(DCFormat format);

    public void removeFormat(String formatId);
}
