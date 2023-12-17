package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.House;
import com.rental.user.domain.Type;

import com.rental.user.domain.HouseType;

public interface HouseTypeDAO extends CrudRepository<HouseType, Integer> {
	
List<House> findByType(String typeName);

List<HouseType> findByType(Type type);

}
