package org.nomarchia.movieland.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Movie")
@Data
@Table(name = "movies")
public class Movie {
    @Id
//    Check if that annotation is necessary
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name_native", nullable = false)
    private String nameNative;
    @Column(name = "name_russian")
    private String nameRussian;
    @Column(name = "year")
    private Integer yearOfRelease;
    /*@Column(name = "description")
    private String description;*/
    @Column(name = "rating")
    private Double rating;
    @Column(name = "price")
    private Double price;
    @Column(name = "poster_img")
    private String picturePath;
}
