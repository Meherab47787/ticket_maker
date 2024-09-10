package com.test.java_test.controller;

import com.test.java_test.dto.AirportDto;
import com.test.java_test.dto.ResponseDto;
import com.test.java_test.service.IAirportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("/{id}")
    public ResponseEntity<AirportDto> getAirport(@PathVariable("id") Integer airportId) {
        try {
            AirportDto airportDto = iAirportService.getAirport(airportId);
            return new ResponseEntity<>(airportDto, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseDto> addnewAirport(@RequestBody AirportDto airportDto){
        iAirportService.addAirport(airportDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "airport Created"));
    }

}
