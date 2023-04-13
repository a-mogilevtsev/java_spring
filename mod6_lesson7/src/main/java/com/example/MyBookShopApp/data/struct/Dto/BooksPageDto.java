package com.example.MyBookShopApp.data.struct.Dto;

import com.example.MyBookShopApp.data.struct.book.BookEntity;

import java.util.List;

/**
 * Created by a.sosnina on 1/26/2023.
 */
public class BooksPageDto {

    private Integer count;

    private List<BookEntity> books;

    public BooksPageDto(List<BookEntity> books) {
        this.books = books;
        count = books.size();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
}
