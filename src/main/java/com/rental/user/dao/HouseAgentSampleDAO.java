package com.rental.user.dao;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseAgent;
import com.rental.user.domain.HouseAgentSample;

public interface HouseAgentSampleDAO extends CrudRepository<HouseAgentSample, Long>{
	
	HouseAgentSample findByHouseId(Long houseId);
	
}
