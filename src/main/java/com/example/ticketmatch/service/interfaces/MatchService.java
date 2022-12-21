package com.example.ticketmatch.service.interfaces;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.entities.Match;

import java.text.ParseException;

public interface MatchService {
    Match saveMatch(AddMatchRequestDTO addMatchRequestDTO) throws ParseException;

}
