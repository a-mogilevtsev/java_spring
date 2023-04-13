package com.example.MyBookShopApp.data.struct.Dto;

/**
 * Created by a.sosnina on 1/27/2023.
 */
public class SearchWordDto {

    private String example;

    public SearchWordDto() {

    }

    public SearchWordDto(String example) {
        this.example = example;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }
}
