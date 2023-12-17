package com.rental.user.service;

/**
 * @author ThetHninSu
 */

import java.util.List;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseTownship;

public interface HouseTownshipService {

	List<House> findByTownship(String townshipName);
	
	HouseTownship findbyId(Integer id);
}
