package com.example.ticketmatch.repositories;

import com.example.ticketmatch.entities.AchatTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchatTicketRepository extends JpaRepository<AchatTicket,Long> {
}
