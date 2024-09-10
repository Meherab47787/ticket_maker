package com.test.java_test.controller;


import com.test.java_test.dto.TicketDto;
import com.test.java_test.service.ITicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/api/tickets", produces = {MediaType.APPLICATION_JSON_VALUE})
public class TicketController {
    private ITicketService iTicketService;

    public TicketController(ITicketService iTicketService){
        this.iTicketService = iTicketService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<TicketDto>> getAllTickets(){
        List<TicketDto> allticketList = iTicketService.getAllTickets();

        return ResponseEntity.status(HttpStatus.OK).body(allticketList);
    }
}
