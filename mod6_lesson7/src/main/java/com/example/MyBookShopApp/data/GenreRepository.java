package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.book.BookEntity;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by a.sosnina on 2/7/2023.
 */
public interface GenreRepository extends JpaRepository<GenreEntity, Integer> {

    @Override
    List<GenreEntity> findAll();

    @Override
    GenreEntity getById(Integer integer);

    GenreEntity getGenreEntityById(Integer id);

    @Query(nativeQuery = true, value = "SELECT b.*, count(*) as count from bookstore.book2genre as a " +
            "inner join bookstore.genre as b on a.genre_id = b.id group by a.genre_id order by count;")
    List<GenreEntity> getAllGenresSortedByPopularity();

    List<GenreEntity> getGenreEntitiesByParentId(Integer parentId);

    @Query(nativeQuery = true, value = "SELECT count(*) FROM bookstore.book2genre where genre_id =:genreId")
    Integer getBookCountByGenreId(@Param("genreId") Integer genreId);

    GenreEntity getGenreEntityBySlug(String slug);
}
