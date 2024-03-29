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
public class Session extends AbstractEqualsAndHashCode{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime startTime;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ticket> tickets;

    public Session(Long id, LocalDateTime startTime) {
        super(id);
        this.startTime = startTime;
    }

    public List<Ticket> getTickets() {
        if (tickets == null) tickets = new ArrayList<>();
        return tickets;
    }

    public void addTicket(Ticket ticket){
        getTickets().add(ticket);
        ticket.setSession(this);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", startTime=" + startTime +
                '}';
    }
}
