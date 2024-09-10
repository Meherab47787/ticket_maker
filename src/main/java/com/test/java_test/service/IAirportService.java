package com.test.java_test.service;

import com.test.java_test.dto.AirportDto;

import java.util.List;

public interface IAirportService {
    List<AirportDto> getAllAirports();
    AirportDto getAirport(Integer airportId);
    void addAirport(AirportDto airportDto);
}
