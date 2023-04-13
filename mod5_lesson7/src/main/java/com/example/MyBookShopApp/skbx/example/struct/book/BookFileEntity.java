package com.example.MyBookShopApp.skbx.example.struct.book;

import javax.persistence.*;

/**
 * Created by a.sosnina on 1/18/2023.
 */
@Entity
@Table(name = "book_file")
public class BookFileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String hash;
    @Column(columnDefinition = "INT", nullable = false)
    private Integer typeId;
    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
