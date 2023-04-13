package com.example.MyBookShopApp.skbx.example.struct.book;

import com.example.MyBookShopApp.data.Author;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by a.sosnina on 1/18/2023.
 */
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="pub_date", nullable = false)
    private Date pubDate;
    @Column(name = "is_bestseller", nullable = false)
    private boolean isBestseller;
    @Column(name = "slug", columnDefinition = "VARCHAR(255)", nullable = false)
    private String slug;
    @Column(name = "title", columnDefinition = "VARCHAR(255)", nullable = false)
    private String title;
    @Column(name = "image", columnDefinition = "VARCHAR(255)", nullable = false)
    private String image;
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;
    @Column(name = "price", nullable = false)
    private Integer price;
    @Column(name = "discount", columnDefinition = "TINYINT DEFAULT 0", nullable = false)
    private Integer discount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public boolean isBestseller() {
        return isBestseller;
    }

    public void setBestseller(boolean bestseller) {
        isBestseller = bestseller;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }
}
