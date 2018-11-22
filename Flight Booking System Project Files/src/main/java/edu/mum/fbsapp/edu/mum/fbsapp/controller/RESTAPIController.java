package edu.mum.fbsapp.edu.mum.fbsapp.controller;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airline;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Airplane;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Airport;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Flight;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirlineService;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirplaneService;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirportService;
import edu.mum.fbsapp.edu.mum.fbsapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTAPIController {

    @Autowired
    private AirlineService airlineService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private FlightService flightService;

    @GetMapping(value = "/airplanesJson")
    public @ResponseBody
    List<Airplane> getAllAirplanes(){
        return airplaneService.findAll();
    }

    @GetMapping(value = "/airlinesJson")
    public @ResponseBody List<Airline> getAllAirlines(){
        return airlineService.findAll();
    }

    @GetMapping(value = "/airportsJson")
    public @ResponseBody List<Airport> getAllAirports(){
        return airportService.findAll();
    }

    @GetMapping(value = "/flightsJson")
    public @ResponseBody List<Flight> getAllFlights(){
        return flightService.findAll();
    }

}
