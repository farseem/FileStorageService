package com.farsim.filemanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileStorageFactory {
    @Autowired
    private LocalFileStorageService localFileStorageService;

    @Autowired
    private AwsFileStorageService awsS3FileStorageService;

    @Autowired
    private AzureFileStorageService azureFileStorageService;

    public FileStorageService getFileStorageService(String storageType) {
        switch (storageType) {
            case "local":
                return localFileStorageService;
            case "aws":
                return awsS3FileStorageService;
            case "azure":
                return azureFileStorageService;
            default:
                throw new IllegalArgumentException("Invalid storage type");
        }
    }
}
