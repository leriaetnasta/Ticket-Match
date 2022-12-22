package com.example.ticketmatch;

import com.example.ticketmatch.service.TicketServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TicketMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(TicketMatchApplication.class, args);
    }
    //@Bean
    CommandLineRunner start(TicketServiceImpl ticketService){
        return args -> {
            ticketService.loadData();
        };
    }
}
