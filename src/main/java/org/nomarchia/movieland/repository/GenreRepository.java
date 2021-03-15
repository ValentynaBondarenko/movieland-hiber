package org.nomarchia.movieland.repository;

import org.nomarchia.movieland.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
