package com.example.cinema.repository;

import com.example.cinema.domain.Session;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface SessionRepository extends JpaRepository<Session, Long> {

    @Query(value = "select s from Session s where function('DATE_TRUNG', 'day', s.startTime)=?1")
    List<Session> findAllByStartDate(Date date);

    @EntityGraph(value = "Session.tickets", type = EntityGraph.EntityGraphType.LOAD)
    Optional<Session> readById(Long id);
}
