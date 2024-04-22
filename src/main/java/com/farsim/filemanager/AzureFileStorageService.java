package com.farsim.filemanager;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AzureFileStorageService implements FileStorageService{
    @Override
    public void storeFile(String fileId, MultipartFile file) {

    }

    @Override
    public Resource loadFile(String fileId) {
        return null;
    }

    @Override
    public void deleteFile(String fileId) {

    }
}
