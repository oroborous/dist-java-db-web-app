package edu.wctc.service;

import edu.wctc.entity.DonutReview;

import java.util.List;

public interface DonutReviewService {
    void saveReview(DonutReview theReview);

    void deleteReview(int theId);
}
