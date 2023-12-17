package com.rental.user.service;

import com.rental.user.domain.Agent;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseAgent;


public interface HouseAgentService {
	Agent findByHouse(House house);
	
	HouseAgent findById(Long id);
}
