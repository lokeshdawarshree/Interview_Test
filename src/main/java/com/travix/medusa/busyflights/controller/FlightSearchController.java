package com.travix.medusa.busyflights.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.service.SearchFlightService;
import com.travix.medusa.busyflights.service.ValidationService;

@RestController
@RequestMapping("/busyFlightApi")
public class FlightSearchController {
	@Autowired
	ValidationService validationService;
	@Autowired
	SearchFlightService searchFlightService;
	
	@RequestMapping(value = "/search/{origin}/{destination}/{departureDate}/{returnDate}/{numberOfPassengers}", method = RequestMethod.GET)
	public ResponseEntity<?> searchFlights(BusyFlightsRequest busyFlightsRequest,Model model) {
		
		// validation of the request 
		List<?> errorList=validationService.validateBusyRequest(busyFlightsRequest);
		
		if(errorList.size()>0)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		else
			return new ResponseEntity<>(searchFlightService.searchFlights(busyFlightsRequest), HttpStatus.OK);		
		// API fail conditions are not taking care here     
		
	
	}
}