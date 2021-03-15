package org.nomarchia.movieland.service;

import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.request.SortedMoviesRequest;

import java.util.List;

public interface MovieService {
    List<Movie> findAll(SortedMoviesRequest movieRequest);

    List<Movie> findRandom();

    List<Movie> findByGenre(Long genreId, SortedMoviesRequest movieRequest);
}
