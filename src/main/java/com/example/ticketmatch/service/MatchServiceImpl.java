package com.example.ticketmatch.service;

import com.example.ticketmatch.dto.AddMatchRequestDTO;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.repositories.MatchRepository;
import com.example.ticketmatch.service.interfaces.MatchService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class MatchServiceImpl implements MatchService {
    MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }
    @Override
    public List<Match> userMatchs(){
        return matchRepository.findAll();
    }

    @Override
    public Match saveMatch(AddMatchRequestDTO addMatchRequestDTO) throws ParseException {
        String s=addMatchRequestDTO.getDate();
        Match match=Match.builder()
                .date(new Date()) //to be fixed
                .reference(UUID.randomUUID().toString())
                .lieu(addMatchRequestDTO.getLieu())
                .equipe1(addMatchRequestDTO.getEquipe1())
                .equipe2(addMatchRequestDTO.getEquipe2())
                .build();
        matchRepository.save(match);
        return match;
    }
}
