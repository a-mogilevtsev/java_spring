package com.example.MyBookShopApp;

import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.BooksRatingAndPopularityService;
import com.example.MyBookShopApp.data.GenreService;
import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Created by a.sosnina on 3/9/2023.
 */
@SpringBootTest
public class BookRepositoryTests {

    @Autowired
    public BookService bookService;

    @Autowired
    public GenreService genreService;

    @Autowired
    AuthorService authorService;

    @Autowired
    BooksRatingAndPopularityService ratingAndPopularityService;

    @Test
    void getPageOfRecentBooksTest() {
        List<BookEntity> books = bookService.getPageOfRecentBooks(0, 20).getContent();
        System.out.println(books.size());
        System.out.println(books);
        Assert.assertEquals(books.size() != 0, true);
    }

    @Test
    void getPageOfPopularBooksTest() {
        List<BookEntity> books = ratingAndPopularityService.getPopularBookEntitiesPart(0,8);
        books.forEach(System.out::println);
    }

    @Test
    void getBestsellersBooks() {
        List<BookEntity> books = bookService.getBestSellers();
        System.out.println(books.size());
        Assert.assertEquals(books.size(), 477);
    }

    @Test
    void getBooksByGenrePopularity() {
        for(GenreEntity genre : genreService.getAllGenresSortedByPopularity()) {
            genre.getBooks().forEach(System.out::println);
        }
    }

    @Test
    void getBooksByAuthorSlugTest() {
        AuthorEntity author = authorService.getAuthorBySlug("author-019-pud");
        List<BookEntity> books = bookService.getBooksByAuthor(author);
        System.out.println(books.size());
        Assert.assertTrue(books.size() != 0);
    }

    @Test
    void getBooksByGenreIs() {
        List<BookEntity> books = bookService.getPageOfBooksByGenre(genreService.getGenreBySlug("drama"), 0, 10).getContent();
        books.forEach(System.out::println);
        Assert.assertFalse(books.size()==0);
    }
}
