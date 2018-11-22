package edu.mum.fbsapp.edu.mum.fbsapp.repository;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends CrudRepository<Airline,Long> {

}
