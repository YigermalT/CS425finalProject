package edu.mum.fbsapp.edu.mum.fbsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String airportCode;


    @NotEmpty
    private String city;

    @NotEmpty
    private String country;
    @NotEmpty
    private String airportName;

    @JsonIgnore
    @OneToMany(mappedBy = "destination")
    @OrderBy("arrivalDate, arrivalTime")
    List<Flight> arrivals;

    @JsonIgnore
    @OneToMany(mappedBy = "origin")
    @OrderBy("departureDate, departureTime")
    List<Flight> departures;

    public Airport(){

    }

    public Airport(String airportCode, String airportName, String city, String country) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.city = city;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Flight> getArrivals() {
        return arrivals;
    }

    public void setArrivals(List<Flight> arrivals) {
        this.arrivals = arrivals;
    }

    public List<Flight> getDepartures() {
        return departures;
    }

    public void setDepartures(List<Flight> departure) {
        this.departures = departures;
    }


    public boolean addArrival(Flight flight){

        boolean success=false;
        if(arrivals.add(flight)){
            flight.setDestination(this);
            success=true;
        }
        return success;
    }

    public boolean removeArrivals(Flight flight){
        boolean success=false;
        if(arrivals.remove(flight)){
            flight.setDestination(null);
            success=true;
        }
        return  success;
    }

    public boolean addDeparture(Flight flight){
        boolean success=false;

        if(departures.add(flight)){
            flight.setOrigin(this);
            success=true;
        }
        return success;
    }

    public boolean removeDeparture(Flight flight){
        boolean success=false;
        if(departures.remove(flight)){
            flight.setOrigin(null);
            success=true;
        }
        return success;
    }

    public String getAirportDetail() {
        return airportCode + " - " + airportName + " - " + city;
    }

}
