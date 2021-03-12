package org.nomarchia.movieland.repository;

import org.nomarchia.movieland.entity.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
