package com.travix.medusa.busyflights.domain.crazyair;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.factory.AirlineSupplierResponse;

/*
 * 
 * Client Response Class is implemented with new interface and have similar method of getResponse.
Which map respective Supplier Response to BusyFlightResponse

*
*/
public class CrazyAirResponse implements AirlineSupplierResponse{

    private String airline;
    private double price;
    private String cabinclass;
    private String departureAirportCode;
    private String destinationAirportCode;
    private String departureDate;
    private String arrivalDate;

    public String getAirline() {
        return airline;
    }

    public void setAirline(final String airline) {
        this.airline = airline;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getCabinclass() {
        return cabinclass;
    }

    public void setCabinclass(final String cabinclass) {
        this.cabinclass = cabinclass;
    }

    public String getDepartureAirportCode() {
        return departureAirportCode;
    }

    public void setDepartureAirportCode(final String departureAirportCode) {
        this.departureAirportCode = departureAirportCode;
    }

    public String getDestinationAirportCode() {
        return destinationAirportCode;
    }

    public void setDestinationAirportCode(final String destinationAirportCode) {
        this.destinationAirportCode = destinationAirportCode;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(final String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(final String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
   
    // new method in class to map both response 
    @Override
	public BusyFlightsResponse getResponse() {
		BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		busyFlightsResponse.setAirline(this.getAirline());
		busyFlightsResponse.setSupplier("Crazy Air");
		busyFlightsResponse.setFare(this.getPrice());
		busyFlightsResponse.setDepartureAirportCode(this.getDepartureAirportCode());
		busyFlightsResponse.setDestinationAirportCode(this.getDestinationAirportCode());
		busyFlightsResponse.setDepartureDate(this.getDepartureDate());
		busyFlightsResponse.setArrivalDate(this.getArrivalDate());
		return null;
	}
}
