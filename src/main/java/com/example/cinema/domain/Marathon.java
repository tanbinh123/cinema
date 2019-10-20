package com.example.cinema.domain;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Marathon extends AbstractEqualsAndHashCode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private LocalDateTime startTime;

    public Marathon(Long id, String name, LocalDateTime startTime) {
        super(id);
        this.name = name;
        this.startTime = startTime;
    }

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "marathon_movie",
            joinColumns = @JoinColumn(name = "marathon_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies;

    public List<Movie> getMovies() {
        if (movies == null) movies = new ArrayList<>();
        return movies;
    }
}
