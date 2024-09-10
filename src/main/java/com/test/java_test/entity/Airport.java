package com.test.java_test.entity;

import java.util.Random;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter @Setter
public class Airport {
    @Id
    @Column(name = "airport_id")
    private Integer airportId;

    @Column(name = "state_name")
    private String stateName;

    @Column(name = "state_short", length = 3)
    private String stateShort;

    @Column(name = "country", nullable = false)
    @NotNull
    private String country;

    @Column(name = "station_name", nullable = false)
    @NotNull
    private String stationName;

    //CONSTRUCTORS

    public Airport(String stateName, String stateShort, @NotNull String country, @NotNull String stationName) {
        this.airportId = idGenerator();
        this.stateName = stateName;
        this.stateShort = stateShort;
        this.country = country;
        this.stationName = stationName;
    }

    public Airport(String stateName, String stateShort, @NotNull String country, @NotNull String stationName, Integer airportId) {
        this.stateName = stateName;
        this.stateShort = stateShort;
        this.country = country;
        this.stationName = stationName;
        this.airportId = airportId;
    }

    public Airport(){

    }

    //CONSTRUCTORS END

    //GETTER
    public Integer getAirportId() {
        return airportId;
    }

    public String getStateName() {
        return stateName;
    }

    public String getStateShort() {
        return stateShort;
    }

    public @NotNull String getCountry() {
        return country;
    }

    public @NotNull String getStationName() {
        return stationName;
    }
    //GETTER END

    //SETTER

    public void setAirportId(Integer airportId) {
        this.airportId = airportId;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateShort(String stateShort) {
        this.stateShort = stateShort;
    }

    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    public void setStationName(@NotNull String stationName) {
        this.stationName = stationName;
    }

    //END SETTER

    //FUNCTIONS


    private static final Random random = new Random();

    public static Integer idGenerator(){
        int min = 10000000;
        int max = 99999999;
        return random.nextInt((max - min) + 1) + min;
    }
}
