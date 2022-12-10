package com.example.ticketmatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "reference", unique = true)
    private String reference;

    private Date date;
    private String lieu;
    private String equipe1;
    private String equipe2;
    @OneToOne
    private Ticket ticket;
}
