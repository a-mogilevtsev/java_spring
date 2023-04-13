package com.example.MyBookShopApp.data.struct.book.links;

import javax.persistence.*;

@Entity
@Table(name = "book2author")
public class Book2AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "book_id", columnDefinition = "INT", nullable = false)
    private int bookId;

    @Column(name="author_id", columnDefinition = "INT", nullable = false)
    private int authorId;

    @Column(name="sort_index", columnDefinition = "INT DEFAULT 0", nullable = false)
    private int sortIndex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }
}
