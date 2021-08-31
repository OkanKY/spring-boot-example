package com.example.demo.movie.service;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.repository.MovieRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RunWith(SpringRunner.class)
public class MovieServiceTest {

    @TestConfiguration
    static class MovieServiceTestContextConfiguration {
        @Bean
        public MovieService movieService() {
            return new MovieService() {
                // implement methods
            };
        }
    }

    @Autowired
    private MovieService movieService;

    @MockBean
    private MovieRepository movieRepository;


    @Before
    public void setUp() {
        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("test");
        movie.setGenre("test");

        Mockito.when(movieRepository.findAll())
                .thenReturn(Collections.singletonList(movie));

        Mockito.when(movieRepository.findById(1))
                .thenReturn(Optional.of(movie));
    }

    @Test
    public void whenGetAll_thenMovieListShouldBeFound() {

        List<Movie> movieList = movieService.getAllMovies();

        Assert.assertEquals(movieList.get(0).getName(), "test");

    }

    @Test
    public void whenGet_thenMovieShouldBeFound() {

        Movie movie = movieService.getMovieById(1);

        Assert.assertEquals(movie.getName(), "test");

    }
}
