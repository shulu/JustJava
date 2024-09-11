package com.restful.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int id;
    private String name;
    private double price;
    private String category;
    private int pnum;
    private String imgurl;
    private String description;
    private String author;
    private int sales;
}
