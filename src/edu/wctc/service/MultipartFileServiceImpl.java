package edu.wctc.service;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public class MultipartFileServiceImpl implements MultipartFileService {
    @Override
    public void saveFile(MultipartFile file, String destDirectory, String destPath) {
        String fileName = null;

        if (!file.isEmpty()) {
            try {
                // Need to store the image in the artifact directory...
                // (where the application is currently running)
                String artifactPath = destPath + "WEB-INF\\resources\\img\\" + destDirectory;

                // ... and the source code directory
                // (so it gets checked into GitHub)
                String sourcePath = destPath + "..\\..\\..\\web\\WEB-INF\\resources\\img\\" + destDirectory;

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
    }
}
