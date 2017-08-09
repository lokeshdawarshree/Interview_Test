package com.travix.medusa.busyflights.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.travix.medusa.busyflights.httpclient.AirlineSupplierClientAbstract;
import com.travix.medusa.busyflights.httpclient.CrazyAirClient;
import com.travix.medusa.busyflights.httpclient.ToughJetClient;


@Configuration
public class SupplierWebServiceClients {
	
	/* Supplier web service URI picked from properties file*/
	
	@Value("${CrazyAir.PATH}")
	private String crazyAirPath;
	 
    @Value("${CrazyAir.URI}")
    private String crazyAirURI;
    
    @Value("${CrazyAir.PATH}")
	private String toughJetPath;
	 
    @Value("${CrazyAir.URI}")
    private String toughJetURI;
	 
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(crazyAirPath);
        return marshaller;
    }
	@Bean
	public WebServiceTemplate crazyAirClient(Jaxb2Marshaller marshaller) {
		marshaller.setContextPath(crazyAirPath);
	    
		AirlineSupplierClientAbstract client =  new CrazyAirClient();
		
		 client.setMarshaller(marshaller);
		 client.setUnmarshaller(marshaller);
		 client.setDefaultUri(crazyAirURI);
	    
	    return client;
	}

	@Bean
	public WebServiceTemplate toughJetClient(Jaxb2Marshaller marshaller) {
		marshaller.setContextPath(toughJetPath);
	    
		AirlineSupplierClientAbstract client = new ToughJetClient();
		
		client.setDefaultUri(toughJetURI);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		
	    return client;
	}

	
	
}
