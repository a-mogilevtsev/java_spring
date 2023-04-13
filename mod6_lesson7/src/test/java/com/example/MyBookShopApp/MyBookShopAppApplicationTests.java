package com.example.MyBookShopApp;

import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.BooksRatingAndPopularityService;
import com.example.MyBookShopApp.data.GenreService;
import com.example.MyBookShopApp.data.struct.Dto.GenreDto;
import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class MyBookShopAppApplicationTests {

	@Autowired
	public BookService bookService;






	@Test
	void contextLoads() {

	}




}
