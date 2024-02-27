package com.example.task02_cinema.components;

import com.example.task02_cinema.models.Movie;
import com.example.task02_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    MovieRepository movieRepository;

    Movie movie1 = new Movie("Big short", "PG15", 90);
    Movie movie2 = new Movie("Cars", "PG12", 120);
    Movie movie3 = new Movie("Harry Potter: Part 1", "PG15", 160);
    Movie movie4 = new Movie("Wolf of Wall Street", "PG18", 160);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        movieRepository.save(movie1);
        movieRepository.save(movie2);
        movieRepository.save(movie3);
        movieRepository.save(movie4);
    }
}
