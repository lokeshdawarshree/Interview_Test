package com.travix.medusa.busyflights.factory;

import org.springframework.stereotype.Component;

import com.travix.medusa.busyflights.domain.crazyair.CrazyAirRequest;
import com.travix.medusa.busyflights.domain.toughjet.ToughJetRequest;
@Component
public class AirlineSupplierRequestFactory {
	
	 public AirlineSupplierRequest getAirlineRequest(String airlineType){
	      if(airlineType == null){
	         return null;
	      }	
	      
	      if("CrazyAir".equalsIgnoreCase(airlineType)){
	         return new CrazyAirRequest();	         
	      }
	      
	      else if("ToughJet".equalsIgnoreCase(airlineType)){
	         return new ToughJetRequest();	         
	      }
	      
	      return null;
	   }

}
