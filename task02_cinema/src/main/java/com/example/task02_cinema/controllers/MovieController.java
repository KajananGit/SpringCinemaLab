package com.example.task02_cinema.controllers;

import com.example.task02_cinema.models.Movie;
import com.example.task02_cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping(value =  "/{id}")
    public ResponseEntity<Optional> getMovie(@PathVariable long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie){
        movieService.updateMovie(id, movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }


}
