package com.travix.medusa.busyflights.service;

import java.util.List;

import com.travix.medusa.busyflights.domain.busyflights.BusyFlightsRequest;

public interface ValidationService {
	public List<String> validateBusyRequest(BusyFlightsRequest busyFlightsRequest);
}
