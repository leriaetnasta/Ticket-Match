package com.example.ticketmatch.web;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.dto.AddTicketRequestDTO;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.exceptions.MatchNotFoundException;
import com.example.ticketmatch.exceptions.TicketNotFoundException;
import com.example.ticketmatch.exceptions.TicketNumberException;
import com.example.ticketmatch.exceptions.TicketUnavailableException;
import com.example.ticketmatch.repositories.MatchRepository;
import com.example.ticketmatch.repositories.TicketRepository;
import com.example.ticketmatch.service.interfaces.MatchService;
import com.example.ticketmatch.service.interfaces.TicketService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.text.ParseException;
import java.util.List;

@Controller
public class TicketGraphQLController {
    private TicketService ticketService;
    private MatchService matchService;

    public TicketGraphQLController(TicketService ticketService,MatchService matchService) {
        this.matchService=matchService;
        this.ticketService=ticketService;
    }

    @QueryMapping
    public List<Ticket> userTickets(){
        return this.ticketService.userTickets();
    }
    @QueryMapping
    public Ticket ticketByID(@Argument Long id){
        return this.ticketService.ticketByID(id);
    }
    @MutationMapping
    public Match saveMatch(@Argument AddMatchRequestDTO addMatchRequestDTO) throws ParseException, TicketUnavailableException, TicketNumberException {
        return matchService.saveMatch(addMatchRequestDTO);
    }
    @MutationMapping
    public Ticket achatTicket(@Argument AddTicketRequestDTO addTicketRequestDTO) throws MatchNotFoundException, TicketUnavailableException {
        return ticketService.achatTicket(addTicketRequestDTO);
    }
    @QueryMapping
    public List<Match> userMatchs(){
        return matchService.userMatchs();
    }

    @MutationMapping
    private Ticket modificationTicket(@Argument Long ticketId) throws TicketNotFoundException {
        return ticketService.activationTicket(ticketId);
    }
}

