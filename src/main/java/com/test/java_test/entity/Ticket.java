package com.test.java_test.entity;

import jakarta.persistence.*;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
public class Ticket {
    @Id
    private Integer ticketId;

    @ManyToOne
    @JoinColumn(name = "from_airport_id", nullable = false)
    private Airport fromState;

    @ManyToOne
    @JoinColumn(name = "to_airport_id", nullable = false)
    private Airport toState;

    @Column(name = "duration")
    private Time duration;

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "departure")
    private LocalDateTime departure;


    //GETTER
    public Integer getTicketId() {
        return ticketId;
    }

    public Airport getFromState() {
        return fromState;
    }

    public Airport getToState() {
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
    //GETTER END


    //SETTER
    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public void setFromState(Airport fromState) {
        this.fromState = fromState;
    }

    public void setToState(Airport toState) {
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
    //SETTER END


    public Ticket(Integer ticketId, Airport fromState, Airport toState, Time duration, Integer seatNumber, LocalDateTime departure) {
        this.ticketId = ticketId;
        this.fromState = fromState;
        this.toState = toState;
        this.duration = duration;
        this.seatNumber = seatNumber;
        this.departure = departure;
    }

    public  Ticket(){

    }
}
