package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.HouseRenter;
import com.rental.user.domain.User;

public interface HouseRenterService {
	
	
	List<HouseRenter> findByUser(User user);

	Integer addRentCountToUser(User user);
	
	List<HouseRenter> findAll();

}
