package org.opendls.dao;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataAccessException;

import org.opendls.model.ItemFile;

public class ItemFileDaoTest extends BaseDaoTestCase
{
    private ItemFile file = null;
 private ItemFileDao dao;
    private FormatDao fdao;

 public void setItemFileDao(ItemFileDao itemFileDao)
    {
  this.dao = itemFileDao;
 }

    public void setFormatDao(FormatDao formatDao)
    {
        this.fdao = formatDao;
    }

//    public void testGetFiles()
//    {
//        file = new ItemFile();
//        file.setFileName("johnjpeg");
//
//        dao.saveFile(file);
//
//        assertTrue(dao.getAllFiles().size() >= 1);
//    }

    public void testFileExists() throws Exception
    {
        // TODO: implement me
    }

    public void testFileDoesNotExist() throws Exception
    {
       // TODO: implement me
    }

    public void testSaveFile() throws Exception
    {
        file = new ItemFile();
        file.setFilename("dls_92920129021.pdf");
        file.setOriginalFilename("john_researchdoc.pdf");
        file.setFileSize(233342);
        file.setVolumeId(1);
        file.setFormat(fdao.get("application/pdf"));
        file.setDateCreated(new java.util.Date());
        file.setDateModified(new java.util.Date());

        file = dao.save(file);
        assertTrue("primary key assigned", file.getId() != null);

        assertNotNull(file.getFilename());
    }

    public void testAddAndRemoveFile() throws Exception
    {
        file = new ItemFile();
        file.setFilename("dls_92920129285.jpg");
        file.setOriginalFilename("bill_duckpic.jpg");
        file.setFileSize(394520);
        file.setVolumeId(2);
        file.setFormat(fdao.get("image/jpeg"));
        file.setDateCreated(new java.util.Date());
        file.setDateModified(new java.util.Date());

        file = dao.save(file);

        file = dao.get(file.getId());

        assertTrue(file.getFilename().equals("dls_92920129285.jpg"));
        assertTrue(file.getFormat().getId().equals("image/jpeg"));

        log.debug("removing item...");

        dao.remove(file.getId());

        try
        {
            file = dao.get(file.getId());
            fail("ItemFile found in database");
        }
        catch (EntityNotFoundException dae)
        {
            log.debug("Expected exception: " + dae.getMessage());
            assertNotNull(dae);
        }
    }

}
