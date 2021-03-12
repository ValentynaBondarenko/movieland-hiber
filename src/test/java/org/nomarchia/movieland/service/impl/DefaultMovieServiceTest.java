package org.nomarchia.movieland.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nomarchia.movieland.MovielandApplicationContext;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitWebConfig(MovielandApplicationContext.class)
class DefaultMovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("Get all movies from DB")
    void testFindAll() {
        List<Movie> actualMovies = movieService.findAll();

        assertEquals(26, actualMovies.size());
    }
}