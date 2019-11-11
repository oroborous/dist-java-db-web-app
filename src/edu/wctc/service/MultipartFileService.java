package edu.wctc.service;

import org.springframework.web.multipart.MultipartFile;

public interface MultipartFileService {
    void saveFile(MultipartFile file, String destDirectory, String destPath);
}
