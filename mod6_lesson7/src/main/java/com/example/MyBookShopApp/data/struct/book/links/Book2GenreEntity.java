package com.example.MyBookShopApp.data.struct.book.links;
import javax.persistence.*;

@Entity
@Table(name = "book2genre")
public class Book2GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_id", columnDefinition = "INT", nullable = false)
    private int bookId;

    @Column(name = "genre_id",columnDefinition = "INT", nullable = false)
    private int genreId;
}
