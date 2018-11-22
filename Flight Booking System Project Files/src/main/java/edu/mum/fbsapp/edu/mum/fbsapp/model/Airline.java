package edu.mum.fbsapp.edu.mum.fbsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String airlineName;

    @JsonIgnore
    @OneToMany(mappedBy = "airline")
    @OrderBy("departureDate, departureTime")
    private List<Flight> flights;

    public Airline(){

    }
    public Airline(String airlineName){
        this.airlineName=airlineName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public boolean addFlight(Flight flight){

        boolean success=false;
        if( flights.add(flight)){
            flight.setAirline(this);
            success=true;
        }
        return success;
    }

    public boolean removeFlight(Flight flight){
        boolean success=false;

        if(flights.remove(flight)){
            flight.setAirline(null);
            success=true;
        }

        return success;
    }




}
