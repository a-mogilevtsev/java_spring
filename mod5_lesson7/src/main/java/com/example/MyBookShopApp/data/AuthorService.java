package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    //private JdbcTemplate jdbcTemplate;
    private AuthorRepository authorRepository;
    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Map<String, List<Author>> getAuthorsMap(){
        List<Author> authors = findAll();

        return authors.stream().collect(Collectors.groupingBy((Author a)->{return a.getLastName().toUpperCase().substring(0,1);}));
    }
}
