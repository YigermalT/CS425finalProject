package edu.mum.fbsapp.edu.mum.fbsapp.formatter;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airplane;
import edu.mum.fbsapp.edu.mum.fbsapp.service.AirplaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class AirplaneFormatter implements Formatter<Airplane> {

    @Autowired
    private AirplaneService airplaneService;

    @Override
    public String print(Airplane c, Locale locale) {
        return c.getModel() + " - " + c.getSerialModel();
    }

    @Override
    public Airplane parse(String text, Locale locale) throws ParseException {
        System.out.println("Parsing Airplane from: " + text);
        Airplane airplane = airplaneService.findOne(Long.parseLong(text));
        return airplane;
    }

}
