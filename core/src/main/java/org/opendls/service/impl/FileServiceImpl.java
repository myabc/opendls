package org.opendls.service.impl;

import java.util.List;

import org.opendls.dao.ItemFileDao;
import org.opendls.model.ItemFile;
import org.opendls.service.FileService;

public class FileServiceImpl implements FileService
{
    private ItemFileDao itemFileDao;

    public void setItemFileDao(ItemFileDao fileDao)
    {
        this.itemFileDao = fileDao;
    }

    public ItemFile getFile(String fileId)
    {
        return itemFileDao.get(fileId);
    }

    public List<ItemFile> getFiles()
    {
        return itemFileDao.getAll();
    }

    public void removeFile(String fileId)
    {
        itemFileDao.remove(fileId);
    }

    public void saveFile(ItemFile file)
    {
        itemFileDao.save(file);
    }

}
