package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.AuthorService;
import com.example.MyBookShopApp.data.struct.Dto.SearchWordDto;
import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@Api(description = "authors data")
public class AuthorsController {

    private final AuthorService authorService;

    private final BookService bookService;

    @Autowired
    public AuthorsController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ModelAttribute("authorsMap")
    @ApiOperation(value = "Method returns map with lists(value) of authors by letter(key)")
    public Map<String,List<AuthorEntity>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/bookshop/authors")
    @ApiOperation(value = "Method returns page with authors list")
    public String authorsPage(){
        return "/authors/index";
    }

    @ApiOperation("method to get map of authors in JSON format")
    @GetMapping("/api/authors")
    @ResponseBody
    public Map<String, List<AuthorEntity>> authors() {
        return authorService.getAuthorsMap();
    }

    @GetMapping("/bookshop/author/{slug}")
    @ApiOperation(value = "Method returns author page")
    public String authorPage(@PathVariable String slug, Model model) {
        AuthorEntity author = authorService.getAuthorBySlug(slug);
        model.addAttribute("author", author);
        model.addAttribute("books", bookService.getBooksByAuthor(author));
        return "authors/slug";
    }

    @GetMapping("/bookshop/author/books/{slug}")
    public String authorBooksPage(@PathVariable String slug, Model model) {
        AuthorEntity author = authorService.getAuthorBySlug(slug);
        model.addAttribute("author", author);
        model.addAttribute("books", bookService.getBooksByAuthor(author));
        return "books/author";
    }
}
