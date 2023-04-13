package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
import com.example.MyBookShopApp.data.struct.Dto.BooksPageDto;
import com.example.MyBookShopApp.data.struct.Dto.SearchWordDto;
import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Controller
@Api("main page controller")
public class MainPageController {

    private final BookService bookService;
    private final BooksRatingAndPopularityService booksRatingAndPopularityService;
    private final GenreService genreService;
    private final Logger logger = Logger.getLogger(MainPageController.class.getName());

    @Autowired
    public MainPageController(BookService bookService,
                              BooksRatingAndPopularityService booksRatingAndPopularityService,
                              GenreService genreService) {
        this.bookService = bookService;
        this.booksRatingAndPopularityService = booksRatingAndPopularityService;
        this.genreService = genreService;
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @ModelAttribute("genres")
    public Map<GenreEntity, String> getAllGenres() {
        return genreService.getMapByPopularity();
    }

   /* @ModelAttribute("booksData")
    public List<BookEntity> booksData(){
        return bookService.getBooksData();
    }*/

    @GetMapping(value = {"/"})
    public String localhostRedirect(Model model) {
        return "redirect:/bookshop/";
    }

    @GetMapping(value = {"/bookshop/"})
    @ApiOperation(value = "Method returns main page view")
    public String mainPage(Model model){
        model.addAttribute("recommendedBooks", bookService.getPageOfBestSellersBooks(0, 10));
        model.addAttribute("popularBooks", booksRatingAndPopularityService.getPopularBookEntitiesPart(0,10));
        model.addAttribute("recentBooks", bookService.getPageOfRecentBooks(0,10).getContent());
        logger.info("Main page returned");
        return "index";
    }


    @ModelAttribute("searchResults")
    public List<BookEntity> searchResults() {
        return new ArrayList<>();
    }
    /*@GetMapping("/authors")
    public String authorsPage(Model model){
        return "authors/index";
    }*/




    @GetMapping("/bookshop/postponed")
    public String postponedBooks(Model model) {
        return "postponed";
    }

    @GetMapping("/bookshop/signin")
    public String signInPage(Model model) {
        return "signin";
    }

    @GetMapping("/bookshop/cart")
    public String cartPage(Model model) {
        return "cart";
    }

    @GetMapping("/bookshop/recommended")
    @ResponseBody
    public BooksPageDto getBooksOfRecommendedPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        logger.info("Recomended books page returned");
        return new BooksPageDto(bookService.getPageOfBestSellersBooks(offset, limit).getContent());
    }

    @GetMapping("/bookshop/books/recent")
    @ResponseBody
    public BooksPageDto getBooksOfRecentPage(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit) {
        return new BooksPageDto(bookService.getPageOfRecentBooks(offset, limit).getContent());
    }

    @GetMapping("/bookshop/book/{slug}")
    public String getBookPage(@PathVariable (value = "slug") String slug) {
        return "/books/slug";
    }

    @GetMapping(value = {"/search", "/search/{searchWordDto}"})
    public String getSearchResults(@PathVariable(value = "searchWordDto", required = false) SearchWordDto searchWordDto, Model model) {
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("searchResults", bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), 0, 8));
        return "/search/index";
    }

    @GetMapping(value = "/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit,
                                          @PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto) {
        return new BooksPageDto((bookService.getPageOfSearchResultBooks(searchWordDto.getExample(), offset, limit).getContent()));
    }


}
