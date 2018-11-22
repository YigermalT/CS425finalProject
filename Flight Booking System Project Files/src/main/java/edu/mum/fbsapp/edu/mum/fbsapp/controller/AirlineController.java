package edu.mum.fbsapp.edu.mum.fbsapp.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import edu.mum.fbsapp.edu.mum.fbsapp.model.Airline;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value="/airline")
public class AirlineController {

    @Autowired
    AirlineService airlineService;

    @GetMapping(value = {"","/","index"})
    public String getAirlines(Model model){
        model.addAttribute("airlines", airlineService.findAll());
        return "airline/index";
    }

    @GetMapping(value = "/new")
    public String newAirlineForm(@ModelAttribute("airline")Airline airline, Model model){
        model.addAttribute("airline", new Airline());
        return "airline/new";
    }

    @PostMapping(value = "/new")
    public String addNewAirline(@Valid @ModelAttribute("airline") Airline airline, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airline/new";
        }
        airline=airlineService.save(airline);
        return "redirect:/airline";
    }

    @GetMapping(value = "/{id}")
    public String getAirlineDetail(@PathVariable("id") Long id, Model model){
        model.addAttribute("airline", this.airlineService.findOne(id));
        return "airline/detail";
    }

    @PostMapping(value = "/{id}", params = "update")
    public String update(@Valid @ModelAttribute("id") Airline airline, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.hasErrors());
            return "airline/detail";
        }
        airline=airlineService.save(airline);
        return "redirect:/airline";
    }

    @PostMapping(value = "/{id}", params = "delete")
    public String deleteAirline(@PathVariable("id") Long id){
        this.airlineService.delete(id);
        return "redirect:/airline";
    }



}
