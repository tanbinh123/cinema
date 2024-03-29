package com.example.cinema.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor

@Getter
@Setter
@ToString
public class Ticket extends AbstractEqualsAndHashCode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String seat;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    public Ticket(Long id, String seat, BigDecimal price) {
        super(id);
        this.seat = seat;
        this.price = price;
    }
}
