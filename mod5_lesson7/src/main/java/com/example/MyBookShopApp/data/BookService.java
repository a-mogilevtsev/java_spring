package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getBooksData() {
        return bookRepository.findAll();
    }

    public List<Book> getPopularBooks() {
        return bookRepository.findAll().stream().filter(i -> i.getId() % 25 == 0).collect(Collectors.toList());
    }

    public List<Book> getRecommendedBooks() {
        return bookRepository.findAll().stream().filter(i -> i.getId() % 50 == 0).collect(Collectors.toList());
    }
}
