package com.vector.udremaster.controller;

import com.vector.udremaster.entity.File;
import com.vector.udremaster.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/media")
public class FileController {

    @Autowired
    private FileServiceImpl fileService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("userid") long userId, @RequestParam("file") MultipartFile file) throws IOException {
        fileService.uploadFile(file, userId);
    }

    /*@GetMapping("/download")
    @ResponseBody
    public FileSystemResource downloadFile(@RequestParam("fileid") long fileId) {
        String path = fileService.getFileUrl(fileId);
        return new FileSystemResource(path);
    }*/

    @ResponseBody
    @GetMapping(value = "/download", produces = "application/json")
    public File[] getUserFilesUrls(@RequestParam("userid") long userId){
        return fileService.getUserFiles(userId);
    }
}