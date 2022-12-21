package com.example.ticketmatch.entities;

import com.example.ticketmatch.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "reference", unique = true, length = 16)
    private String reference;
    private double prix;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    private Match match;


}
