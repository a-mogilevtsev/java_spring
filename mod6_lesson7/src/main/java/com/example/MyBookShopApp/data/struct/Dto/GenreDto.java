package com.example.MyBookShopApp.data.struct.Dto;

import com.example.MyBookShopApp.data.struct.genre.GenreEntity;

import java.util.List;

/**
 * Created by a.sosnina on 2/7/2023.
 */
public class GenreDto {

    private Integer parentId;

    private GenreEntity genre;

    private Integer countBooks;

    private List<GenreDto> childs;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public GenreEntity getGenre() {
        return genre;
    }

    public void setGenre(GenreEntity genre) {
        this.genre = genre;
    }

    public Integer getCountBooks() {
        return countBooks;
    }

    public void setCountBooks(Integer countBooks) {
        this.countBooks = countBooks;
    }

    public List<GenreDto> getChilds() {
        return childs;
    }

    public void setChilds(List<GenreDto> childs) {
        this.childs = childs;
    }
}
