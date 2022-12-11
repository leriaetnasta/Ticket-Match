package com.example.ticketmatch.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AchatTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Long timestamp;
    private int quantite;
    private double prix;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;
}
