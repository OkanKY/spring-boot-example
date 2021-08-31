package com.example.demo.movie.controller;

import com.example.demo.movie.model.Movie;
import com.example.demo.movie.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@RunWith(SpringRunner.class)
@WebMvcTest(MovieController.class)
public class MovieControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private MovieService movieService;


    @Test
    public void givenMovieList_whenGetAllMovies_thenReturnJsonArray()
            throws Exception {

        Movie movie = new Movie();
        movie.setId(1);
        movie.setName("test");
        movie.setGenre("test");

        given(movieService.getAllMovies()).willReturn(Collections.singletonList(movie));

        mvc.perform(get("/movies")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(movie.getName())));
    }


}
