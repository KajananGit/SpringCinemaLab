package com.example.task02_cinema.services;

import com.example.task02_cinema.models.Movie;
import com.example.task02_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    public MovieService(){}

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public Optional<Movie> getMovieById(long id){
        return movieRepository.findById(id);
    }

    public void updateMovie(long id, Movie movie){
        movie.setId(id);
        movieRepository.save(movie);
    }

    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }



}
