package com.example.MyBookShopApp;

import com.example.MyBookShopApp.data.GenreService;
import com.example.MyBookShopApp.data.struct.Dto.GenreDto;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Created by a.sosnina on 3/9/2023.
 */
@SpringBootTest
public class GenreRepositoryTests {

    @Autowired
    public GenreService genreService;


    @Test
    void getGenres() {
        genreService.getAllGenresSortedByPopularity().forEach(System.out::println);
    }


    @Test
    void getMapByPopularityTest() {
        Map<GenreEntity, String> map = genreService.getMapByPopularity();
        for(GenreEntity genre : map.keySet()) {
            System.out.println(map.get(genre) + " - " + genre.getName());
        }
        Assert.assertFalse(map.isEmpty());
    }


    @Test
    void getGenresByParentId() {
        List<GenreEntity> genres = genreService.getGenresWhereParentIdIs(9);
        if(genres.size() > 1) {
            genres.forEach(System.out::println);
        } else {
            System.out.println(genres.get(0));
        }
        Assert.assertFalse(genres.size() == 0);
    }

    @Test
    void getGenresDto() {
        List<GenreDto> genres = genreService.getGenresList(0);
        genres.forEach(System.out::println);
        Assert.assertFalse(genres.size() == 0);
    }

    @Test
    void getBookCountsByGenreIdTest() {
        Integer count = genreService.getBookCountByGenreId(6);
        Assert.assertEquals(29, count.intValue());
    }

    @Test
    void getGenresMap() {
        Map<Integer, List<GenreEntity>> result = genreService.getGenresMap(0);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    void getParentsListTest() {
        List<GenreEntity> parents = genreService.getParentGenresList("drama");
        parents.forEach(System.out::println);
        Assert.assertFalse(parents.isEmpty());
    }

    @Test
    void getGenreEntityById() {
        GenreEntity genre = genreService.getGenreById(19);
        System.out.println(genre);
        Assert.assertNotNull(genre);
    }
}
