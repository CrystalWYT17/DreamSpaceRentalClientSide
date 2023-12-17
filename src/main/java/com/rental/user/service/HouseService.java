package com.rental.user.service;

import java.util.List;
import java.util.Set;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseImage;
import com.rental.user.domain.HouseType;

public interface HouseService {
	
	House findById(Long houseId);
	
	House saveHouse(House house);
	
	void saveHouseImage(House house,Set<HouseImage> houseImage);

	List<House> findByPrice(Double price);
	
	List<House> findAll();
	
	List<House> findByHouseType(HouseType houseType);
}
