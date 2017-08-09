package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequest;

/*
 * 
 * Client Request Class is implemented with new interface and have similar method of setRequest.
   Which map BusyRequest to respective Supplier Request.

*
*/
public class ToughJetRequest implements AirlineSupplierRequest{

    private String from;
    private String to;
    private String outboundDate;
    private String inboundDate;
    private int numberOfAdults;

    public String getFrom() {
        return from;
    }

    public void setFrom(final String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(final String to) {
        this.to = to;
    }

    public String getOutboundDate() {
        return outboundDate;
    }

    public void setOutboundDate(final String outboundDate) {
        this.outboundDate = outboundDate;
    }

    public String getInboundDate() {
        return inboundDate;
    }

    public void setInboundDate(final String inboundDate) {
        this.inboundDate = inboundDate;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(final int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }
    @Override
	public void setRequest(BusyFlightsRequest busyFlightsRequest) {
		this.setFrom(busyFlightsRequest.getOrigin());
		this.setTo(busyFlightsRequest.getDestination());
		this.setOutboundDate(busyFlightsRequest.getDepartureDate());
		this.setInboundDate(busyFlightsRequest.getReturnDate());
		this.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
		
	}
}
