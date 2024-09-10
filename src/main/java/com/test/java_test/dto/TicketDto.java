package com.test.java_test.dto;

import java.sql.Time;
import java.time.LocalDateTime;

public class TicketDto {
    private AirportDto fromState;
    private AirportDto toState;
    private Time duration;
    private Integer seatNumber;
    private LocalDateTime departure;

    // GETTER



    public AirportDto getFromState() {
        return fromState;
    }

    public AirportDto getToState() {
        return toState;
    }

    public Time getDuration() {
        return duration;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    // GETTER END

    // SETTER

    public void setFromState(AirportDto fromState) {
        this.fromState = fromState;
    }

    public void setToState(AirportDto toState) {
        this.toState = toState;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    // SETTER END

    // Constructor

    public TicketDto(AirportDto fromState, AirportDto toState, Time duration, Integer seatNumber, LocalDateTime departure) {

        this.fromState = fromState;
        this.toState = toState;
        this.duration = duration;
        this.seatNumber = seatNumber;
        this.departure = departure;
    }

    public TicketDto() {
    }
}
