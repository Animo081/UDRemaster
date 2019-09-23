package com.vector.udremaster.controller;

import com.vector.udremaster.entity.File;
import com.vector.udremaster.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileServiceImpl fileService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam("userid") long userId, @RequestParam("file") MultipartFile file) throws IOException {
        fileService.uploadFile(file, userId);
    }

    @ResponseBody
    @GetMapping(value = "/download", produces = "application/json")
    public List<File> getUserFilesUrls(@RequestParam("userid") long userId) throws ChangeSetPersister.NotFoundException {
        return fileService.getUserFiles(userId);
    }
}