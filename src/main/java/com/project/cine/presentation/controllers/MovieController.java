package com.project.cine.presentation.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.web.bind.annotation.*;

import com.project.cine.application.services.MovieService;
import com.project.cine.domain.models.MovieModel;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ArrayList<MovieModel> getAllMovie() {
        return movieService.getAllMovies();
    }

    @PostMapping
    public MovieModel saveMovie(@RequestBody MovieModel movie) {
        return movieService.saveMovie(movie);
    }

    @GetMapping(path = "/{id}")
    public Optional<MovieModel> getMovieById(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteMovie(@PathVariable("id") Long id) {
        return movieService.deleteMovie(id);
    }

}
