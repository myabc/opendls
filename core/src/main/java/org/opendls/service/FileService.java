package org.opendls.service;

import org.opendls.model.ItemFile;

import java.util.List;

public interface FileService
{
    public List<ItemFile> getFiles();

    public ItemFile getFile(String fileId);

    public void saveFile(ItemFile file);

    public void removeFile(String fileId);
}
