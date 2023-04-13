package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.BookService;
import com.example.MyBookShopApp.data.BooksRatingAndPopularityService;
import com.example.MyBookShopApp.data.GenreService;
import com.example.MyBookShopApp.data.struct.Dto.BooksPageDto;
import com.example.MyBookShopApp.data.struct.Dto.SearchWordDto;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by a.sosnina on 2/7/2023.
 */
@Controller
@Api("genres data")
public class GenresPageController {

    private final BookService bookService;
    private final BooksRatingAndPopularityService booksRatingAndPopularityService;
    private final GenreService genreService;
    private final Logger logger = Logger.getLogger(MainPageController.class.getName());

    @Autowired
    public  GenresPageController(BookService bookService,
                                 BooksRatingAndPopularityService booksRatingAndPopularityService,
                                 GenreService genreService) {
        this.bookService = bookService;
        this.booksRatingAndPopularityService = booksRatingAndPopularityService;
        this.genreService = genreService;
    }

    @ApiOperation(value = "Method returns genres page view")
    @GetMapping("/bookshop/genres")
    public String genresPage(Model model){
        logger.info("Genres page returned");
        model.addAttribute("genresList", genreService.getGenresList(0));
        return "genres/index";
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ApiOperation(value = "Method returns genre page view by genre-slug parameter")
    @GetMapping("/bookshop/genre/{slug}")
    public String genrePage(@PathVariable String slug, Model model) {
        GenreEntity genre = genreService.getGenreBySlug(slug);
        model.addAttribute("books", bookService.getPageOfBooksByGenre(genre, 0 ,10));
        model.addAttribute("parentsList", genreService.getParentGenresList(slug));
        model.addAttribute("genre", genre);
        return "genres/slug";
    }


    @ApiOperation(value = "Method returns page of books by genre with genre-slug is")
    @GetMapping("/bookshop/genre/page/{slug}")
    @ResponseBody
    public BooksPageDto pageOfBooksByGenre(@PathVariable String slug, @RequestParam("offset") Integer offset,
                            @RequestParam("limit") Integer limit, Model model) {
        return new BooksPageDto(bookService.getPageOfBooksByGenre(genreService.getGenreBySlug(slug), offset ,limit).getContent());
    }

}
