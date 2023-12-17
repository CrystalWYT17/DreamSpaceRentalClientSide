package com.rental.user.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.HouseDAO;
import com.rental.user.dao.HouseImageDAO;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseImage;
import com.rental.user.domain.HouseType;
import com.rental.user.service.HouseService;

@Service
public class HouseServiceImpl implements HouseService{
	
	@Autowired
	private HouseDAO houseDAO;
	
	@Autowired
	private HouseImageDAO houseImageDAO;

	@Override
	public House findById(Long houseId) {
		// TODO Auto-generated method stub
		return houseDAO.findById(houseId).get();
	}

	@Override
	public House saveHouse(House house) {
		// TODO Auto-generated method stub
		
		return houseDAO.save(house);
		
	}

	@Override
	public void saveHouseImage(House house, Set<HouseImage> houseImage) {
		// TODO Auto-generated method stub
		
		for(HouseImage hI: houseImage) {
			if(house.getHouseId().equals(hI.getHouse().getHouseId())) {
				houseImageDAO.save(hI);
			}
		}
		
	}
	
	

	@Override
	public List<House> findByPrice(Double price) {
		// TODO Auto-generated method stub
		List<House> houseList = houseDAO.findByPrice(price);
		return houseList;
	}

	@Override
	public List<House> findAll() {
		// TODO Auto-generated method stub
		return houseDAO.findAll();
	}

	@Override
	public List<House> findByHouseType(HouseType houseType) {
		// TODO Auto-generated method stub
		return houseDAO.findByHouseType(houseType);
	}


		

}
