package com.example.ticketmatch.exceptions;

public class TicketUnavailableException extends Exception{
    public TicketUnavailableException(){
        super("Ticket Unavailable");
    }
}