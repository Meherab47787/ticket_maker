package com.test.java_test.dto;


public class AirportDto {
    private String stateName;
    private String stateShort;
    private String country;
    private String stationName;


    //GETTER

    public String getStationName() {
        return stationName;
    }

    public String getCountry() {
        return country;
    }

    public String getStateShort() {
        return stateShort;
    }

    public String getStateName() {
        return stateName;
    }

    //GETTER END

    //SETTER

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setStateShort(String stateShort) {
        this.stateShort = stateShort;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    //SETTER END

}
