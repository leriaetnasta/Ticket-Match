package com.example.ticketmatch.web;

import com.example.ticketmatch.entities.AchatTicket;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.repositories.TicketRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TicketGraphQLController {
    private TicketRepository ticketRepository;
    private

    public TicketGraphQLController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @QueryMapping
    public List<Ticket> userTickets(){
        return ticketRepository.findAll();
    }
    @QueryMapping
    public Ticket ticketByID(@Argument Long id){
        return ticketRepository.findById(id).get();
    }

    public Ticket ajoutMatch(AddMatchRequestDTO match){

    }

}

