package com.farsim.filemanager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileManagementService fileManagementService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        String fileId = String.valueOf(Math.random()); // generate unique file ID

        log.info("Test end point!");
        return ResponseEntity.ok(fileId);
    }

    @PostMapping("/{storageType}")
    public ResponseEntity<String> uploadFile(@PathVariable String storageType, @RequestParam("file") MultipartFile file) {
        String fileId = String.valueOf(Math.random()); // generate unique file ID
        // fileManagementService.storeFile(storageType, fileId, file);
        return ResponseEntity.ok(fileId);
    }

    @GetMapping("/{storageType}/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String storageType, @PathVariable String fileId) {
        Resource resource = fileManagementService.loadFile(storageType, fileId);
        // You may need to add content type, length, etc. headers
        return ResponseEntity.ok().body(resource);
    }

    @DeleteMapping("/{storageType}/{fileId}")
    public ResponseEntity<String> deleteFile(@PathVariable String storageType, @PathVariable String fileId) {
        fileManagementService.deleteFile(storageType, fileId);
        return ResponseEntity.ok("File deleted successfully");
    }
}