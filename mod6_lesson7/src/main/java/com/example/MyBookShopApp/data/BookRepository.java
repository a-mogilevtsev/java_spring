package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import com.example.MyBookShopApp.data.struct.other.AuthorEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by a.sosnina on 1/15/2023.
 */
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

    public List<BookEntity> findBookEntitiesByAuthor(AuthorEntity author);

    @Query("from BookEntity ")

    public List<BookEntity> customFindAllBooks();

    //NEW BOOK REST REPOSITORY COMMANDS

    //List<BookEntity> findBookEntitiesByAuthorLastName(String authorLastName);

    public List<BookEntity> findBookEntitiesByTitleContaining(String bookTitle);

    public List<BookEntity> findBookEntitiesByPriceBetween(Integer min, Integer max);

    @Query("from BookEntity where isBestseller=1")
    public List<BookEntity> getBestSellers();

    @Query(value="SELECT * FROM book WHERE discount = (SELECT MAX(discount) FROM book)", nativeQuery=true)
    public List<BookEntity> getBooksWithMaxDiscount();

    public Page<BookEntity> getBookEntitiesByPubDateAfter(Date date, Pageable nextPage);

    public Page<BookEntity> getBookEntitiesByPubDateIsBetween(Date dateFrom, Date dateTo, Pageable nextPage);

    public Page<BookEntity> getBookEntitiesByIsBestsellerIsNotNull(Pageable nextPage);

    public Page<BookEntity> findBookEntitiesByTitleContaining(String bookTitle, Pageable nextPage);
    
    /*@Query(nativeQuery = true, value = "SELECT b.* from book as b " +
            "left join (select book_id, count(book_id) as bookCount from book2user where type_id = 1 group by book_id) as keptBooks on keptBooks.book_id = b.id " +
            "left join (select book_id, count(book_id) as bookCount from book2user where type_id = 2 group by book_id) as cartBooks on cartBooks.book_id = b.id " +
            "left join (select book_id, count(book_id) as bookCount from book2user where type_id = 3 group by book_id) as paidBooks on paidBooks.book_id = b.id " +
            "order by (0.4 * (case when keptBooks.bookCount is null then 0 else keptBooks.bookCount end) + " +
            " 0.7 * (case when cartBooks.bookCount is null then 0 else cartBooks.bookCount end) + " +
            "(case when paidBooks.bookCount is null then 0 else paidBooks.bookCount end)) desc")
    public Page<BookEntity> getPopularBookEntitiesPage(Pageable page);*/

    @Query(nativeQuery = true, value="SELECT * FROM (select b.*, count(case when b2ut.code = 'PAID' then 1 else null end) + " +
            "count(case when b2ut.code = 'CART' then 1 else null end) * 0.7 + " +
            "count(case when b2ut.code = 'KEPT' then 1 else null end) * 0.4 as total " +
            "from bookstore.book as b " +
            "join bookstore.book2user as b2u on b.id=b2u.book_id " +
            "join bookstore.book2user_type as b2ut on b2u.type_id = b2ut.id " +
            "group by b.id) as `r` order by r.total desc")
    public List<BookEntity> getPopularBookEntitiesPage();

   // public List<BookEntity> getBookEntitiesBy(String genre);

    @Query(nativeQuery = true, value = "SELECT b.* FROM bookstore.genre g JOIN bookstore.book2genre g2b on g.id = g2b.genre_id " +
            "join bookstore.book b on g2b.book_id = b.id " +
            "where g.slug =:slug")
    List<BookEntity> getBooksByGenreSlug(@Param("slug") String slug);

    Page<BookEntity> getBookEntitiesByGenresIs(GenreEntity genre, Pageable nextPage);

    List<BookEntity> getBookEntitiesByAuthor(AuthorEntity author);

    List<BookEntity> getBookEntitiesByAuthorName(String author);

}
