package edu.mum.fbsapp.edu.mum.fbsapp.serviceImpl;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airport;
import edu.mum.fbsapp.edu.mum.fbsapp.repository.AirportRepository;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AirportServiceImpl implements AirportService {

    @Autowired
    AirportRepository airportRepository;

    @Override
    public List<Airport> findAll() {
        return (List<Airport> )airportRepository.findAll();
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public Airport findOne(Long id) {
        Optional<Airport> airport=airportRepository.findById(id);
        return airport.orElse(null);
    }

    @Override
    public void delete(Long id) {
    airportRepository.deleteById(id);
    }
}
