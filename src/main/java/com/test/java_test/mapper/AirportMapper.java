package com.test.java_test.mapper;


import com.test.java_test.dto.AirportDto;
import com.test.java_test.entity.Airport;

public class AirportMapper {

    // Maps an Airport entity to an AirportDto
    public static AirportDto mapToAirportDto(Airport airport, AirportDto airportDto) {
        airportDto.setStateName(airport.getStateName());
        airportDto.setStateShort(airport.getStateShort());
        airportDto.setCountry(airport.getCountry());
        airportDto.setStationName(airport.getStationName());
        return airportDto;
    }

    // Maps an AirportDto to an Airport entity
    public static Airport mapToAirport(Airport airport, AirportDto airportDto) {
        airport.setStateName(airportDto.getStateName());
        airport.setStateShort(airportDto.getStateShort());
        airport.setCountry(airportDto.getCountry());
        airport.setStationName(airportDto.getStationName());
        return airport;
    }
}
