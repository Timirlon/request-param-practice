package com.practice.productspractice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Movie {
    private String title;
    private String mpa; // R, PG-13, PG,
    private String genre;
    private double rating;
}

