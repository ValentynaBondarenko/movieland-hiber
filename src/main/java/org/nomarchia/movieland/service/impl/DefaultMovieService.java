package org.nomarchia.movieland.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import org.nomarchia.movieland.common.SortingOrder;
import org.nomarchia.movieland.common.SortingParameter.*;
import org.nomarchia.movieland.config.HibernateUtil;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.repository.MovieRepository;
import org.nomarchia.movieland.request.SortedMoviesRequest;
import org.nomarchia.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.nomarchia.movieland.common.SortingOrder.*;
import static org.nomarchia.movieland.common.SortingParameter.*;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMovieService implements MovieService {
    private final MovieRepository movieRepository;
    @Value("${random.movies.amount :3}")
    private Integer moviesAmount;

    @Override
    public List<Movie> findAll(SortedMoviesRequest request) {
        List<Movie> movies = new ArrayList<>();
        Iterable<Movie> movieIterable = request == null ?
                movieRepository.findAll() : movieRepository.findAll(getSortParam(request));
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
    public List<Movie> findByGenre(Long genreId, SortedMoviesRequest request) {
        Session session = HibernateUtil.getSession();

        String queryString = "SELECT m FROM Movie m join m.genres g where g.id = :genreId";

        if (request != null) {
            queryString += " order by m." + request.getSortingParameter().getParamName() + " " + request.getSortingOrder().getOrderDirection().toLowerCase();
        }

        return session.createQuery(queryString, Movie.class)
                .setParameter("genreId", genreId)
                .list();
    }

    private Sort getSortParam(SortedMoviesRequest request) {
        Sort sort = request.getSortingOrder() == ASC ? request.getSortingParameter() == RATING ?
                Sort.by(Sort.Direction.ASC, "rating") : Sort.by(Sort.Direction.ASC, "price") :
                request.getSortingParameter() == RATING ?
                Sort.by(Sort.Direction.DESC, "rating") : Sort.by(Sort.Direction.DESC, "price");

        return sort;
    }
}
