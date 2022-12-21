package com.example.ticketmatch.exceptions;

public class TicketNotFoundException extends Exception{
    public TicketNotFoundException(){
        super("Ticket Not Found");
    }
}
