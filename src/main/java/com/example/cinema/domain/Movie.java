package com.example.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Movie extends AbstractEqualsAndHashCode{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private EMovieCategory category;
    private Integer length;
    private String description;
    private Integer requiredAge;
    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Marathon> marathons;

    public List<Marathon> getMarathons() {
        if (marathons == null)marathons = new ArrayList<>();
        return marathons;
    }
}
