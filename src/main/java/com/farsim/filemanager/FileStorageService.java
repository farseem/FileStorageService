package com.farsim.filemanager;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void storeFile(String fileId, MultipartFile file);
    Resource loadFile(String fileId);
    void deleteFile(String fileId);
}
