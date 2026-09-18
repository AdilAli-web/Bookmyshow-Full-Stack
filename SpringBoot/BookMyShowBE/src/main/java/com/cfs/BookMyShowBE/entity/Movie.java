package com.cfs.BookMyShowBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies",uniqueConstraints = @UniqueConstraint(name = "uk_movie_title",columnNames = "title"))
public class Movie {

public Movie(){

}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String language;

    private String genre;

    private Integer durationMinutes;
    private String certificate;
    private String description;
    private String posterUrl;
    private String trailerUrl;
    private boolean active=true;


}
