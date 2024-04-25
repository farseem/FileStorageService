package com.farsim.filemanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.farsim.filemanager.StorageType.*;

@Slf4j
@Component
public class FileStorageFactory {
    @Autowired
    private LocalFileStorageService localFileStorageService;

    @Autowired
    private AwsFileStorageService awsS3FileStorageService;

    @Autowired
    private AzureFileStorageService azureFileStorageService;

    public FileStorageService getFileStorageService(String storageType) {
        log.info("Storage Type Selected: " + storageType);
        switch (StorageType.valueOf(storageType)) {
            case LOCAL_STORAGE:
                return localFileStorageService;
            case AWS_S3:
                return awsS3FileStorageService;
            case AZURE_BLOB:
                return azureFileStorageService;
            default:
                throw new IllegalArgumentException("Invalid storage type");
        }
    }
}
