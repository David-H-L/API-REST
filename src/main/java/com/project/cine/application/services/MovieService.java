package com.project.cine.application.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.cine.domain.models.MovieModel;
import com.project.cine.domain.repositories.MovieRepository;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public ArrayList<MovieModel> getAllMovies() {
        return (ArrayList<MovieModel>) movieRepository.findAll();
    }

    public Optional<MovieModel> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public MovieModel saveMovie(MovieModel movie) {
        return movieRepository.save(movie);
    }

    public boolean deleteMovie(Long id) {
        try {
            movieRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}