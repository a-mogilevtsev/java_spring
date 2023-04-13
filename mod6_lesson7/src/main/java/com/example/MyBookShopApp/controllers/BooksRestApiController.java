package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.struct.book.BookEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by a.sosnina on 1/23/2023.
 */
@RestController
@RequestMapping("/api")
@Api(description = "book data api")
public class BooksRestApiController {
    private final BookService bookService;

    @Autowired
    public BooksRestApiController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books/by-authorName")
    @ApiOperation("get books by author")
    public ResponseEntity<List<BookEntity>> booksByAuthorName(@RequestParam("author") String author) {
        return ResponseEntity.ok(bookService.getBooksByAuthorName(author));
    }



    @GetMapping("/books/by-title")
    @ApiOperation("get books by title")
    public ResponseEntity<List<BookEntity>> booksByTitle(@RequestParam("title") String title) {
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    @ApiOperation("get books by price range between min and max price")
    public ResponseEntity<List<BookEntity>> priceRangeBooks(@RequestParam("min") Integer min, @RequestParam("max") Integer max) {
        return ResponseEntity.ok(bookService.getBooksWithPriceBetween(min, max));
    }

    @GetMapping("/books/with-max-discount")
    @ApiOperation("get books by max discount")
    public ResponseEntity<List<BookEntity>> maxDiscountBooks() {
        return ResponseEntity.ok(bookService.getBooksWithMaxDiscount());
    }

    @GetMapping("/books/bestsellers")
    @ApiOperation("get books with bestseller status")
    public ResponseEntity<List<BookEntity>> bestsellersBooks() {
        return ResponseEntity.ok(bookService.getBestSellers());
    }
}
