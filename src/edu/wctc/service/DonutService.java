package edu.wctc.service;

import edu.wctc.entity.Donut;

import java.util.List;

public interface DonutService {
    List<Donut> getDonuts();

    void saveDonut(Donut theDonut);
}
