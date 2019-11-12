package edu.wctc.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class ImageFileServiceImpl implements ImageFileService {
    @Override
    public String saveFile(MultipartFile file, String applicationPath, String imageDirectory) {
        String fileName = null;

        if (!file.isEmpty()) {
            try {
                // Need to store the image in the artifact directory...
                // (where the application is currently running)
                String artifactPath = applicationPath + "WEB-INF\\resources\\img\\" + imageDirectory;

                // ... and the source code directory
                // (so it gets checked into GitHub)
                String sourcePath = applicationPath + "..\\..\\..\\web\\WEB-INF\\resources\\img\\" + imageDirectory;

                // What is the name of the uploaded file?
                fileName = file.getOriginalFilename();

                // Transfer the uploaded file to the artifact directory
                File imageFile = new File(artifactPath, fileName);
                file.transferTo(imageFile);

                // Copy the uploaded file to the source directory
                File copyOfImage = new File(sourcePath, fileName);
                FileUtils.copyFile(imageFile, copyOfImage);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return fileName;
    }
}
