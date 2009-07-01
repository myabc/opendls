package org.opendls.service.impl;

import org.opendls.dao.FormatDao;
import org.opendls.model.dc.DCFormat;

import java.util.ArrayList;
import java.util.List;

import org.jmock.Mock;

public class FormatServiceImplTest extends BaseManagerMockTestCase
{
    private FormatServiceImpl service = new FormatServiceImpl();
    private Mock dao = null;
    private DCFormat format = null;

    @Override
    protected void setUp() throws Exception
    {
        dao = new Mock(FormatDao.class);
        service.setFormatDao((FormatDao) dao.proxy());
    }

    @Override
    protected void tearDown() throws Exception
    {
        service = null;
    }

    public void testGetFormat()
    {
        log.debug("testing getFormat");

        String id = "image/jpeg";
        format = new DCFormat();

        // set expected behavior on dao
        dao.expects(once()).method("get").with(eq(id))
                .will(returnValue(format));

        DCFormat result = service.getFormat(id);
        assertSame(format, result);
        dao.verify();
    }

    public void testGetFormats()
    {
        log.debug("testing getFormats");

        List<DCFormat> formats = new ArrayList<DCFormat>();

        // set expected behavior on dao
        dao.expects(once()).method("getAll").will(returnValue(formats));

        List result = service.getFormats();
        assertSame(formats, result);
        dao.verify();
    }

    public void testSaveFormat()
    {
        log.debug("testing saveFormat");

        format = new DCFormat();

        // set expected behavior on dao
        dao.expects(once()).method("save").with(same(format)).isVoid();

        service.saveFormat(format);
        dao.verify();
    }

    public void testRemoveFormat()
    {
        log.debug("testing removeFormat");

        String id = "image/mpeg";
        format = new DCFormat();

        // set expected behavior on dao
        dao.expects(once()).method("remove").with(eq(id)).isVoid();

        service.removeFormat(id);
        dao.verify();
    }
}
