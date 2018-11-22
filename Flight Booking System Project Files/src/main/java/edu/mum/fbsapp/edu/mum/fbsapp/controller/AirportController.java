package edu.mum.fbsapp.edu.mum.fbsapp.controller;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airport;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/airport")
public class AirportController {

    @Autowired
    AirportService airportService;

    @GetMapping(value = {"", "/", "/index"})
    public String getAirpots(Model model) {
        model.addAttribute("airports", airportService.findAll());
        return "airport/index";
    }

    @GetMapping(value = "/new")
    public String newAirporrForm(@ModelAttribute("airport") Airport airport, Model model) {
        return "airport/new";
    }

    @PostMapping(value = "/new")
    public String addAirport(@Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airport/new";
        }
        airport = airportService.save(airport);
        return "redirect:/airport";
    }

    @GetMapping(value = "/{id}")
    public String getAirportDetail(@PathVariable("id") Long id, Model model) {
        model.addAttribute("airport", airportService.findOne(id));
        return "airport/detail";
    }

    @PostMapping(value = "/{id}", params = "update")
    public String update(@Valid @ModelAttribute("airport") Airport airport, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airport/detail";
        }
        airport=airportService.save(airport);
        return "redirect:/airport";
    }

    @PostMapping(value = "/{id}", params = "delete")
    public String deleteAirport(@PathVariable("id") Long id){
        this.airportService.delete(id);
        return "redirect:/airport";
    }







}
