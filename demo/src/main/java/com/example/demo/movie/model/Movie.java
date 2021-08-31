package com.example.demo.movie.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Movie {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String genre;



}
