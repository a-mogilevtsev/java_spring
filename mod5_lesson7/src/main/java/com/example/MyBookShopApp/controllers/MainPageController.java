package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/bookshop/")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("booksData")
    public List<Book> booksData(){
        return bookService.getBooksData();
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("recommendedBooks", bookService.getRecommendedBooks());
        model.addAttribute("popularBooks", bookService.getPopularBooks());
        model.addAttribute("recentBooks", bookService.getRecommendedBooks());
        return "index";
    }

    /*@GetMapping("/authors")
    public String authorsPage(Model model){
        return "authors/index";
    }*/

    @GetMapping("/genres")
    public String genresPage(Model model){
        return "genres/index";
    }

    @GetMapping("/recent")
    public String recentPage(Model model){
        return "books/recent";
    }

    @GetMapping("/popular")
    public String popularPage(Model model){
        model.addAttribute("popularBooks", bookService.getPopularBooks());
        return "books/popular";
    }

    @GetMapping("/postponed")
    public String postponedBooks(Model model) {
        return "postponed";
    }

    @GetMapping("/signin")
    public String signInPage(Model model) {
        return "signin";
    }

    @GetMapping("/cart")
    public String cartPage(Model model) {
        return "cart";
    }


}
