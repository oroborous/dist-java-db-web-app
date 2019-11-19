package edu.wctc.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="donut_review")
public class DonutReview {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="review_id")
    private int id;

    @Column(name="review")
    private String review;

    @Column(name="stars")
    private double stars;

    @Column(name="review_date")
    private Date reviewDate;

    public DonutReview() {
        // no-arg constructor
    }

    public DonutReview(String review, double stars, Date reviewDate) {
        this.review = review;
        this.stars = stars;
        this.reviewDate = reviewDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "DonutReview{" +
                "id=" + id +
                ", review='" + review + '\'' +
                ", stars=" + stars +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
