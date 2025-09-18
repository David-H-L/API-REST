package com.project.cine.domain.models;

import jakarta.persistence.*;

@Entity
@Table(name = "image")
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name = "id_image")
    private Long idImage;

    @Column(nullable = false)
    private String url;

    @OneToOne
    @JoinColumn(name = "id_movie_fk", nullable = false)
    private MovieModel movie;

}
