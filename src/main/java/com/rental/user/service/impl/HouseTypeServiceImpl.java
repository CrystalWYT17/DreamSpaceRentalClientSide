package com.rental.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rental.user.dao.HouseTypeDAO;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseType;
import com.rental.user.domain.Type;
import com.rental.user.service.HouseTypeService;

@Service
public class HouseTypeServiceImpl implements HouseTypeService{
	
	private HouseTypeDAO houseTypeDAO;

	@Override
	public List<House> findByType(String typeName) {
		// TODO Auto-generated method stub
		List<House> houseList = houseTypeDAO.findByType(typeName);
		return houseList;
		
		
	}

	@Override
	public List<HouseType> findByType(Type type) {
		// TODO Auto-generated method stub
		return houseTypeDAO.findByType(type);
	}

	
	

}
