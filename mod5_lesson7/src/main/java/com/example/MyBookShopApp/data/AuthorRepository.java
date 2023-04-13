package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a.sosnina on 1/18/2023.
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
