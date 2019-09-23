package com.vector.udremaster.service;

import com.vector.udremaster.entity.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    void uploadFile(MultipartFile file, long ownerId) throws IOException;

    File[] getUserFiles(long userId);
}
