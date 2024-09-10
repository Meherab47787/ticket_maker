package com.test.java_test.service.impl;

import com.test.java_test.dto.TicketDto;
import com.test.java_test.entity.Ticket;
import com.test.java_test.mapper.TicketMapper;
import com.test.java_test.repository.TicketRepository;
import com.test.java_test.service.ITicketService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements ITicketService {

    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .map(ticket -> TicketMapper.mapToTicketDto(ticket, new TicketDto()))
                .collect(Collectors.toList());
    }
}
