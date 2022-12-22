package com.example.ticketmatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder @Table(name="match_table")

public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column( unique = true)
    private String reference;
    private Date date;
    private String lieu;
    private String equipe1;
    private String equipe2;
    @OneToMany(mappedBy = "match")
    private List<Ticket> ticket;
    private int nombreTicket;

}
