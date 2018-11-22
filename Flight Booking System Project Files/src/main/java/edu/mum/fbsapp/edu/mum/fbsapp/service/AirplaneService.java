package edu.mum.fbsapp.edu.mum.fbsapp.service;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Airplane;

public interface AirplaneService extends BaseService<Airplane> {

    Long saveAirplane(Airplane airplane);
}
