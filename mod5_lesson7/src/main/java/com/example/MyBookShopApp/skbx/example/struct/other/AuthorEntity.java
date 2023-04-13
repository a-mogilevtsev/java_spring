package com.example.MyBookShopApp.skbx.example.struct.other;

import javax.persistence.*;

/**
 * Created by a.sosnina on 1/18/2023.
 */
@Entity
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(255)")
    private String photo;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String slug;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;
    @Column(columnDefinition = "TEXT")
    private String desription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesription() {
        return desription;
    }

    public void setDesription(String desription) {
        this.desription = desription;
    }
}
