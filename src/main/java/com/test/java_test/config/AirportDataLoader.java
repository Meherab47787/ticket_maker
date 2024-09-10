package com.test.java_test.config;

import com.test.java_test.entity.Airport;
import com.test.java_test.entity.Ticket;
import com.test.java_test.repository.AirportRepository;
import com.test.java_test.repository.TicketRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Order(1)
public class AirportDataLoader {

    private final AirportRepository airportRepository;
    private final TicketRepository ticketRepository;

    @Autowired
    public AirportDataLoader(AirportRepository airportRepository, TicketRepository ticketRepository) {
        this.airportRepository = airportRepository;
        this.ticketRepository = ticketRepository;
    }

    @Bean
    @Transactional
    public CommandLineRunner initializeDatabase() {
        return args -> {
            // Check if the table is empty before inserting data to avoid duplicates
            if (airportRepository.count() == 0) {
                airportRepository.save(new Airport("California", "CA", "USA", "Los Angeles International Airport", 1));
                airportRepository.save(new Airport("Texas", "TX", "USA", "Dallas/Fort Worth International Airport", 2));
                airportRepository.save(new Airport("Florida", "FL", "USA", "Miami International Airport",3));
                airportRepository.save(new Airport("New York", "NY", "USA", "John F. Kennedy International Airport", 4));
                airportRepository.save(new Airport("Georgia", "GA", "USA", "Hartsfield-Jackson Atlanta International Airport", 5));
                airportRepository.save(new Airport("Illinois", "IL", "USA", "O'Hare International Airport", 6));
                airportRepository.save(new Airport("Nevada", "NV", "USA", "McCarran International Airport", 7));
                airportRepository.save(new Airport("Washington", "WA", "USA", "Seattle-Tacoma International Airport", 8));
                airportRepository.save(new Airport("Colorado", "CO", "USA", "Denver International Airport", 9));
                airportRepository.save(new Airport("Arizona", "AZ", "USA", "Phoenix Sky Harbor International Airport", 10));
            }
            else {
                System.out.println("Database already populated.");
            }

            //Ticket Loader

            // Load Ticket data


            Airport airport1 = airportRepository.findByAirportId(1)
                    .orElseThrow(() -> new RuntimeException("Airport with ID 1 not found"));
            Airport airport2 = airportRepository.findByAirportId(2)
                    .orElseThrow(() -> new RuntimeException("Airport with ID 2 not found"));

            System.out.println("Loading Ticket data...");
            Ticket ticket1 = new Ticket();
            ticket1.setTicketId(1);
            ticket1.setFromState(airport1);
            ticket1.setToState(airport2);
            ticket1.setDuration(Time.valueOf("01:30:00"));
            ticket1.setSeatNumber(101);
            ticket1.setDeparture(LocalDateTime.now().plusDays(1));

            Ticket ticket2 = new Ticket();
            ticket2.setTicketId(2);
            ticket2.setFromState(airport1);
            ticket2.setToState(airport2);
            ticket2.setDuration(Time.valueOf("02:00:00"));
            ticket2.setSeatNumber(102);
            ticket2.setDeparture(LocalDateTime.now().plusDays(2));

            List<Ticket> tickets = List.of(ticket1, ticket2);
            ticketRepository.saveAll(tickets);


        };

    }
}
