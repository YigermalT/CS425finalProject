package edu.mum.fbsapp.edu.mum.fbsapp.service;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Flight;

public interface FlightService extends BaseService<Flight> {

    Flight validateFlight(String flightId);
}
