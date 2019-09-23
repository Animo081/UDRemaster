package com.vector.udremaster.vsya_fignya;

import com.vector.udremaster.utils.FileUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.ConfigurableMimeFileTypeMap;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Configuration
public class BeansConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MessageDigestPasswordEncoder("MD5");
    }

    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }

    @Bean
    public FileUtils fileUtils() { return new FileUtils(); }

    @Bean
    public ConfigurableMimeFileTypeMap configurableMimeFileTypeMap() {

        ConfigurableMimeFileTypeMap configurableMimeFileTypeMap = new ConfigurableMimeFileTypeMap();
        configurableMimeFileTypeMap.setMappings(new String[]{
                "image/x-generic bmp jpg jpeg png tif tiff xpm wmf emf",
                "image/jpeg jpeg jpg jpe JPG",
                "image/gif gif GIF",
                "text/plain txt text TXT TEXT",
                "video/x-generic wmv mpeg mp4 ogv swf mov dvd osp",
                "video/mpeg mpeg mpg mpe mpv vbs mpegv",
                "video/msvideo avi",
                "audio/mpeg mp3 mpeg3"});

        return configurableMimeFileTypeMap;
    }
}
