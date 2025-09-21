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

    public Long getIdImage() {
        return idImage;
    }

    public void setIdImage(Long idImage) {
        this.idImage = idImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

}
