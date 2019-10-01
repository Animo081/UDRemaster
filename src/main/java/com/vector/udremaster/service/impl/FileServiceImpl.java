package com.vector.udremaster.service.impl;

import com.vector.udremaster.entity.File;
import com.vector.udremaster.repository.FileRepository;
import com.vector.udremaster.service.FileService;
import com.vector.udremaster.service.UserService;
import com.vector.udremaster.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@Repository
public class FileServiceImpl implements FileService {

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private FileUtils fileUtils;

    @Autowired
    private UserService userService;

    @Override
    public void uploadFile(MultipartFile file, long ownerId) throws IOException {

        if (userService.existsById(ownerId)) {
            File uploadedFile = fileUtils.saveUploaded(file);
            uploadedFile.setOwnerId(ownerId);
            fileRepository.saveAndFlush(uploadedFile);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid user id ("+ownerId+")");
        }
    }

    @Override
    public List<File> getUserFiles(long userId, int page, int size)
            throws ChangeSetPersister.NotFoundException {
        Pageable pagination = PageRequest.of(page,size);
        return fileRepository.findAllByOwnerId(userId, pagination).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public long getFilesCount(long userId) {
        return fileRepository.countByOwnerId(userId);
    }
}
