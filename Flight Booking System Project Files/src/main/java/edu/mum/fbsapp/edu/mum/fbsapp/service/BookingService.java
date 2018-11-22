package edu.mum.fbsapp.edu.mum.fbsapp.service;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Booking;

public interface BookingService {

    Booking saveBooking(Booking booking);
    Booking findBookingByCC(String cCode);
}
