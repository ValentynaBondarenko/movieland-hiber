package org.nomarchia.movieland.service;

import org.nomarchia.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    List<Movie> findRandom();

    List<Movie> findByGenre(Long genreId);
}
