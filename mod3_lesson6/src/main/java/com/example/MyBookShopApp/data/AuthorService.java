package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*
        Метод getAuthorsData - возвращает список со всеми авторами из БД.
     */
    public List<Author> getAuthorsData(){

        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rownum)->{
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("firstname"));
            author.setLastName(rs.getString("lastname"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    /*
        Метод getAuthorsMap - возвращает карту со всеми авторами из БД разделенными по первой букве фамилии.
        Ключ - Первая буква фамилии
        Значение - Set авторов с фамилией начинающейся на эту букву.
     */
    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = getAuthorsData();
        return authors.stream().collect(Collectors.groupingBy((Author a) ->{return a.getLastName().substring(0,1);}));
    }

}
