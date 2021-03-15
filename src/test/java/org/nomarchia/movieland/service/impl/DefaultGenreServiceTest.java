package org.nomarchia.movieland.service.impl;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.nomarchia.movieland.MovielandApplicationContext;
import org.nomarchia.movieland.config.HibernateUtil;
import org.nomarchia.movieland.entity.Genre;
import org.nomarchia.movieland.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringJUnitWebConfig(MovielandApplicationContext.class)
class DefaultGenreServiceTest {
    @Autowired
    private GenreService genreService;

    @Test
    void testFindAll() {
        List<Genre> allGenres = genreService.findAll();

        assertEquals(15, allGenres.size());
    }

    @Test
    void testFindAllAndCheckCache() {
        List<Genre> allGenres = genreService.findAll();

        assertEquals(15, allGenres.size());

        Session session = HibernateUtil.getSession();
        CacheMode cacheMode = session.getCacheMode();

        allGenres = genreService.findAll();

        assertEquals(15, allGenres.size());
    }
}