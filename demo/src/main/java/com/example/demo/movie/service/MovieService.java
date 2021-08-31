package com.example.demo.movie.service;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movieRepository.findAll().forEach(movies::add);
        return movies;
    }

    public Movie getMovieById(int id) {
        return movieRepository.findById(id).get();
    }

    public void saveOrUpdate(Movie movie) {
        movieRepository.save(movie);
    }

    public void delete(int id) {
        movieRepository.deleteById(id);
    }

}
