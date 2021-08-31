package com.example.demo.movie.controller;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable("id") int id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable("id") int id) {
        movieService.delete(id);
    }

    @PutMapping("/movies")
    public int saveMovie(@RequestBody Movie movie) {
        movieService.saveOrUpdate(movie);
        return movie.getId();
    }
}

