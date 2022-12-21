package com.example.ticketmatch.exceptions;

public class MatchNotFoundException extends Exception{
    public MatchNotFoundException(){
        super("Match Not Found");
    }
}
