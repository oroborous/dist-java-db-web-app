package edu.wctc.dao;

import edu.wctc.entity.DonutShop;

import java.util.List;

public interface DonutShopDAO {
    List<DonutShop> getDonutShops();

    DonutShop getDonutShop(int id);
}
