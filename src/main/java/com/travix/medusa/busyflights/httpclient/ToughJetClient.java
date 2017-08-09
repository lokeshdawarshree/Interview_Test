package com.travix.medusa.busyflights.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetResponse;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequest;
@Component
public class ToughJetClient extends AirlineSupplierClientAbstract{

	 @SuppressWarnings("unchecked")
	public List<BusyFlightsResponse> getFlights(AirlineSupplierRequest request) {

		 List<BusyFlightsResponse> finalResponse=new ArrayList<BusyFlightsResponse>();

			//calling of the web service method may change depends on client method
		    
			 	List<ToughJetResponse>  responseList=(List<ToughJetResponse>)this.marshalSendAndReceive((ToughJetRequest)request);
			 	for(ToughJetResponse toughRes:responseList)
			 	{
			 		finalResponse.add(toughRes.getResponse());// converting client response to busy flight response
			 	}
			 	
			 	responseList.forEach(toughRes->finalResponse.add(toughRes.getResponse()));
		         
		         return finalResponse;
		    }

	
	    
}
