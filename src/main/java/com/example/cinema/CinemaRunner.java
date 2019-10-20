package com.example.cinema;

import com.example.cinema.domain.EMovieCategory;
import com.example.cinema.domain.Movie;
import com.example.cinema.domain.Session;
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

import java.time.LocalDate;
import java.util.List;

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
        sessionServiceInvocations();
    }

    private void movieServiceInvocations(){
        Page<Movie> allMovies = movieService.getAllMovies(PageRequest.of(1,3, Sort.by("title")));
        LOG.info("1. All Movies. Total Elements={}, Total Pages={} ", allMovies.getTotalElements(), allMovies.getTotalPages());
        allMovies.get().forEach(movie -> LOG.info( "  {}", movie));

        Page<Movie> moviesByPartOfTitle = movieService.getMovieByPartOfTitle("Gry", Pageable.unpaged());
        LOG.info("2. MoviesByPartOfTittle. Total element = {}, Total Pages ={}", moviesByPartOfTitle.getTotalElements(), moviesByPartOfTitle.getTotalPages());
        moviesByPartOfTitle.get().forEach(movie -> LOG.info("  {}", movie));

        Page<Movie> comedyMovies = movieService.getMoviesInCateory(EMovieCategory.COMEDY, Pageable.unpaged());
        LOG.info("3. Comedy movies. Total elements= {}, Total pages= {}.", comedyMovies.getTotalElements(), comedyMovies.getTotalPages());
        comedyMovies.get().forEach(movie -> LOG.info("  {}", movie));

        Movie movieWithId7 = movieService.getMovie(7L).get();
        LOG.info("4. Movie with id 7 - {}", movieWithId7);
        movieService.updateMovie(7L, movieWithId7.getTitle(), EMovieCategory.DRAMA, 140, movieWithId7.getDescription(),18, "/images/none.png");;

        Movie movieWithId7AfterUpdate = movieService.getMovie(7L).get();
        LOG.info("5. Movie with id 7 after update: {}", movieWithId7AfterUpdate);

        Long newMovieId = movieService.createMovie("Jak wytresować smoka", EMovieCategory.FAMILY, 104, "" +
                "Witamy w krainie smoków", 12,"/images/smok.png" );
        Movie movie = movieService.getMovie(newMovieId).get();
        LOG.info("6. New movie: {}", movie);

        movieService.removeMovie(7L);
    }

    private void sessionServiceInvocations(){
        List<Session> sessionsIn02052019 = sessionService.getSessionsInDate(LocalDate.of(2019,5,2));
        LOG.info("7. Session in 2 May 2019, ammount of sessions {} ",sessionsIn02052019.size() );
        sessionsIn02052019.forEach(session -> LOG.info("  {}", session));

        Session sessionWithId15 = sessionService.getSession(15L).get();
            LOG.info("8. Session with id 5: {}, movie title: {}, room: {}", sessionWithId15, sessionWithId15.getMovie().getTitle(), sessionWithId15.getRoom().getName());

        Session sessionWithId5WithTickets = sessionService.getSession(15L).get();
        LOG.info("9. Session wit id 5 witch tickets: {}, movie title: {}, room: {}", sessionWithId5WithTickets, sessionWithId5WithTickets.getMovie().getTitle(),
                sessionWithId5WithTickets.getRoom().getName());
        sessionWithId5WithTickets.getTickets().forEach(ticket -> LOG.info("  {}", ticket));
    }


}
