package org.opendls.dao;

import org.opendls.model.dc.DCFormat;
import org.opendls.model.dc.DCType;

import java.util.List;

import javax.persistence.EntityNotFoundException;

public class FormatDaoTest extends BaseDaoTestCase
{
    private DCFormat format = null;
    private FormatDao dao = null;

    public void setFormatDao(FormatDao formatDao)
    {
        this.dao = formatDao;
    }

    public void testGetFormat() throws Exception
    {
        DCFormat format = dao.get("image/gif");

        assertNotNull(format);
        assertEquals(DCType.STILL_IMAGE, format.getType());
        assertTrue(format.getGenerateThumbnail());
    }

    public void testGetFormatInvalid() throws Exception
    {
        try
        {
            dao.get("non/existent.format");
            fail("'non existent format' found in database");
        }
        catch(EntityNotFoundException enfe)
        {
            log.debug("Expected exception: " + enfe.getMessage());
            assertNotNull(enfe);
        }
    }

    public void testGetFormats() throws Exception
    {
        assertTrue(dao.getAll().size() >= 1);
    }

    public void testFindByExtension() throws Exception
    {
        List<DCFormat> formats = dao.findByExtension("jpg");
        assertTrue(formats.size() > 0);
        assertFalse(formats.isEmpty());
    }

    public void testFindByExtensionInvalid() throws Exception
    {
        List<DCFormat> formats = dao.findByExtension("non/existent.format");
        assertEquals(0, formats.size());
        assertTrue(formats.isEmpty());
    }

    public void testFormatExists() throws Exception
    {
        assertTrue(dao.exists("image/gif"));
    }

    public void testFormatDoesNotExist() throws Exception
    {
        assertFalse(dao.exists("non/existent.format"));
    }

//    public void testSaveDuplicateFormat()
//    {
//        format = new DCFormat();
//        format.setId("image/jpeg");
//        format.setType(DCType.STILL_IMAGE);
//
//        // saving a duplicate DCFormat (with an id that already
//        // exists shouldn't work!
//        try
//        {
//            dao.save(format);
//            fail("Duplicate DCFormat should not be saved in database");
//        }
//        catch (EntityNotFoundException dae)
//        {
//            log.debug("Expected exception: " + dae.getMessage());
//            assertNotNull(dae);
//        }
//    }

    public void testSaveFormat() throws Exception
    {
        format = new DCFormat();
        format.setId("image/newjpeg");
        format.setName("A NewJPEG Image");
        format.setType(DCType.STILL_IMAGE);

        dao.save(format);

        assertTrue("primary key assigned", format.getId() != null);

        assertNotNull(format.getName());
    }

    public void testAddAndRemoveFormat() throws Exception
    {
        format = new DCFormat();
        format.setId("microsoft/proprietary");
        format.setName("MS Proprietary");
        format.setType(DCType.SOFTWARE);

        dao.save(format);

        assertNotNull(format.getId());
        assertEquals("MS Proprietary", format.getName());
        assertTrue(format.getType().equals(DCType.SOFTWARE));

        log.debug("removing format...");

        dao.remove(format.getId());
        endTransaction();

        try
        {
            format = dao.get(format.getId());
            fail("DCFormat found in database");
        }
        catch (EntityNotFoundException dae)
        {
            log.debug("Expected exception: " + dae.getMessage());
            assertNotNull(dae);
        }

    }

}
