package edu.wctc.service;

import edu.wctc.dao.DonutShopDAO;
import edu.wctc.entity.DonutShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DonutShopServiceImpl implements DonutShopService {
    // inject Donut DAO
    @Autowired
    private DonutShopDAO donutShopDAO;

    @Override
    // with @Transactional annotation, no need to begin or commit transaction
    @Transactional
    public List<DonutShop> getDonutShops() {
        // Delegate call to DAO
        return donutShopDAO.getDonutShops();
    }

    @Override
    @Transactional
    public DonutShop getDonutShop(int id) {
        return donutShopDAO.getDonutShop(id);
    }

}
