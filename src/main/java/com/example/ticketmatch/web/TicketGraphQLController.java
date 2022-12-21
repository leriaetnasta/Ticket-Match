package com.example.ticketmatch.web;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.dto.AddTicketRequestDTO;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.exceptions.MatchNotFoundException;
import com.example.ticketmatch.exceptions.TicketNotFoundException;
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
    private TicketRepository ticketRepository;
    private TicketService ticketService;
    private MatchService matchService;
    private MatchRepository matchRepository;

    public TicketGraphQLController(MatchRepository matchRepository,TicketRepository ticketRepository,TicketService ticketService,MatchService matchService) {
        this.ticketRepository = ticketRepository;
        this.matchService=matchService;
        this.ticketService=ticketService;
        this.matchRepository=matchRepository;
    }

    @QueryMapping
    public List<Ticket> userTickets(){
        return ticketRepository.findAll();
    }
    @QueryMapping
    public Ticket ticketByID(@Argument Long id){
        return ticketRepository.findById(id).get();
    }
    @MutationMapping
    public Match saveMatch(@Argument AddMatchRequestDTO addMatchRequestDTO) throws ParseException {
        return matchService.saveMatch(addMatchRequestDTO);
    }
    @MutationMapping
    public Ticket achatTicket(@Argument AddTicketRequestDTO addTicketRequestDTO) throws MatchNotFoundException {
        return ticketService.achatTicket(addTicketRequestDTO);
    }
    @QueryMapping
    public List<Match> userMatchs(){
        return matchRepository.findAll();
    }

    @MutationMapping
    private Ticket modificationTicket(@Argument Long ticketId) throws TicketNotFoundException {
        return ticketService.activationTicket(ticketId);
    }
}

