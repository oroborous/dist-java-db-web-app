package edu.wctc.dao;

import edu.wctc.entity.DonutShop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DonutShopDAOImpl implements DonutShopDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<DonutShop> getDonutShops() {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get list of donut shops from query
        List<DonutShop> donutShopList = session.createQuery("from DonutShop", DonutShop.class).getResultList();

        // Return results
        return donutShopList;
    }

    @Override
    public DonutShop getDonutShop(int id) {
        // Get current Hibernate session
        Session session = sessionFactory.getCurrentSession();

        // Get donut shop by primary key
        DonutShop aShop = session.get(DonutShop.class, id);

        // Return results
        return aShop;
    }
}
