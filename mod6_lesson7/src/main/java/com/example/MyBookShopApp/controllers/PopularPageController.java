package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
import com.example.MyBookShopApp.data.struct.Dto.BooksPageDto;
import com.example.MyBookShopApp.data.struct.Dto.SearchWordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;

/**
 * Created by a.sosnina on 2/4/2023.
 */
@Controller
public class PopularPageController {

    private final BookService bookService;
    private final BooksRatingAndPopularityService booksRatingAndPopularityService;
    private final Logger logger = Logger.getLogger(PopularPageController.class.getName());

    @Autowired
    public PopularPageController(BookService bookService, BooksRatingAndPopularityService booksRatingAndPopularityService) {
        this.bookService = bookService;
        this.booksRatingAndPopularityService = booksRatingAndPopularityService;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping("/bookshop/books/popular")
    public String popularPage(Model model){
        model.addAttribute("popularBooks", booksRatingAndPopularityService.getPopularBookEntitiesPart(0, 20));
        logger.info("Popular books page returned");
        return "books/popular";
    }

    @GetMapping ("/bookshop/popular")
    @ResponseBody
    public BooksPageDto getPopularBooksPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        logger.info("Part of popular books returned offset - " + offset + ", limit - " + limit);
        return new BooksPageDto(booksRatingAndPopularityService.getPopularBookEntitiesPart(offset, limit));
    }
}
