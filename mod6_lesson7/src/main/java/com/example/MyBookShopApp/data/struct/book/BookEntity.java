package com.example.MyBookShopApp.data.struct.book;

import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by a.sosnina on 1/18/2023.
 */
@Entity
@Table(name = "book")
@ApiModel(value = "entity representing a book")
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("id genereated by db")
    private Integer id;
    @Column(name="pub_date", nullable = false)
    @ApiModelProperty("date of book publication")
    private Date pubDate;
    @Column(name = "is_bestseller", columnDefinition = "SMALLINT", nullable = false)
    @ApiModelProperty("If book is bestseller value = 1, if not value = 0")
    private Integer isBestseller;
    @Column(name = "slug", columnDefinition = "VARCHAR(255)", nullable = false)
    @ApiModelProperty("mnemonical identity sequence of characters")
    private String slug;
    @Column(name = "title", columnDefinition = "VARCHAR(255)", nullable = false)
    @ApiModelProperty("title of book")
    private String title;
    @Column(name = "image", columnDefinition = "VARCHAR(255)", nullable = false)
    @ApiModelProperty("image url")
    private String image;
    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    @ApiModelProperty("book description")
    private String description;
    @Column(name = "price", nullable = false)
    @ApiModelProperty("book price")
    private Integer price;
    @Column(name = "discount", columnDefinition = "FLOAT default 0", nullable = false)
    @ApiModelProperty("discount of book")
    private Double discount;
    @ManyToMany(mappedBy = "books")
    private List<AuthorEntity> author;
    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    private Set<GenreEntity> genres;

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

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getIsBestseller() {
        return isBestseller;
    }

    public void setIsBestseller(Integer isBestseller) {
        this.isBestseller = isBestseller;
    }

    public int getPriceWithDiscount() {
        return (int) Math.round(price * (1- discount));
    }

    public List<AuthorEntity> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorEntity> author) {
        this.author = author;
    }

    public Set<GenreEntity> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreEntity> genres) {
        this.genres = genres;
    }
}
