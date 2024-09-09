package com.test.java_test.config;

import com.test.java_test.entity.Airport;
import com.test.java_test.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AirportDataLoader {

    private AirportRepository airportRepository;
    @Autowired
    public AirportDataLoader(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Bean
    public CommandLineRunner initializeDatabase() {
        return args -> {
            // Check if the table is empty before inserting data to avoid duplicates
            if (airportRepository.count() == 0) {
                airportRepository.save(new Airport("California", "CA", "USA", "Los Angeles International Airport"));
                airportRepository.save(new Airport("Texas", "TX", "USA", "Dallas/Fort Worth International Airport"));
                airportRepository.save(new Airport("Florida", "FL", "USA", "Miami International Airport"));
                airportRepository.save(new Airport("New York", "NY", "USA", "John F. Kennedy International Airport"));
                airportRepository.save(new Airport("Georgia", "GA", "USA", "Hartsfield-Jackson Atlanta International Airport"));
                airportRepository.save(new Airport("Illinois", "IL", "USA", "O'Hare International Airport"));
                airportRepository.save(new Airport("Nevada", "NV", "USA", "McCarran International Airport"));
                airportRepository.save(new Airport("Washington", "WA", "USA", "Seattle-Tacoma International Airport"));
                airportRepository.save(new Airport("Colorado", "CO", "USA", "Denver International Airport"));
                airportRepository.save(new Airport("Arizona", "AZ", "USA", "Phoenix Sky Harbor International Airport"));
            }
            else {
                System.out.println("Database already populated.");
            }
        };
    }
}
