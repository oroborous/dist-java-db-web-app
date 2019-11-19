package edu.wctc.service;

import edu.wctc.dao.DonutDAO;
import edu.wctc.entity.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class DonutServiceImpl implements DonutService {
    // inject Donut DAO
    @Autowired
    private DonutDAO donutDAO;

    // inject image saving service
    @Autowired
    private ImageFileService imageFileService;

    @Override
    // with @Transactional annotation, no need to begin or commit transaction
    @Transactional
    public List<Donut> getDonuts() {
        // Delegate call to DAO
        return donutDAO.getDonuts();
    }

    @Override
    @Transactional
    public void saveDonut(Donut theDonut, MultipartFile file, String applicationPath) {
        if (theDonut.getDateAdded() == null) {
            theDonut.setDateAdded(new Date());
        }

        String fileName = imageFileService.saveFile(file, applicationPath, theDonut.getShop().getImageDirectory());
        if (fileName != null) {
            theDonut.setImageFilename(fileName);
        }

        // Delegate call to DAO
        donutDAO.saveDonut(theDonut);

    }

    @Override
    @Transactional
    public Donut getDonut(int theId) {
        return donutDAO.getDonut(theId);
    }

    @Override
    @Transactional
    public void deleteDonut(int theId) {
        donutDAO.deleteDonut(theId);
    }

    @Override
    @Transactional
    public List<Donut> getDonutsByName(String theSearchTerm) {
        return donutDAO.getDonutsByName(theSearchTerm);
    }

    @Override
    public Donut getDonutAndReviews(int donutId) {
        Donut aDonut = donutDAO.getDonut(donutId);

        // Touch the first review to load the list
        if (!aDonut.getReviews().isEmpty()) {
            // Use the get method to force dependent objects to load
            // Must be done while session is open
            aDonut.getReviews().get(0);
        }

        return aDonut;
    }
}
