package com.farsim.filemanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class AwsFileStorageService implements FileStorageService {
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
