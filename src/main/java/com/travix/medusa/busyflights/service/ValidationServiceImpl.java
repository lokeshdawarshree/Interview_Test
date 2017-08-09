package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public class ValidationServiceImpl implements ValidationService{
	//Similarly Logger could use in other classes
		public static final Logger logger = LoggerFactory.getLogger(SearchFlightServiceImpl.class);
		
		@Override
		public List<String> validateBusyRequest(BusyFlightsRequest busyFlightsRequest) {
			List<String> errorList=new ArrayList<String>();
			
			
			if(busyFlightsRequest.getNumberOfPassengers()>4 || busyFlightsRequest.getNumberOfPassengers()<1)
				errorList.add("Invalid Pax No,It should minimum 1 and maximum 4.");
			// here we can use properties file to show error message
			
			// Similarly other validation will be added here
			
			return errorList;
		}


}
