package com.example.ticketmatch.dto;

import com.example.ticketmatch.entities.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class AddMatchRequestDTO {
    private String date;
    private String lieu;
    private String equipe1;
    private String equipe2;
    private int nombreTicket;
}
