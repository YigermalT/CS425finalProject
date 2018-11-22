package edu.mum.fbsapp.edu.mum.fbsapp.repository;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Long> {

}
