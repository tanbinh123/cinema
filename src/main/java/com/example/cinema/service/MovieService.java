package com.example.cinema.service;

import com.example.cinema.domain.EMovieCategory;
import com.example.cinema.domain.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MovieService {
    Long createMovie(String title, EMovieCategory category, Integer length, String description, Integer requiredAge, String posterFilePath);

    Optional<Movie> getMovie(Long movieId);

    Page<Movie> getMoviesInCateory(EMovieCategory category, Pageable pageable);

    Page<Movie> getMovieByPartOfTitle(String partOfTitle, Pageable pageable);

    Page<Movie> getAllMovies(Pageable pageable);

    void updateMovie(Long movieId, String title, EMovieCategory category, Integer length, String description, Integer requiredAge, String posterFilePath);

    void removeMovie(Long movieId);
}
