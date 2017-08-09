package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequest;

/*
 * 
 * Client Request Class is implemented with new interface and have similar method of setRequest.
   Which map BusyRequest to respective Supplier Request.

*
*/
public class CrazyAirRequest implements AirlineSupplierRequest{

    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private int passengerCount;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(final String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(final String returnDate) {
        this.returnDate = returnDate;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(final int passengerCount) {
        this.passengerCount = passengerCount;
    }
    @Override
	public void setRequest(BusyFlightsRequest busyFlightsRequest) {
		this.setOrigin(busyFlightsRequest.getOrigin());
		this.setDestination(busyFlightsRequest.getDestination());
		this.setDepartureDate(busyFlightsRequest.getDepartureDate());
		this.setReturnDate(busyFlightsRequest.getReturnDate());
		this.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
		
	}
}
