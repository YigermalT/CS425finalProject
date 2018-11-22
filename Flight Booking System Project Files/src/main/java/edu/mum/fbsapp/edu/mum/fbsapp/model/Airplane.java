package edu.mum.fbsapp.edu.mum.fbsapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String serialNumber;

    @NotEmpty
    private String model;

    @Range(min=0, max=853)
    private int capacity;

    @JsonIgnore
    @OneToMany(mappedBy = "airplane")
    @OrderBy("departureDate, departureTime")
    private List<Flight> flights;

    public Airplane(){

    }

    public Airplane(String serialNumber, String model, int capacity) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.capacity = capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public boolean addFlight(Flight flight){
        boolean success=false;

        if(flights.add(flight)){
            flight.setAirplane(this);
            success=true;
        }
        return success;
    }

    public boolean removeFlight(Flight flight){
        boolean success=false;

        if(flights.remove(flight)){
            flight.setAirplane(null);
            success=true;
        }
        return  success;
    }

    public String getSerialModel() {
        return serialNumber + " - " + model;
    }
}
