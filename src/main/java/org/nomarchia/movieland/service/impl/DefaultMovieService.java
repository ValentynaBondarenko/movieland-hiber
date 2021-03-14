package org.nomarchia.movieland.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import org.nomarchia.movieland.config.HibernateUtil;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.repository.MovieRepository;
import org.nomarchia.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;
    @Value("${random.movies.amount :3}")
    private Integer moviesAmount;

    @Override
    public List<Movie> findAll() {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> movieIterable = movieRepository.findAll();
        movieIterable.forEach(movies::add);

        return movies;
    }

    @Override
    public List<Movie> findRandom() {
        String queryString = "SELECT m FROM Movie m ORDER BY random()";
        Session session = HibernateUtil.getSession();

        return session.createQuery(queryString, Movie.class).setMaxResults(moviesAmount).list();
    }

    @Override
    public List<Movie> findByGenre(Long genreId) {
        String queryString = "SELECT m FROM Movie m join m.genres g where g.id = :genreId";
        Session session = HibernateUtil.getSession();

        return session.createQuery(queryString, Movie.class).setParameter("genreId", genreId).list();
    }
}
