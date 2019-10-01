package com.vector.udremaster.vsya_fignya;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.vector.udremaster.utils.FileUtils.FILES_UPLOAD_DIR;

@Configuration
@CrossOrigin(origins = "http://localhost:4200")
@EnableWebMvc
public class ResourcesConfiguration implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/files/**")
                .addResourceLocations(FILES_UPLOAD_DIR);
    }
}

