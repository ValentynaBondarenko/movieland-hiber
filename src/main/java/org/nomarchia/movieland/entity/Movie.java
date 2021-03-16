package org.nomarchia.movieland.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;
import java.util.*;


@Data
//@Builder
@Entity(name = "Movie")
@Table(name = "movies")
//@AllArgsConstructor
public class Movie {
    @Id
    private Long id;
    @Column(name = "name_native", nullable = false)
    private String nameNative;
    @Column(name = "name_russian")
    private String nameRussian;
    @Column(name = "year")
    private Integer yearOfRelease;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "price")
    private Double price;
    @Column(name = "poster_img")
    private String picturePath;

    @ManyToMany(cascade = { CascadeType.ALL }/*, targetEntity = org.nomarchia.movieland.entity.Genre.class*/)
    @JoinTable(
            name = "movie_to_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
            )
    private Set<Genre> genres;
}
