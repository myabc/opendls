package org.opendls.service.impl;

import org.opendls.dao.ItemFileDao;
import org.opendls.model.ItemFile;

import org.jmock.Mock;

public class FileServiceImplTest extends BaseManagerMockTestCase
{
    private FileServiceImpl service = new FileServiceImpl();
    private Mock dao = null;

    @Override
    protected void setUp() throws Exception
    {
        dao = new Mock(ItemFileDao.class);
        service.setItemFileDao((ItemFileDao) dao.proxy());
    }

    @Override
    protected void tearDown() throws Exception
    {
        service = null;
    }

    public void testAddAndRemoveFile() throws Exception
    {
        ItemFile file = new ItemFile();
        file.setFilename("johnjpeg");
        file.setFileSize(233342);
        file.setVolumeId(1);
        file.setDateCreated(new java.util.Date());
        file.setDateModified(new java.util.Date());

//      set expected behavior on dao
        dao.expects(once()).method("save").with(same(file));

        service.saveFile(file);

        // verify expectations
        dao.verify();

        assertEquals(file.getFilename(), "johnjpeg");
        //assertEquals(file.getFileSize(), 233342);

//        if (log.isDebugEnabled())
//        {
//            log.debug("removing File...");
//        }

        dao.expects(once()).method("remove")
            .with(eq("XY"));

        service.removeFile("XY");

        // verify expectations
        dao.verify();

//        try
//        {
//            // set expectations
//            Throwable ex = new ObjectRetrievalFailureException(Collection.class, "XY");
//            dao.expects(once()).method("getFile")
//                .with(eq("XY")).will(throwException(ex));
//
//            file = service.getFile("XY");
//
//            // verify expectations
//            dao.verify();
//            fail("Collection with name 'Alaska Image Library' found in database");
//        }
//        catch (DataAccessException dae)
//        {
//            log.debug("Expected exception: " + dae.getMessage());
//            assertNotNull(dae);
//        }
    }
}
