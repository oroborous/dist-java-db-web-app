package edu.wctc.dao;

import edu.wctc.entity.Donut;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonutDAOImpl implements DonutDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Donut> getDonuts() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Create a query
        Query<Donut> query = session.createQuery("from Donut", Donut.class);

        // Get list of donuts from query
        List<Donut> donutList = query.getResultList();

        // Return results
        return donutList;
    }

    @Override
    public void saveDonut(Donut theDonut) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // save the donut
        session.save(theDonut);
    }
}
