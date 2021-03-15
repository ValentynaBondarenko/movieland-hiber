package org.nomarchia.movieland.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.nomarchia.movieland.entity.Genre;
import org.nomarchia.movieland.repository.GenreRepository;
import org.nomarchia.movieland.service.GenreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class DefaultGenreService implements GenreService {
    private final GenreRepository genreRepository;

    @Override
    @Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
    public List<Genre> findAll() {
        return (List<Genre>) genreRepository.findAll();
    }
}
