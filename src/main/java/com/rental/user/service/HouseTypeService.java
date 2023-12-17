package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.House;
import com.rental.user.domain.Type;
import com.rental.user.domain.HouseType;


public interface HouseTypeService {

List<House> findByType(String typeName);
	
	List<HouseType> findByType(Type type);
	
}
