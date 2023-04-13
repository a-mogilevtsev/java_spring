package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<AuthorEntity> findAll() {
        return authorRepository.findAll();
    }

    public Map<String, List<AuthorEntity>> getAuthorsMap(){
        List<AuthorEntity> authors = findAll();

        return authors.stream().collect(Collectors.groupingBy((AuthorEntity a)->{return a.getName().toUpperCase().substring(0,1);}));
    }

    public AuthorEntity getAuthorBySlug(String slug) {
        return authorRepository.getAuthorEntityBySlug(slug);
    }

}
