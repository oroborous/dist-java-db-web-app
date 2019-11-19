package edu.wctc.dao;

import edu.wctc.entity.DonutReview;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DonutReviewDAOImpl implements DonutReviewDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    @Transactional
    public void saveReview(DonutReview theReview) {
        Session session = factory.getCurrentSession();

        // Creates if object's ID isn't set, updates if it is
        session.saveOrUpdate(theReview);
    }

    @Override
    @Transactional
    public void deleteReview(int theId) {
        Session session = factory.getCurrentSession();

        Query query = session.createQuery("delete from DonutReview where id = :doomedReviewId");

        query.setParameter("doomedReviewId", theId);

        query.executeUpdate();
    }
}
