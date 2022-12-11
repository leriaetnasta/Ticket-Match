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

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "reference", unique = true)
    private String reference;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String lieu;
    private String equipe1;
    private String equipe2;
    @OneToMany(mappedBy = "match")
    private List<Ticket> ticket;
}
