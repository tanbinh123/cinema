package com.example.cinema.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private EMovieCategory category;
    private Integer length;
    private String description;
    private Integer requiredAge;


}
