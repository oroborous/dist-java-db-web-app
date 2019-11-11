package edu.wctc.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donut_shop")
public class DonutShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shop_id")
    private int id;
    @Column(name = "nm")
    private String name;
    @Column(name = "img_directory")
    private String imageDirectory;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private DonutShopDetail detail;

    @OneToMany(mappedBy = "shop",
            cascade = CascadeType.ALL)
    private List<Donut> donuts;

    @ManyToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinTable(name="donut_shop_city",
            joinColumns = @JoinColumn(name="shop_id"),
            inverseJoinColumns = @JoinColumn(name="city_id"))
    private List<City> cities;

    public DonutShop() {

    }

    public DonutShop(String name, String imageDirectory) {
        this.name = name;
        this.imageDirectory = imageDirectory;
    }

    public void add(City tempCity) {
        if (cities == null) {
            cities = new ArrayList<>();
        }
        cities.add(tempCity);
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void add(Donut tempDonut) {
        if (donuts == null) {
            donuts = new ArrayList<>();
        }
        donuts.add(tempDonut);
        tempDonut.setShop(this);
    }

    public List<Donut> getDonuts() {
        return donuts;
    }

    public void setDonuts(List<Donut> donuts) {
        this.donuts = donuts;
    }

    public DonutShopDetail getDetail() {
        return detail;
    }

    public void setDetail(DonutShopDetail detail) {
        this.detail = detail;
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

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    @Override
    public String toString() {
        return "DonutShop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageDirectory='" + imageDirectory + '\'' +
                ", detail=" + detail +
                '}';
    }
}
