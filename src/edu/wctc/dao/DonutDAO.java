package edu.wctc.dao;


import edu.wctc.entity.Donut;

import java.util.List;

public interface DonutDAO {
    List<Donut> getDonuts();

    void saveDonut(Donut theDonut);

    Donut getDonut(int theId);

    void deleteDonut(int theId);

    List<Donut> getDonutsByName(String theSearchTerm);
}
