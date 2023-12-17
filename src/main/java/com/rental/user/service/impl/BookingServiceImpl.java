package com.rental.user.service.impl;
/**
 * @author Thet Hnin Su
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.BookingDAO;
import com.rental.user.domain.Booking;
import com.rental.user.domain.House;
import com.rental.user.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	
	@Override
	public Booking findByCustomerName(String customerName) {
		// TODO Auto-generated method stub
		return bookingDAO.findByCustomerName(customerName);
	}

	@Override
	public Booking findByEmail(String email) {
		// TODO Auto-generated method stub
		return bookingDAO.findByEmail(email);
	}

	@Override
	public Booking saveBooking(Booking booking) {
		// TODO Auto-generated method stub
	
		return bookingDAO.save(booking);
	}

}
