package com.test.java_test.controller;

import com.test.java_test.dto.AirportDto;
import com.test.java_test.service.IAirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path="/api/airports", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AirportController {
    private IAirportService iAirportService;

    public AirportController(IAirportService iAirportService) {
        this.iAirportService = iAirportService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AirportDto>> getallAirports(){
        List<AirportDto> airportDtoList = iAirportService.getAllAirports();

        // Return the list with an HTTP 200 status
        return ResponseEntity.status(HttpStatus.OK).body(airportDtoList);
    }

}
