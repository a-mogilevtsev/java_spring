package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.book.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by a.sosnina on 2/2/2023.
 */
@Service
public class BooksRatingAndPopularityService {

    private final BookRepository bookRepository;
    @Autowired
    public BooksRatingAndPopularityService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookEntity> getPopularBookEntitiesPart(Integer offset, Integer limit) {
        List<BookEntity> books =  bookRepository.getPopularBookEntitiesPage();
        return books.subList(offset * limit, (offset + 1) * limit) ;
    }
}
