package com.example.ticketmatch.service.interfaces;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.dto.AddTicketRequestDTO;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.exceptions.MatchNotFoundException;
import com.example.ticketmatch.exceptions.TicketNotFoundException;

import java.io.IOException;
import java.text.ParseException;

public interface TicketService {
    void loadData() throws IOException, ParseException;
    public Ticket achatTicket(AddTicketRequestDTO addTicketRequestDTO) throws MatchNotFoundException;

    Ticket activationTicket(Long ticketId) throws TicketNotFoundException;
}
