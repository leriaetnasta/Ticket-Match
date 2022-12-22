package com.example.ticketmatch.repositories;

import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match,Long> {
}
