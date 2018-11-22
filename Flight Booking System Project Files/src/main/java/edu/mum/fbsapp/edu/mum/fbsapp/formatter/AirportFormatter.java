package edu.mum.fbsapp.edu.mum.fbsapp.formatter;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airport;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class AirportFormatter implements Formatter<Airport> {

    @Autowired
    private AirportService airportService;

    @Override
    public String print(Airport c, Locale locale) {
        return c.getAirportCode() + " - " + c.getCity() + " - " + c.getCountry();
    }

    @Override
    public Airport parse(String text, Locale locale) throws ParseException {
        System.out.println("Parsing Airport from: " + text);
        Airport airport = airportService.findOne(Long.parseLong(text));
        return airport;
    }

}
