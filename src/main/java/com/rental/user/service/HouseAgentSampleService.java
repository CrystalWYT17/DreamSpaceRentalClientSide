package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.HouseAgentSample;

public interface HouseAgentSampleService {
	
	List<HouseAgentSample> findAll();

	void save(HouseAgentSample hs);
	
	void deleteById(Long id);
	
	HouseAgentSample findByHouseId(Long houseId);
	
	
}
