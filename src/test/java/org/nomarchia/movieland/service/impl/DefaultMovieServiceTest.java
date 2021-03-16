package org.nomarchia.movieland.service.impl;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.junit5.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nomarchia.movieland.MovielandApplicationContext;
import org.nomarchia.movieland.common.SortingOrder;
import org.nomarchia.movieland.common.SortingParameter;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.request.SortedMoviesRequest;
import org.nomarchia.movieland.service.MovieService;
import org.nomarchia.movieland.TestAppContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DBRider
@DBUnit(caseInsensitiveStrategy = Orthography.LOWERCASE)
@SpringJUnitWebConfig(value = {TestAppContext.class, MovielandApplicationContext.class})
class DefaultMovieServiceTest {
    @Autowired
    private MovieService movieService;

    @Test
    @DisplayName("Get all movies from DB without Order By")
    void testFindAllUnordered() {
        //when
        List<Movie> allMovies = movieService.findAll(null);

        //then
        assertNotNull(allMovies);
        assertEquals(25, allMovies.size());

        for (Movie movie : allMovies) {
            assertNotNull(movie);
        }
    }

    @Test
    @DisplayName("Get all movies from DB order by rating DESC")
    void testFindAllOrderedByRatingDesc() {
        //prepare
        SortedMoviesRequest request = SortedMoviesRequest.builder()
                .sortingOrder(SortingOrder.DESC)
                .sortingParameter(SortingParameter.RATING)
                .build();

        //when
        List<Movie> allMovies = movieService.findAll(request);

        //then
        assertNotNull(allMovies);
        assertEquals(25, allMovies.size());
        assertEquals(8.9, allMovies.get(0).getRating());
        assertEquals(7.6, allMovies.get(24).getRating());
    }

    @Test
    @DisplayName("Get all movies from DB order by price ASC")
    void testFindAllOrderedByPriceAsc() {
        //prepare
        SortedMoviesRequest request = SortedMoviesRequest.builder()
                .sortingOrder(SortingOrder.ASC)
                .sortingParameter(SortingParameter.PRICE)
                .build();

        //when
        List<Movie> allMovies = movieService.findAll(request);

        //then
        assertNotNull(allMovies);
        assertEquals(25, allMovies.size());
        assertEquals(100, allMovies.get(0).getPrice());
        assertEquals(200.60, allMovies.get(24).getPrice());
    }

    @Test
    void testFindRandom() {
        //when
        List<Movie> randomMovies = movieService.findRandom();

        //then
        assertNotNull(randomMovies);
        assertEquals(3, randomMovies.size());
        for (Movie movie : randomMovies) {
            assertNotNull(movie);
        }
    }

    @DisplayName("Get movies by genre from DB order by price DESC")
    @Test
//    @DataSet(value = "movies_genres_and_movie_to_genre.xml")
    void testFindByGenrePriceDesc() {
        //prepare
        SortedMoviesRequest request = SortedMoviesRequest.builder()
                .sortingOrder(SortingOrder.DESC)
                .sortingParameter(SortingParameter.PRICE)
                .build();
        //when
        List<Movie> actualMovies = movieService.findByGenre(1L, request);

        //then
        assertNotNull(actualMovies);
        assertEquals(2, actualMovies.size());
        for (Movie movie : actualMovies) {
            assertNotNull(movie);
        }
        assertEquals(134.67, actualMovies.get(0).getPrice());
        assertEquals(123.45, actualMovies.get(1).getPrice());
    }

    @DisplayName("Get movies by genre from DB order by rating ASC")
    @Test
    @DataSet(value = "movies_genres_and_movie_to_genre.xml")
    void testFindByGenreRatingAsc() {
        //prepare
        SortedMoviesRequest request = SortedMoviesRequest.builder()
                .sortingOrder(SortingOrder.ASC)
                .sortingParameter(SortingParameter.RATING)
                .build();
        //when
        List<Movie> actualMovies = movieService.findByGenre(5L, request);

        //then
        assertNotNull(actualMovies);
        assertEquals(2, actualMovies.size());
        for (Movie movie : actualMovies) {
            assertNotNull(movie);
        }
        assertEquals(8.9, actualMovies.get(0).getRating());
        assertEquals(8.9, actualMovies.get(1).getRating());
    }
}