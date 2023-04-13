package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //Данный метод возвращает список из всех книг содержащихся в БД
    public List<Book> getBooksData(){
        List<Book> books = jdbcTemplate.query("SELECT b.id, b.title, a.first_name, a.last_name, b.priceold, b.price " +
                "from books b INNER JOIN authors a " +
                "ON b.authorid = a.id order by  b.id", (ResultSet rs, int rownum)->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            book.setAuthor(firstName + " " + lastName);
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getInt("priceOld"));
            book.setPrice(rs.getInt("price"));
            return book;
        });
        return books;
    }

    //Данный метод возвращает список из 10 случайных книг для отображения в блоке рекомендованное
    public List<Book> getRecommendedBooks() {
        List<Book> books = getBooksData();
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int rnd = (int) Math.round((Math.random() * books.size()) - 1);
            result.add(books.get(rnd));
        }
        return result;
    }

    //Данный метод возвращает список из 20 случайных книг для отображения в блоке популярное
    public List<Book> getPopularBooks() {
        List<Book> books = getBooksData();
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            int rnd = (int) Math.round((Math.random() * books.size()) - 1);
            result.add(books.get(rnd));
        }
        return result;
    }
}
