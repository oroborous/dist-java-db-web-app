package edu.wctc.service;

import edu.wctc.dao.DonutReviewDAO;
import edu.wctc.entity.DonutReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DonutReviewServiceImpl implements DonutReviewService {
    @Autowired
    private DonutReviewDAO donutReviewDAO;

    @Override
    public void saveReview(DonutReview theReview) {
        donutReviewDAO.saveReview(theReview);
    }

    @Override
    public void deleteReview(int theId) {
        donutReviewDAO.deleteReview(theId);
    }
}
