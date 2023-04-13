package com.example.MyBookShopApp.data.struct.genre;

import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "parent_id", columnDefinition = "INT", nullable = true)
    private int parentId;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String slug;

    @Column(columnDefinition = "VARCHAR(255)", nullable = false)
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "book2genre",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id"))
    private Set<BookEntity> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
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

    @JsonIgnore
    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", slug='" + slug + '\'' +
                ", name='" + name +
                '}';
    }
}
