package com.vector.udremaster.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static final String FILES_UPLOAD_DIR = "/files/";

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ConfigurableMimeFileTypeMap fileTypeMap;

    public FileUtils() {}

    public com.vector.udremaster.entity.File saveUploaded(MultipartFile file) throws IOException{

        if (!file.isEmpty()) {

            String uploadsPath =  request.getServletContext().getRealPath(FILES_UPLOAD_DIR);
            String path = request.getServletContext().getContextPath();
            if(! new File(uploadsPath).exists()) {
                new File(uploadsPath).mkdir();
            }
            String fileName = file.getOriginalFilename();
            String filePath = findFreeNameForName(uploadsPath + fileName);
            String fileType = fileTypeMap.getContentType(fileName);
            long fileSize = file.getSize();

            File destination = new File(filePath);
            file.transferTo(destination);

            return new com.vector.udremaster.entity.File(filePath, destination.getName(), fileName, fileType, fileSize);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "File is empty");
        }
    }

    private String findFreeNameForName(String filePath){

        if (new File(filePath).exists()) {
            int counter = 1;
            for(;;) {
                int i = filePath.length()-1;
                while (filePath.charAt(i) != '.') i--;
                if (new File(filePath.substring(0, i) + "(" + counter + ")" + filePath.substring(i, filePath.length())).exists()){
                    counter++;
                } else {
                    return filePath.substring(0, i) + "(" + counter + ")" + filePath.substring(i, filePath.length());
                }
            }
        }
        return filePath;
    }
}
