package com.test.java_test.service.impl;

import com.test.java_test.dto.AirportDto;
import com.test.java_test.entity.Airport;
import com.test.java_test.mapper.AirportMapper;
import com.test.java_test.repository.AirportRepository;
import com.test.java_test.service.IAirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
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

    @Override
    public AirportDto getAirport(Integer airportId) {
        Airport airport = airportRepository.findByAirportId(airportId).orElseThrow(
                () -> new NoSuchElementException("Airport not found with id: " + airportId)
        );

        return AirportMapper.mapToAirportDto(airport, new AirportDto());
    }

    @Override
    public void addAirport(AirportDto airportDto) {
        Integer newId = Airport.idGenerator();

        // Create new Airport with generated ID
        Airport newAirport = new Airport(
                airportDto.getStateName(),
                airportDto.getStateShort(),
                airportDto.getCountry(),
                airportDto.getStationName(),
                newId
        );

        // Save the new Airport entity
        airportRepository.save(newAirport);
    }

//    private Airport newAirport(){
//        Airport newAirport = new Airport();
//        newAirport.setAirportId(Airport.idGenerator());
//
//        return newAirport;
//    }


}
