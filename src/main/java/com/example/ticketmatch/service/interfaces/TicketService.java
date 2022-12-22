package com.example.ticketmatch.service.interfaces;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.dto.AddTicketRequestDTO;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.exceptions.MatchNotFoundException;
import com.example.ticketmatch.exceptions.TicketNotFoundException;
import com.example.ticketmatch.exceptions.TicketUnavailableException;
import org.springframework.graphql.data.method.annotation.Argument;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface TicketService {
    void loadData() throws IOException, ParseException;
    public Ticket achatTicket(AddTicketRequestDTO addTicketRequestDTO) throws MatchNotFoundException, TicketUnavailableException;

    Ticket activationTicket(Long ticketId) throws TicketNotFoundException;

    List<Ticket> userTickets();

    Ticket ticketByID(@Argument Long id);

    List<Ticket> ticketParMatch(@Argument Long id) throws MatchNotFoundException;
}
