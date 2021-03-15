package org.nomarchia.movieland.repository;

import org.nomarchia.movieland.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
}
