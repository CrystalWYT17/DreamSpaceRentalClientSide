package com.rental.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.Booking;

public interface BookingDAO extends CrudRepository<Booking, Long> {

	Booking findByCustomerName(String customerName);
	
	Booking findByEmail(String email);
}
