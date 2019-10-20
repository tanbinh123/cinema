package com.example.cinema;

import com.example.cinema.domain.Movie;
import com.example.cinema.service.MarathonService;
import com.example.cinema.service.MovieService;
import com.example.cinema.service.SessionService;
import com.example.cinema.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class CinemaRunner implements CommandLineRunner {
    private final static Logger LOG = LoggerFactory.getLogger(CinemaRunner.class);

    private MarathonService marathonService;
    private MovieService movieService;
    private SessionService sessionService;
    private TicketService ticketService;

    public CinemaRunner(MarathonService marathonService, MovieService movieService, SessionService sessionService, TicketService ticketService) {
        this.marathonService = marathonService;
        this.movieService = movieService;
        this.sessionService = sessionService;
        this.ticketService = ticketService;
    }

    @Override
    public void run(String... args) throws Exception {
        movieServiceInvocations();
    }

    private void movieServiceInvocations(){
        Page<Movie> allMovies = movieService.getAllMovies(PageRequest.of(1,3, Sort.by("title")));
        LOG.info("1. All Movies. Total Elements={}, Total Pages={} ", allMovies.getTotalElements(), allMovies.getTotalPages());
        allMovies.get().forEach(movie -> LOG.info( "  {}", movie));

        Page<Movie> moviesByPartOfTitle = movieService.getMovieByPartOfTitle("gry", Pageable.unpaged());
        LOG.info("2. MoviesByPartOfTittle. Total element = {}, Total Pages ={}", moviesByPartOfTitle.getTotalElements(), moviesByPartOfTitle.getTotalPages());


    }

}
