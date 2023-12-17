package com.rental.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.Agent;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseAgent;

public interface HouseAgentDAO extends CrudRepository<HouseAgent, Long> {
	
	Agent findByHouse(House house);
	
	
}
