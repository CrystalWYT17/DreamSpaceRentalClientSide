package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseImage;

public interface HouseImageDAO extends CrudRepository<HouseImage, Integer>{
	
	List<HouseImage> findByHouse(House house);
}
