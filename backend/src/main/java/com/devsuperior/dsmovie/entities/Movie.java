package com.devsuperior.dsmovie.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;

    public Movie() {
    }

    public Movie(Long id, Double score, Integer count, String image) {
        this.id = id;
        this.score = score;
        this.count = count;
        this.image = image;
    }
}
