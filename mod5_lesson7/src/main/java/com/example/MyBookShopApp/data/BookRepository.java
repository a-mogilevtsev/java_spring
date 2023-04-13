package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by a.sosnina on 1/15/2023.
 */
public interface BookRepository extends JpaRepository<Book, Integer> {


}
