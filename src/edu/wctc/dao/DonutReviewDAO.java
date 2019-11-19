package edu.wctc.dao;

import edu.wctc.entity.DonutReview;

public interface DonutReviewDAO {
    void saveReview(DonutReview theReview);

    void deleteReview(int theId);
}
