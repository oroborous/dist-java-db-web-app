package edu.wctc.service;

import edu.wctc.dao.DonutDAO;
import edu.wctc.entity.Donut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DonutServiceImpl implements DonutService {
    // inject Donut DAO
    @Autowired
    private DonutDAO donutDAO;

    @Override
    // with @Transactional annotation, no need to begin or commit transaction
    @Transactional
    public List<Donut> getDonuts() {
        // Delegate call to DAO
        return donutDAO.getDonuts();
    }

    @Override
    @Transactional
    public void saveDonut(Donut theDonut) {
        if (theDonut.getDateAdded() == null) {
            theDonut.setDateAdded(new Date());
        }

        // Delegate call to DAO
        donutDAO.saveDonut(theDonut);
    }
}
