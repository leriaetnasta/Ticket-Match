package com.example.ticketmatch.dto;

import com.example.ticketmatch.entities.Match;
import com.example.ticketmatch.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddTicketRequestDTO {

    private double prix;
    private Long matchId;

}
