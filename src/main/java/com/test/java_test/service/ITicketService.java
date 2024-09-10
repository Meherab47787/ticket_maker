package com.test.java_test.service;

import com.test.java_test.dto.AirportDto;
import com.test.java_test.dto.TicketDto;

import java.util.List;

public interface ITicketService {
    List<TicketDto> getAllTickets();
}
