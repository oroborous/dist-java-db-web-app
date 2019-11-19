package edu.wctc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int id;
    @Column(name = "nm")
    private String name;
    @Column(name = "state")
    private String state;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name="donut_shop_city",
    joinColumns = @JoinColumn(name="city_id"),
    inverseJoinColumns = @JoinColumn(name="shop_id"))
    private List<DonutShop> shops;

    public City() {
        // no-argument constructor
    }

    public City(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public void add(DonutShop tempShop) {
        if (shops == null) {
            shops = new ArrayList<>();
        }
        shops.add(tempShop);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<DonutShop> getShops() {
        return shops;
    }

    public void setShops(List<DonutShop> shops) {
        this.shops = shops;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
