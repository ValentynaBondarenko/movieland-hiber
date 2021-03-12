package org.nomarchia.movieland.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.repository.MovieRepository;
import org.nomarchia.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
//@Transactional
//@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> movieIterable = movieRepository.findAll();
        movieIterable.forEach(movies::add);

        return movies;
    }
}
