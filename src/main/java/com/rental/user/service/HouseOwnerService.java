package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseOwner;
import com.rental.user.domain.User;

public interface HouseOwnerService {

	List<HouseOwner> findByUser(User user);
	
	Integer addOwnedCountToUser(User user);
	
	List<HouseOwner> findAll();
	
	HouseOwner findByHouse(House house);
	
}
