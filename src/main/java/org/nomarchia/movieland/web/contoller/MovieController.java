package org.nomarchia.movieland.web.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nomarchia.movieland.common.SortingOrder;
import org.nomarchia.movieland.common.SortingParameter;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.request.SortedMoviesRequest;
import org.nomarchia.movieland.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> findAll(
            @RequestParam(name = "rating", required = false) SortingOrder ratingOrder,
            @RequestParam(name = "price", required = false) SortingOrder priceOrder) {
        return movieService.findAll(new SortedMoviesRequest());
    }

    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> findRandom() {
        return movieService.findRandom();
    }

    @GetMapping(value = "/genre/{genreId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> findByGenre(@PathVariable Long genreId,
                                   @RequestParam(name = "rating", required = false) SortingOrder ratingOrder,
                                   @RequestParam(name = "price", required = false) SortingOrder priceOrder) {
        return movieService.findByGenre(genreId, new SortedMoviesRequest());
    }

    public SortedMoviesRequest processOrderBy(SortingOrder ratingOrder, SortingOrder priceOrder) {
        SortedMoviesRequest moviesRequest = ratingOrder != null
                ? SortedMoviesRequest.builder().sortingOrder(ratingOrder).sortingParameter(SortingParameter.RATING).build()
                : priceOrder != null
                ? SortedMoviesRequest.builder().sortingOrder(priceOrder).sortingParameter(SortingParameter.PRICE).build()
                : null;

        return moviesRequest;
    }
}
