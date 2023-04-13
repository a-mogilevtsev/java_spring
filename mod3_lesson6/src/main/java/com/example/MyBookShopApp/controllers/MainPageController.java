package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop/")
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String mainPage(Model model){

        return "redirect:/bookshop/main";
    }

    @GetMapping("/main")
    public String bookPage(Model model){
        model.addAttribute("bookData", bookService.getBooksData());
        model.addAttribute("popularData", bookService.getPopularData());
        return "index";
    }

    @GetMapping("/popular")
    public String popularPage(Model model) {
        model.addAttribute("popularData", bookService.getPopularData());
        return "/books/popular";
    }

    @GetMapping("/recent")
    public String recentPage(Model model) {
        //model.addAttribute("recentData", bookService.getRecentData());
        return "/books/recent";
    }

}
