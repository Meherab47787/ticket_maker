//package com.test.java_test.config;
//
//import com.test.java_test.entity.Airport;
//import com.test.java_test.entity.Ticket;
//import com.test.java_test.repository.AirportRepository;
//import com.test.java_test.repository.TicketRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.sql.Time;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Component
//@Order(2)
//public class TicketDataLoader implements CommandLineRunner {
//    @Autowired
//    private TicketRepository ticketRepository;
//
//    @Autowired
//    private AirportRepository airportRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Fetch airports by ID using the built-in findById method
//        Airport airport1 = airportRepository.findByAirportId(1).orElseThrow(() -> new RuntimeException("Airport with ID 1 not found"));
//        Airport airport2 = airportRepository.findByAirportId(2).orElseThrow(() -> new RuntimeException("Airport with ID 2 not found"));
//
//        // Create ticket instances
//        Ticket ticket1 = new Ticket();
//        ticket1.setFromState(airport1);
//        ticket1.setToState(airport2);
//        ticket1.setDuration(Time.valueOf("01:30:00"));
//        ticket1.setSeatNumber(101);
//        ticket1.setDeparture(LocalDateTime.now().plusDays(1));
//
//        Ticket ticket2 = new Ticket();
//        ticket2.setFromState(airport1);
//        ticket2.setToState(airport2);
//        ticket2.setDuration(Time.valueOf("02:00:00"));
//        ticket2.setSeatNumber(102);
//        ticket2.setDeparture(LocalDateTime.now().plusDays(2));
//
//        // Add more tickets as needed
//        List<Ticket> tickets = List.of(ticket1, ticket2 /*, other tickets */);
//        ticketRepository.saveAll(tickets);
//    }
//}
