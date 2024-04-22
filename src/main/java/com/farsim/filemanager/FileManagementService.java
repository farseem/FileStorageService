package com.farsim.filemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileManagementService {
    @Autowired
    private FileStorageFactory fileStorageFactory;

    public void storeFile(String storageType, String fileId, MultipartFile file) {
        FileStorageService storageService = fileStorageFactory.getFileStorageService(storageType);
        storageService.storeFile(fileId, file);
    }

    public Resource loadFile(String storageType, String fileId) {
        FileStorageService storageService = fileStorageFactory.getFileStorageService(storageType);
        return storageService.loadFile(fileId);
    }

    public void deleteFile(String storageType, String fileId) {
        FileStorageService storageService = fileStorageFactory.getFileStorageService(storageType);
        storageService.deleteFile(fileId);
    }
}
