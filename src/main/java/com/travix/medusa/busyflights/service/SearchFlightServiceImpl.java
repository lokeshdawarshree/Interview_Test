package com.travix.medusa.busyflights.service;

import java.util.List;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsResponse;
import com.travix.medusa.busyflights.factory.AirlineClientFactory;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequest;
import com.travix.medusa.busyflights.factory.AirlineSupplierRequestFactory;
import com.travix.medusa.busyflights.httpclient.AirlineSupplierClientAbstract;

@Service
public   class SearchFlightServiceImpl implements SearchFlightService{
	
	@Autowired 
	AirlineSupplierRequestFactory suppReqFactory;
	@Autowired 
	AirlineClientFactory airlineClientFactory;
	
	
	List<BusyFlightsResponse> responseList=null;
	 
	//get the supplier key value in List from the application.properties file
	 @Value("#{'$AirLine.Supplier}'.split(',')}") 
	 private List<String> supplist;
	
	//Similarly Logger could use in other classes
	public static final Logger logger = LoggerFactory.getLogger(SearchFlightServiceImpl.class);
	
	@Override
	public String searchFlights(BusyFlightsRequest busyFlightsRequest) {
		

		try{
			// get the busyflight response from all suppliers ,no need to change this code if new supplier is added properties file
			for(String supplierKey:supplist)
			{
				AirlineSupplierRequest airReq=suppReqFactory.getAirlineRequest(supplierKey);
				airReq.setRequest(busyFlightsRequest);
				
				AirlineSupplierClientAbstract client=airlineClientFactory.getClient(supplierKey);
				
				// First supplier flight response  
				if(responseList==null)
					responseList=client.getFlights(airReq);
				else
					//other supplier flight response  
					responseList.addAll(client.getFlights(airReq));
				//here failing of API Call is not considered,API delay response is not consider,
				//concurrency control is not taking care
				//there are number of validation and authentication required at time of calling API 
				///implementation of these are not possible here
				
				
			}
			
			
			if(responseList.size()==0)
			{
				logger.warn("warning occur : No Flight Found" );
				return " No Flight Found ";
			}
			else
			{
				//Sort the List using Lambda expression
				responseList.sort((airline1, airline2) -> new Double(airline1.getFare()).compareTo( new Double(airline2.getFare())));
				logger.info("Fetched Total Flights  ::", responseList.size());
			}
			//Sorted List send in response as in jsonArray
			JSONArray responseJson=new JSONArray(responseList);
			
			
			return responseJson.toString();
		}
		catch(Exception e)
		{
			logger.error("Error occur : " + e.getMessage());
		}
		
		return null;
	}

}
