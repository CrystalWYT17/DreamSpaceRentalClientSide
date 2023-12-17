package com.rental.user.dao;

/**
 * @author ThetHninSu
 */

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseTownship;

public interface HouseTownshipDAO extends CrudRepository<HouseTownship, Integer> {

	List<House> findByTownship(String townshipName);
	
	
}
