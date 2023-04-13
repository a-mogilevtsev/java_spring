package com.example.MyBookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by a.sosnina on 12/27/2022.
 */
@Controller
@RequestMapping("/bookshop")
public class GenresController {

    @GetMapping("/genres")
    public String getGenresPage(Model model) {
        return "/genres/index";
    }


}
