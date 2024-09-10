package com.test.java_test.mapper;

import com.test.java_test.dto.AirportDto;
import com.test.java_test.dto.TicketDto;
import com.test.java_test.entity.Airport;
import com.test.java_test.entity.Ticket;

public class TicketMapper {

    public static TicketDto mapToTicketDto(Ticket ticket, TicketDto ticketDto) {
        // Use AirportMapper to map Airport to AirportDto
        AirportDto fromStateDto = new AirportDto();
        AirportDto toStateDto = new AirportDto();

        if (ticket.getFromState() != null) {
            AirportMapper.mapToAirportDto(ticket.getFromState(), fromStateDto);
        }
        if (ticket.getToState() != null) {
            AirportMapper.mapToAirportDto(ticket.getToState(), toStateDto);
        }

        ticketDto.setFromState(fromStateDto);
        ticketDto.setToState(toStateDto);
        ticketDto.setDuration(ticket.getDuration());
        ticketDto.setSeatNumber(ticket.getSeatNumber());
        ticketDto.setDeparture(ticket.getDeparture());

        return ticketDto;
    }

    // Maps a TicketDto to a Ticket entity
    public static Ticket mapToTicket(Ticket ticket, TicketDto ticketDto) {
        // Use AirportMapper to map AirportDto to Airport
        Airport fromState = new Airport();
        Airport toState = new Airport();

        if (ticketDto.getFromState() != null) {
            AirportMapper.mapToAirport(fromState, ticketDto.getFromState());
        }
        if (ticketDto.getToState() != null) {
            AirportMapper.mapToAirport(toState, ticketDto.getToState());
        }

        ticket.setFromState(fromState);
        ticket.setToState(toState);
        ticket.setDuration(ticketDto.getDuration());
        ticket.setSeatNumber(ticketDto.getSeatNumber());
        ticket.setDeparture(ticketDto.getDeparture());

        return ticket;
    }

}
