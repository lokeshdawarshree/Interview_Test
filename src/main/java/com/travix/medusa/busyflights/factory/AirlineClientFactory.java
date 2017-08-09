package com.travix.medusa.busyflights.factory;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.httpclient.AirlineSupplierClientAbstract;
import com.travix.medusa.busyflights.httpclient.CrazyAirClient;
import com.travix.medusa.busyflights.httpclient.ToughJetClient;
@Component
public class AirlineClientFactory {
	 public AirlineSupplierClientAbstract getClient(String airlineType){
		 if(airlineType == null){
	         return null;
	      }	
	      
	      if("CrazyAir".equalsIgnoreCase(airlineType)){
	         return new CrazyAirClient();	         
	      }
	      
	      else if("ToughJet".equalsIgnoreCase(airlineType)){
	         return new ToughJetClient();	         
	      }
	      
	      return null;
	   }
}
