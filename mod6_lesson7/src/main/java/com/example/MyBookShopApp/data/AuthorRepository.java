package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by a.sosnina on 1/18/2023.
 */
public interface AuthorRepository extends JpaRepository<AuthorEntity, Integer> {
    List<AuthorEntity> findAll();

    AuthorEntity getAuthorEntityBySlug(String slug);

}
