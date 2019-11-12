package edu.wctc.entity;

import edu.wctc.DateUtils;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "donut")
public class Donut {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donut_id")
    private int id;

    @NotNull
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "shop_id")
    private DonutShop shop;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "donut_id")
    private List<DonutReview> reviews;


    @NotNull(message = "required")
    @Size(min = 1, message = "must be greater than 0")
    @Column(name = "nm")
    private String name;

    @NotNull(message = "required")
    @Min(value = 1, message = "must be greater than 0")
    @Column(name = "calories")
    private Integer calories;

    @Column(name = "img_filename")
    private String imageFilename;

    @Column(name = "date_added")
    private Date dateAdded;

    public Donut() {
        // no-arg constructor
    }

    public Donut(String name, int calories, String imageFilename, Date dateAdded) {
        this.name = name;
        this.calories = calories;
        this.imageFilename = imageFilename;
        this.dateAdded = dateAdded;
    }

    public void add(DonutReview tempReview) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(tempReview);
    }

    public List<DonutReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<DonutReview> reviews) {
        this.reviews = reviews;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getImageFilename() {
        return imageFilename;
    }

    public void setImageFilename(String imageFilename) {
        this.imageFilename = imageFilename;
    }

    public String getImagePath() {
        if (imageFilename == null || shop == null)
            return "none.jpg";
        return shop.getImageDirectory() + "/" + imageFilename;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getFormattedDate() {
        return DateUtils.formatDate(dateAdded);
    }

    @Override
    public String toString() {
        return "Donut{" +
                "id=" + id +
                ", shop=" + shop.getName() +
                ", name='" + name + '\'' +
                ", calories=" + calories +
                ", imageFilename='" + imageFilename + '\'' +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
