package com.flightco.flightlineclient.payload;

import java.util.List;

public class FlightResponse {

    private String flight;
    private List<PassengerResponse> passengers;
    
    //should make mapping class
    public static FlightResponse MapFlightData(List<PassengerResponse> passengers, String flightCode){

        FlightResponse flightResponse = new FlightResponse();
        flightResponse.setFlight(flightCode);
        flightResponse.setPassengers(passengers);
        return  flightResponse;
    }
    public String getFlight() {
        return flight;
    }

    public void setFlight(String flight) {
        this.flight = flight;
    }

    public List<PassengerResponse> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerResponse> passengers) {
        this.passengers = passengers;
    }

    
} 



/*Response: { flight: “VL1234”, passengers: [ { “name”: “NOMBRE 1”, “lastname”: “APELLIDOS 1”,
    
    seat: “A1” }, { “name”: “NOMBRE 2”, “lastname”: “APELLIDOS 2”, seat: “A2” } ] }*/