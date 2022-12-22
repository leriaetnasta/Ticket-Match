package com.example.ticketmatch.repositories;

import com.example.ticketmatch.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    @Query("select t from Ticket t where t.match like :id")
    List<Ticket> searchTickets(@Param("id") Long id);
}
