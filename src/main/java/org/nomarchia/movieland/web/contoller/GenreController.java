package org.nomarchia.movieland.web.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.nomarchia.movieland.service.GenreService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/genre", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;
}
