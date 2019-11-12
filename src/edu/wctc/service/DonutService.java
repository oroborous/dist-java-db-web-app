package edu.wctc.service;

import edu.wctc.entity.Donut;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DonutService {
    List<Donut> getDonuts();

    void saveDonut(Donut theDonut, MultipartFile file, String applicationPath);
}
