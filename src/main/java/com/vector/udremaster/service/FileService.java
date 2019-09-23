package com.vector.udremaster.service;

import com.vector.udremaster.entity.File;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    void uploadFile(MultipartFile file, long ownerId) throws IOException;

    List<File> getUserFiles(long userId) throws ChangeSetPersister.NotFoundException;
}
