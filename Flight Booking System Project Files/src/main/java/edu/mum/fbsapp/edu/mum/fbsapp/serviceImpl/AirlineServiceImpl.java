package edu.mum.fbsapp.edu.mum.fbsapp.serviceImpl;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airline;
import edu.mum.fbsapp.edu.mum.fbsapp.repository.AirlineRepository;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class AirlineServiceImpl implements AirlineService {

    @Autowired
    AirlineRepository airlineRepository;

    @Override
    public List<Airline> findAll() {
        return (List<Airline>) airlineRepository.findAll();
    }

    @Override
    public Airline save(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public Airline findOne(Long id) {
        Optional<Airline> airline=airlineRepository.findById(id);;
        return airline.orElse(null);
    }

    @Override
    public void delete(Long id) {
     airlineRepository.deleteById(id);
    }
}
