package com.example.ticketmatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "reference", unique = true, length = 16)
    private String reference;
    private double prix;
    @OneToOne
    private Match match;
    @OneToMany(mappedBy = "ticket")
    private List<AchatTicket> achatTickets;


}
