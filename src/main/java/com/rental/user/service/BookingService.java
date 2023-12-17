package com.rental.user.service;

import com.rental.user.domain.Booking;
import com.rental.user.domain.House;

public interface BookingService {

	Booking findByCustomerName(String customerName);
	
	Booking findByEmail(String email);
	
	Booking saveBooking(Booking booking);
}
