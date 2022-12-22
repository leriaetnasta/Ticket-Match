package com.example.ticketmatch.exceptions;

public class TicketNumberException extends Exception{
    public TicketNumberException(){
        super("The number of tickets is incorrect");
    }
}
