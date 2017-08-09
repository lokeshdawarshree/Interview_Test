package com.travix.medusa.busyflights.domain.toughjet;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.factory.AirlineSupplierResponse;

/*
 * 
 * Client Response Class is implemented with new interface and have similar method of getResponse.
Which map respective Supplier Response to BusyFlightResponse

*
*/
public class ToughJetResponse implements AirlineSupplierResponse{

    private String carrier;
    private double basePrice;
    private double tax;
    private double discount;
    private String departureAirportName;
    private String arrivalAirportName;
    private String outboundDateTime;
    private String inboundDateTime;

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(final String carrier) {
        this.carrier = carrier;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(final double basePrice) {
        this.basePrice = basePrice;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(final double tax) {
        this.tax = tax;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(final double discount) {
        this.discount = discount;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public void setDepartureAirportName(final String departureAirportName) {
        this.departureAirportName = departureAirportName;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public void setArrivalAirportName(final String arrivalAirportName) {
        this.arrivalAirportName = arrivalAirportName;
    }

    public String getOutboundDateTime() {
        return outboundDateTime;
    }

    public void setOutboundDateTime(final String outboundDateTime) {
        this.outboundDateTime = outboundDateTime;
    }

    public String getInboundDateTime() {
        return inboundDateTime;
    }

    public void setInboundDateTime(final String inboundDateTime) {
        this.inboundDateTime = inboundDateTime;
    }

    // new method in class to map both response 
    @Override
	public BusyFlightsResponse getResponse() {
		BusyFlightsResponse busyFlightsResponse = new BusyFlightsResponse();
		busyFlightsResponse.setAirline(this.getCarrier());
		busyFlightsResponse.setSupplier("Tough Jet");
		busyFlightsResponse.setFare((this.getBasePrice() +this.getTax()) - (this.getDiscount()/100)* (this.getBasePrice()));
		busyFlightsResponse.setDepartureAirportCode(this.getDepartureAirportName());
		busyFlightsResponse.setDestinationAirportCode(this.getArrivalAirportName());
		busyFlightsResponse.setDepartureDate(this.getOutboundDateTime());
		busyFlightsResponse.setArrivalDate(this.getInboundDateTime());
		return null;
	}
}
