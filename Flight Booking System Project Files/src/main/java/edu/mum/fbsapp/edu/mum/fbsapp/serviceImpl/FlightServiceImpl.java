package edu.mum.fbsapp.edu.mum.fbsapp.serviceImpl;

import edu.mum.fbsapp.edu.mum.fbsapp.exception.InvalidFlightException;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Flight;
import edu.mum.fbsapp.edu.mum.fbsapp.repository.FlightRepository;
import edu.mum.fbsapp.edu.mum.fbsapp.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepository flightRepository;


    @Override
    public List<Flight> findAll() {
        return (List<Flight>) flightRepository.findAll();
    }

    @Override
    public Flight save(Flight flight) {
        Flight firstFlight=flightRepository.save(flight);
        return firstFlight;
    }

    @Override
    public Flight findOne(Long id) {
        Optional<Flight> flight=flightRepository.findById(id);
        return flight.orElse(null);
    }

    @Override
    public void delete(Long id) {
    flightRepository.deleteById(id);
    }

    @Override
    public Flight validateFlight(String flightId) {

        if(flightId==null || flightId.isEmpty()){
            throw new InvalidFlightException("Invalid Flight Number" + flightId);
        }

        long flightID= Long.parseLong(flightId);

        Flight flight=this.findOne(flightID);

        if(flight==null){
            throw new InvalidFlightException("Invalid Flight Number"+flightId);
        }

        return flight;
    }
}
