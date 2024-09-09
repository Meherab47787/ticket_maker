package com.test.java_test.service.impl;

import com.test.java_test.dto.AirportDto;
import com.test.java_test.entity.Airport;
import com.test.java_test.mapper.AirportMapper;
import com.test.java_test.repository.AirportRepository;
import com.test.java_test.service.IAirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirportServiceImplementation implements IAirportService {

    private AirportRepository airportRepository;

    public AirportServiceImplementation(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public List<AirportDto> getAllAirports() {
        List<Airport> airports = airportRepository.findAll();

        // Map each Airport entity to AirportDto using AirportMapper
        return airports.stream()
                .map(airport -> AirportMapper.mapToAirportDto(airport, new AirportDto()))
                .collect(Collectors.toList());
    }
}
