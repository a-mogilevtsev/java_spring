package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.struct.Dto.GenreDto;
import com.example.MyBookShopApp.data.struct.genre.GenreEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by a.sosnina on 2/7/2023.
 */
@Service
public class GenreService{

    private final GenreRepository genreRepository;

    @Autowired

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<GenreEntity> getAllGenres() {
        return genreRepository.findAll();
    }

    public GenreEntity getGenreById(Integer genreId) {
        return genreRepository.getGenreEntityById(genreId);
    }

    public List<GenreEntity> getAllGenresSortedByPopularity() {
        return genreRepository.getAllGenresSortedByPopularity();
    }

    public Map<GenreEntity, String> getMapByPopularity(){
        List<GenreEntity> genres = getAllGenresSortedByPopularity();
        int part = genres.size()/5;
        int partIndex = 0;
        int popIndex = 0;
        String[] tags = {"Tag Tag_xs", "Tag Tag_sm", "Tag", "Tag Tag_md", "Tag Tag_lg"};
        Map<GenreEntity, String> result = new HashMap<>();
        for(GenreEntity genre : genres) {
            if(partIndex < part) {
                result.put(genre, tags[popIndex]);
            } else {
                popIndex++;
                partIndex = 0;
                result.put(genre, tags[popIndex]);
            }
            partIndex++;
        }
        return result;
    }

    public List<GenreEntity> getGenresWhereParentIdIs(Integer parentId) {
        return genreRepository.getGenreEntitiesByParentId(parentId);
    }

    public List<GenreDto> getGenresList(Integer parentId) {
        List<GenreEntity> genres = getGenresWhereParentIdIs(parentId);
        List<GenreDto> result = new ArrayList<>();
        for(GenreEntity g : genres) {
            GenreDto genreDto = new GenreDto();
            genreDto.setParentId(parentId);
            genreDto.setGenre(g);
            genreDto.setCountBooks(genreRepository.getBookCountByGenreId(g.getId()));
            genreDto.setChilds(getGenresList(g.getId()));
            result.add(genreDto);
        }
        return result;
    }


    public Map<Integer, List<GenreEntity>> getGenresMap(Integer parentId) {
        Map<Integer, List<GenreEntity>> result = new HashMap<>();
        List<GenreEntity> list = getGenresWhereParentIdIs(parentId);
        if(list.size() != 0) {
            result.put(parentId, list);
            for (GenreEntity genre : list) {
                Map<Integer, List<GenreEntity>> temp = getGenresMap(genre.getId());
                result.putAll(temp);
            }
        }
        return result;
    }

    public Integer getBookCountByGenreId(Integer genreId) {
        return genreRepository.getBookCountByGenreId(genreId);
    }

    public List<GenreEntity> getParentGenresList(String slug) {
        List<GenreEntity> parentGenres = new ArrayList<>();
        GenreEntity genre = getGenreBySlug(slug);
        while(genre.getParentId() != 0) {
            parentGenres.add(genre);
            genre = genreRepository.getGenreEntityById(genre.getParentId());
        }
        parentGenres.add(genre);
        Collections.reverse(parentGenres);
        return parentGenres;
    }

    public GenreEntity getGenreBySlug(String slug) {
        return genreRepository.getGenreEntityBySlug(slug);
    }
}
