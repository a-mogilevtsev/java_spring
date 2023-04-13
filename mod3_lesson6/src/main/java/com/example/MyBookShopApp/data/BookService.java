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


    /*
            Метод getBooksData - возвращает список со всеми объектами книг содержащимися в БД.
         */

    public List<Book> getBooksData(){
        List<Book> books = jdbcTemplate.query("SELECT b.id, b.title, a.firstname, a.lastname, b.priceold, b.price " +
                "from books b INNER JOIN authors a " +
                "ON b.authorid = a.id order by  b.id", (ResultSet rs, int rownum)->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            String firstName = rs.getString("firstname");
            String lastName = rs.getString("lastname");
            book.setAuthor(firstName + " " + lastName);
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getInt("priceOld"));
            book.setPrice(rs.getInt("price"));
            return book;
        });
        return books;
    }

    /*
        Метод getPopularData - возвращает список с объектами книг соответствующими критериям "популярное".
        Так как эти критерии не определены, список заполняется случайными книгами.
     */

    public List<Book> getPopularData() {
        List<Book> books = getBooksData();
        List<Book> result = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            int rnd = (int) Math.round((Math.random() * books.size()) - 1);
            result.add(books.get(rnd));
        }
        return result;
    }

}
