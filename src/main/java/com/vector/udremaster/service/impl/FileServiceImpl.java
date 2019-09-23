package com.vector.udremaster.service.impl;

import com.vector.udremaster.entity.File;
import com.vector.udremaster.repository.FileRepository;
import com.vector.udremaster.service.FileService;
import com.vector.udremaster.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@Repository
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepository fileRepository;

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private UserServiceImpl userService;

    @Override
    public void uploadFile(MultipartFile file, long ownerId) throws IOException {
        if (userService.existsById(ownerId)) {
            File uploadedFile = fileUtils.saveUploaded(file);
            uploadedFile.setOwnerId(ownerId);
            fileRepository.saveAndFlush(uploadedFile);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id ("+ownerId+")");
        }
    }

    @Override
    public File[] getUserFiles(long userId){
        if (userService.existsById(userId)){
            return fileRepository.getFilesByOwnerId(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid user id ("+userId+")");
        }
    }
}
