package com.example.ticketmatch.repositories;

import com.example.ticketmatch.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
