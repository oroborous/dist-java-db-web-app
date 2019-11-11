package edu.wctc.entity;

import javax.persistence.*;

/**
 * This class demonstrates a one-to-one table relationship. A DonutShop object has one DonutShopDetail. Each DonutShopDetail belongs to one DonutShop.
 */

@Entity
@Table(name = "donut_shop_detail")
public class DonutShopDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private int id;

    @Column(name = "year_founded")
    private int yearFounded;

    @Column(name = "hometown")
    private String hometown;

    @OneToOne(mappedBy = "detail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private DonutShop shop;

    public DonutShopDetail() {
        // no-arg constructor
    }

    public DonutShopDetail(int yearFounded, String hometown) {
        this.yearFounded = yearFounded;
        this.hometown = hometown;
    }

    public DonutShop getShop() {
        return shop;
    }

    public void setShop(DonutShop shop) {
        this.shop = shop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "DonutShopDetail{" +
                "id=" + id +
                ", yearFounded=" + yearFounded +
                ", hometown='" + hometown + '\'' +
                ", shop=" + shop.getName() +
                '}';
    }
}
