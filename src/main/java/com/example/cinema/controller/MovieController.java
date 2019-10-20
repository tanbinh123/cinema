package com.example.cinema.controller;

import com.example.cinema.domain.Movie;
import com.example.cinema.domain.Poster;
import com.example.cinema.service.MovieService;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/cinema/movie")
@AllArgsConstructor
public class MovieController {

    private MovieService movieService;

    @GetMapping("")
    public Stream<Movie> getAllMovies(){
        return movieService.getAllMovies(Pageable.unpaged()).get();
    }
    @GetMapping("/sorted")
    public Stream<Movie> getAllMoviesSorted(){
        return movieService.getAllMovies(PageRequest.of(1,3, Sort.by("title"))).get();
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie){
        Long id = movieService.createMovie(movie.getTitle(), movie.getCategory(), movie.getLength(), movie.getDescription(), movie.getRequiredAge(),null );
        movie.setId(id);
        return movie;
    }

//    @PostMapping("/add1")
//    public Movie addMovie1(@RequestBody Movie movie, @RequestBody String poster){
//        Long id = movieService.createMovie(movie.getTitle(), movie.getCategory(), movie.getLength(), movie.getDescription(), movie.getRequiredAge(),poster );
//        movie.setId(id);
//        return movie;
//    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long id){
       return movieService.getMovie(id).get();
    }



}
