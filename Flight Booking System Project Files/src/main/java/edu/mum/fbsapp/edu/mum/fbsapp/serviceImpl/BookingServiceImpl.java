package edu.mum.fbsapp.edu.mum.fbsapp.serviceImpl;

import edu.mum.fbsapp.edu.mum.fbsapp.model.Booking;
import edu.mum.fbsapp.edu.mum.fbsapp.repository.BookingRepository;
import edu.mum.fbsapp.edu.mum.fbsapp.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
    @Autowired
    BookingRepository bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking findBookingByCC(String cCode) {
        return bookingRepository.findBookingByConfirmationCode(cCode);
    }
}
