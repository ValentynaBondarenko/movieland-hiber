package org.nomarchia.movieland.entity;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;


@Data
@Builder
@Entity(name = "Movie")
@Table(name = "public.movies")
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
}
