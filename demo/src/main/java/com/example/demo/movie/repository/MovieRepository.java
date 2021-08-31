package com.example.demo.movie.repository;

import com.example.demo.movie.model.Movie;
import org.springframework.data.repository.CrudRepository;


public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
