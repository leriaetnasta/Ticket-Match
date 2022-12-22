package com.example.ticketmatch.service;

import com.example.ticketmatch.dto.AddTicketRequestDTO;
import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.entities.Ticket;
import com.example.ticketmatch.enums.Status;
import com.example.ticketmatch.exceptions.MatchNotFoundException;
import com.example.ticketmatch.exceptions.TicketNotFoundException;
import com.example.ticketmatch.exceptions.TicketUnavailableException;
import com.example.ticketmatch.repositories.MatchRepository;
import com.example.ticketmatch.repositories.TicketRepository;
import com.example.ticketmatch.service.interfaces.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    MatchRepository matchRepository;
    TicketRepository ticketRepository;
    public TicketServiceImpl(MatchRepository matchRepository, TicketRepository ticketRepository) {
        this.matchRepository =matchRepository;
        this.ticketRepository =ticketRepository;
    }
    @Override
    public void loadData() throws IOException, ParseException {
        URI uri = new ClassPathResource("fifa-world-cup-2022.csv").getURI();
        Path path=Paths.get(uri);
        List<String> list= Files.readAllLines(path);
        for (int i = 1; i < list.size(); i++) {
            String[] ligne =list.get(i).split(",");
            System.out.println(ligne[2]);
            Match match=Match.builder()
                    .date(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(ligne[2]))
                    .lieu(ligne[3])
                    .equipe1(ligne[4])
                    .equipe2(ligne[5])
                    .reference("M_"+i+new Random().nextInt(10))
                    .nombreTicket(1000)
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
            match.setNombreTicket(match.getNombreTicket()-1);
        ticketRepository.save(ticket);

        });
        Stream.of(6L,7L,8L,9L,10L).forEach(id->{
            Match match=matchRepository.findById(id).orElseThrow(()->new RuntimeException("Match not found"));
            Ticket ticket=new Ticket();
            ticket.setMatch(match);
            ticket.setPrix(3000);
            ticket.setStatus(Status.ACTIVE);
            ticket.setReference("T_"+id+new Random().nextInt(1000));
            match.setNombreTicket(match.getNombreTicket()-1);
            ticketRepository.save(ticket);

        });

    }

    @Override
    public Ticket achatTicket(AddTicketRequestDTO addTicketRequestDTO) throws MatchNotFoundException, TicketUnavailableException {

        Match match = matchRepository.findById(addTicketRequestDTO.getMatchId())
                .orElseThrow(
                        () -> new MatchNotFoundException()
                );
        if(match.getNombreTicket()==0){
            throw new TicketUnavailableException();
        }
        Ticket ticket=Ticket.builder()
                .reference(UUID.randomUUID().toString().substring(1,16))
                .prix(addTicketRequestDTO.getPrix())
                .status(Status.DESACTIVE)
                .match(match)
                .build();
        match.setNombreTicket(match.getNombreTicket()-1);
        ticketRepository.save(ticket);
        return ticket;
    }
    @Override
    public Ticket activationTicket(Long ticketId) throws TicketNotFoundException {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException());
        ticket.setStatus(Status.ACTIVE);
        return ticketRepository.save(ticket);
    }
    @Override

    public List<Ticket> userTickets(){
        return ticketRepository.findAll();
    }

    @Override
    public Ticket ticketByID(@Argument Long id){
        return ticketRepository.findById(id).get();
    }


}
