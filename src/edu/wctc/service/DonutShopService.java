package edu.wctc.service;

import edu.wctc.entity.DonutShop;

import java.util.List;

public interface DonutShopService {
    List<DonutShop> getDonutShops();

    DonutShop getDonutShop(int id);
}
