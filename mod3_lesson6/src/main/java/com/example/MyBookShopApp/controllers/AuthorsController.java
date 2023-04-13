package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a.sosnina on 12/27/2022.
 */
@Controller
@RequestMapping("/bookshop")
public class AuthorsController {
    private final AuthorService authorService;

    @Autowired
    AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public String mainPage(Model model){
        model.addAttribute("authorsMap", authorService.getAuthorsMap());
        return "/authors/index";
    }

}
