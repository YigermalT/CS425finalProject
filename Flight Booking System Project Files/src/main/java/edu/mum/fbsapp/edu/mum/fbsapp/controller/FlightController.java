package edu.mum.fbsapp.edu.mum.fbsapp.controller;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airline;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Airplane;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Airport;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Flight;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirlineService;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirplaneService;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirportService;
import edu.mum.fbsapp.edu.mum.fbsapp.service.FlightService;
import edu.mum.fbsapp.edu.mum.fbsapp.validator.FlightScheduleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    AirlineService airlineService;

    @Autowired
    AirplaneService airplaneService;

    @Autowired
    AirportService airportService;

    @Autowired
    FlightScheduleValidator flightScheduleValidator;

    @ModelAttribute("airlines")
    public List<Airline> getAirlines() {
        return airlineService.findAll();
    }

    @ModelAttribute("airports")
    public List<Airport> getAirports() {
        return airportService.findAll();
    }

    @ModelAttribute("airplanes")
    public List<Airplane> getAirplanes() {
        return airplaneService.findAll();
    }

    @GetMapping(value = {"/admin"})
    public String getFlights(Model model) {
        model.addAttribute("flights", flightService.findAll());
        return "home/index";
    }

    @GetMapping(value = "/flight/new")
    public String newFlightForm(@ModelAttribute("flight") Flight flight, Model model) {
        return "flight/new";
    }

    @RequestMapping(value = "/flight/new", method = RequestMethod.POST)
    public String scheduleNewFlight(@Valid @ModelAttribute("flight") Flight flight,
                                    BindingResult bindingResult, Model model) {
        flightScheduleValidator.validate(flight, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "/flight/new";
        }
        flight= flightService.save(flight);
        return "redirect:/admin";
    }



    @GetMapping(value = "/flight/{id}")
    public String getFlightDetail(@PathVariable("id") Long id, Model model) {
        Flight flight = flightService.findOne(id);
        if (flight != null) {
            model.addAttribute("flight", flight);
            return "flight/edit";
        }
        return "/admin";
    }

    /*@GetMapping(value = "/flight/edit/{id}")
    public String get(@PathVariable("id") long id, Model model) {
        model.addAttribute("flight", flightService.findOne(id));
        return "flight/edit";
    }*/

    @PostMapping(value = "/flight")
    public String updateFlightSchedule(@Valid @ModelAttribute("flight") Flight flight, BindingResult bindingResult, Model model) {
        flightScheduleValidator.validate(flight, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "flight/edit";
        }

        flight = flightService.save(flight);
        return "redirect:/admin";

    }


    // Reminder add Search here
}
