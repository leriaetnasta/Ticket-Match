package com.example.ticketmatch.service;

import com.example.ticketmatch.entities.AchatTicket;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.enums.Status;
import com.example.ticketmatch.repositories.AchatTicketRepository;
import com.example.ticketmatch.repositories.MatchRepository;
import com.example.ticketmatch.repositories.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.swing.plaf.UIResource;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class TicketService {

    MatchRepository matchRepository;
    TicketRepository ticketRepository;
    AchatTicketRepository achatTicketRepository;

    public TicketService(MatchRepository matchRepository,TicketRepository ticketRepository,AchatTicketRepository achatTicketRepository) {
        this.achatTicketRepository = achatTicketRepository;
        this.matchRepository =matchRepository;
        this.ticketRepository =ticketRepository;
    }

    public void loadData() throws IOException, ParseException {
        URI uri = new ClassPathResource("fifa-world-cup-2022.csv").getURI();
        Path path=Paths.get(uri);
        List<String> list= Files.readAllLines(path);
        for (int i = 1; i < list.size(); i++) {
            String[] ligne =list.get(i).split(",");
            Match match=Match.builder()
                    .date(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(ligne[2]))
                    .lieu(ligne[3])
                    .equipe1(ligne[4])
                    .equipe2(ligne[5])
                    .reference("M_"+i+new Random().nextInt(10))
                    .build();
            matchRepository.save(match);
    }
        Stream.of(1L,2L,3L,4L,5L).forEach(id->{
            Match match=matchRepository.findById(id).orElseThrow(()->new RuntimeException("Match not found"));
        Ticket ticket=new Ticket();
        ticket.setMatch(match);
        ticket.setPrix(3000);
        ticket.setStatus(Status.DESACTIVE);
        ticket.setReference("T_"+id+new Random().nextInt(1000));
        ticketRepository.save(ticket);

        });
        Stream.of(6L,7L,8L,9L,10L).forEach(id->{
            Match match=matchRepository.findById(id).orElseThrow(()->new RuntimeException("Match not found"));
            Ticket ticket=new Ticket();
            ticket.setMatch(match);
            ticket.setPrix(3000);
            ticket.setStatus(Status.ACTIVE);
            ticket.setReference("T_"+id+new Random().nextInt(1000));
            ticketRepository.save(ticket);

        });
        ticketRepository.findAll().forEach(ticket -> {
            for (int i = 0; i <10 ; i++) {
                AchatTicket achatTicket=AchatTicket.builder()
                        .ticket(ticket)
                        .quantite(1+new Random().nextInt(10))
                        .timestamp(System.currentTimeMillis())
                        .build();
                achatTicketRepository.save(achatTicket);
                achatTicket.setPrix(ticket.getPrix()*achatTicket.getQuantite());
            }
        });
    }
}
