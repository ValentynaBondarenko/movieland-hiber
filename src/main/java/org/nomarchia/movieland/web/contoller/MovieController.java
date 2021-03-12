package org.nomarchia.movieland.web.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nomarchia.movieland.entity.Movie;
import org.nomarchia.movieland.service.MovieService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MovieController {
    private MovieService movieService;

    public List<Movie> findAll() {
        return movieService.findAll();
    }

}
