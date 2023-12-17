package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseType;

public interface HouseDAO extends CrudRepository<House, Long>{
	
	List<House> findByPrice(Double price);
	
	List<House> findAll();
	
	List<House> findByHouseType(HouseType houseType);
}
