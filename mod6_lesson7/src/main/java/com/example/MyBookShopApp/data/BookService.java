package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<BookEntity> getBooksData() {
        return bookRepository.customFindAllBooks();
    }


    /*public Page<BookEntity> getPopularBooks(Pageable pageable) {
        return bookRepository.getPopularBookEntitiesPage(pageable);
    }*/

    /*//Temporary
    public List<BookEntity> getRecommendedBooks() {
        return bookRepository.findAll().stream().filter(i -> i.getId() % 50 == 0).collect(Collectors.toList());
    }*/

    //NEW BOOK SERVICE METHODS
    public List<BookEntity> getBooksByTitle(String title) {
        return bookRepository.findBookEntitiesByTitleContaining(title);
    }

    public Page<BookEntity> getPageOfBooksByGenre(GenreEntity genre, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        //return bookRepository.getBooksByGenreSlug(genreSlug, nextPage);
        return bookRepository.getBookEntitiesByGenresIs(genre, nextPage);
    }

    public List<BookEntity> getBooksByAuthor(AuthorEntity author) {
        return bookRepository.findBookEntitiesByAuthor(author);
    }


    //To Delete
    /*public List<BookEntity> getBooksByAuthorLastName(String authorLastName) {
        return bookRepository.findBookEntitiesByAuthorLastName(authorLastName);
    }*/

    public List<BookEntity> getBooksWithMaxDiscount() {
        return bookRepository.getBooksWithMaxDiscount();
    }

    public List<BookEntity> getBooksWithPriceBetween(Integer min, Integer max) {
        return bookRepository.findBookEntitiesByPriceBetween(min, max);
    }

    public List<BookEntity> getBestSellers() {
        return bookRepository.getBestSellers();
    }

    /*public Page<BookEntity> getPageOfRecommendedBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findAll(nextPage);
    }*/

    public Page<BookEntity> getPageOfRecentBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        Calendar date = new GregorianCalendar();
        date.add(Calendar.MONTH, -10);
        return bookRepository.getBookEntitiesByPubDateAfter(new Date(date.getTimeInMillis()), nextPage);
    }

    public Page<BookEntity> getPageOfBestSellersBooks(Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.getBookEntitiesByIsBestsellerIsNotNull(nextPage);
    }

    public Page<BookEntity> getPageOfSearchResultBooks(String searchWord, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.findBookEntitiesByTitleContaining(searchWord, nextPage);
    }

    public Page<BookEntity> getPageOfBooksByDate(Date dateFrom, Date dateTo, Integer offset, Integer limit) {
        Pageable nextPage = PageRequest.of(offset, limit);
        return bookRepository.getBookEntitiesByPubDateIsBetween(dateFrom, dateTo, nextPage);
    }

    public List<BookEntity> getBooksByAuthorName(String authorName) {
        return bookRepository.getBookEntitiesByAuthorName(authorName);
    }

}
