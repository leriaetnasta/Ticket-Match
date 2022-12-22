package com.example.ticketmatch.service.interfaces;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.entities.Match;

import java.text.ParseException;
import java.util.List;

public interface MatchService {
    List<Match> userMatchs();

    Match saveMatch(AddMatchRequestDTO addMatchRequestDTO) throws ParseException;

}
