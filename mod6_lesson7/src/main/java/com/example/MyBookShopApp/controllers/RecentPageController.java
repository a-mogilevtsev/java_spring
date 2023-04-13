package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
import com.example.MyBookShopApp.data.struct.Dto.BooksPageDto;
import com.example.MyBookShopApp.data.struct.Dto.FromToDateDto;
import com.example.MyBookShopApp.data.struct.Dto.SearchWordDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * Created by a.sosnina on 1/29/2023.
 */
@Controller
public class RecentPageController {
    private final BookService bookService;
    private final Logger logger = Logger.getLogger(RecentPageController.class.getName());

    @Autowired
    public RecentPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("fromToDateDto")
    public FromToDateDto fromToDateDto() {
        return new FromToDateDto();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto searchWordDto() {
        return new SearchWordDto();
    }

    @GetMapping("/bookshop/recentpage")
    public String recentPage(Model model) {
        logger.info("recent page returned");
        model.addAttribute("recentBooks", bookService.getPageOfRecentBooks(0, 20));
        return "books/recent";
    }


    /*@GetMapping("/bookshop/recent")
    @ResponseBody
    public Page<BookEntity> recentBookByDate(@RequestParam(value = "from", required = false) String dateFrom ,
                                             @RequestParam(value = "to", required = false) String dateTo) {
        logger.info(dateFrom + " - " + dateTo);
        logger.info("return recent page");
        return bookService.getPageOfBooksByDate(FromToDateDto.convertToDateFormat(dateFrom), FromToDateDto.convertToDateFormat(dateTo), 0, 20)  ;
    }*/


    @GetMapping("/bookshop/booksbydate")
    @ResponseBody
    public BooksPageDto loadBooksByDate(@RequestParam(value = "from", required = false) String dateFrom ,
                                        @RequestParam(value = "to", required = false) String dateTo,
                                        @RequestParam("offset") Integer offset,
                                        @RequestParam("limit") Integer limit, Model model) {
        logger.info("BooksByDate method called. Return books from " + dateFrom + " to " + dateTo);
        return new BooksPageDto(bookService.getPageOfBooksByDate(FromToDateDto.convertToDateFormat(dateFrom), FromToDateDto.convertToDateFormat(dateTo), offset, limit).getContent());
    }

    @GetMapping("/bookshop/booksbydate/page")
    @ResponseBody
    public BooksPageDto loadMoreBooksByDate(@RequestParam(value = "from", required = false) String dateFrom ,
                                                @RequestParam(value = "to", required = false) String dateTo,
                                                @RequestParam("offset") Integer offset,
                                                @RequestParam("limit") Integer limit, Model model) {
        logger.info("part of booksByDate returned");
        return new BooksPageDto(bookService.getPageOfBooksByDate(FromToDateDto.convertToDateFormat(dateFrom), FromToDateDto.convertToDateFormat(dateTo), offset, limit).getContent());
    }

    /*
    @RequestParam(value = "from", required = false) String dateFrom ,
                                          @RequestParam(value = "to", required = false) String dateTo,
                                          @RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit
     */

}
