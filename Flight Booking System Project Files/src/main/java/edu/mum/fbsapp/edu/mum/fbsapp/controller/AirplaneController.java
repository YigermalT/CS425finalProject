package edu.mum.fbsapp.edu.mum.fbsapp.controller;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airplane;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/airplane")
public class AirplaneController {

    @Autowired
    AirplaneService airplaneService;


    @GetMapping(value = {"","/","/index"})
    public String getAirplanes(Model model){

        model.addAttribute("airplanes", airplaneService.findAll());
        return "airplane/index";
    }

    @GetMapping(value = "/new")
    public String newAirplaneForm(@ModelAttribute("airplane")Airplane airplane, Model model){
        return "airplane/new";
    }

    @PostMapping(value = "/new")
    public String addAirplane(@Valid @ModelAttribute("airplane") Airplane airplane, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airplane/new";
        }
        airplane=airplaneService.save(airplane);
        return "redirect:/airplane";
    }

    @GetMapping(value = "/{id}")
    public String getAirplaneDetail(@PathVariable("id") Long  id,Model model){
        model.addAttribute("airplane", this.airplaneService.findOne(id));
        return "airplane/detail";
    }

    @PostMapping(value = "/{id}", params = "update")
    public String update(@Valid @ModelAttribute("Airplane") Airplane airplane, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "airplane/detail";
        }
        airplane=airplaneService.save(airplane);
        return "redirect:/airplane";
    }

    @PostMapping(value = "/{id}", params = "delete")
    public String deleteAirplane(@PathVariable("id") Long id){
        this.airplaneService.delete(id);
        return "redirect:/airplane";
    }



}
