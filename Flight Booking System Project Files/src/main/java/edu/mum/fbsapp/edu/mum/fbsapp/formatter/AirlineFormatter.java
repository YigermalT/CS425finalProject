package edu.mum.fbsapp.edu.mum.fbsapp.formatter;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airline;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class AirlineFormatter implements Formatter<Airline> {

	@Autowired
	private AirlineService airlineService;

	@Override
	public String print(Airline c, Locale locale) {
		return c.getAirlineName();
	}

	@Override
	public Airline parse(String text, Locale locale) throws ParseException {
		System.out.println("Parsing Airline from: " + text);
		Airline airline = airlineService.findOne(Long.parseLong(text));
		return airline;
	}

}
