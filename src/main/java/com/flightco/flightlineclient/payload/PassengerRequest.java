package com.flightco.flightlineclient.payload;

import javax.validation.constraints.NotBlank;

public class PassengerRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String lastname;

    @NotBlank
    private String seat;
    private String flightCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
		this.seat = seat;
	}

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }
    
}
    


