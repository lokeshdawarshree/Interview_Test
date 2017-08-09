package com.travix.medusa.busyflights.httpclient;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.crazyair.CrazyAirResponse;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequest;

@Component
public class CrazyAirClient extends AirlineSupplierClientAbstract{

	
	@SuppressWarnings("unchecked")
	public List<BusyFlightsResponse> getFlights(AirlineSupplierRequest request) {
		
		List<BusyFlightsResponse> finalResponse=new ArrayList<BusyFlightsResponse>();

		//calling of the web service method may change depends on client method
		 	List<CrazyAirResponse>  responseList=(List<CrazyAirResponse>)this.marshalSendAndReceive((CrazyAirRequest)request);
		 	for(CrazyAirResponse crazyRes:responseList)
		 	{
		 		finalResponse.add(crazyRes.getResponse());// converting client response to busy flight response
		 	}
	         
	         return finalResponse;
	    }

}
