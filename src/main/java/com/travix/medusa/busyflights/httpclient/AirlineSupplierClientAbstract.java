package com.travix.medusa.busyflights.httpclient;

import java.util.List;

import org.springframework.ws.client.core.WebServiceTemplate;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequest;

public abstract class AirlineSupplierClientAbstract extends WebServiceTemplate{
	public abstract List<BusyFlightsResponse> getFlights(AirlineSupplierRequest airRequest) ;

}
