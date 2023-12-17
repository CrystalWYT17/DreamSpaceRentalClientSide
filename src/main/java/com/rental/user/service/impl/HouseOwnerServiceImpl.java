package com.rental.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.HouseOwnerDAO;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseOwner;
import com.rental.user.domain.User;
import com.rental.user.service.HouseOwnerService;

@Service
public class HouseOwnerServiceImpl implements HouseOwnerService {
	
	@Autowired
	private HouseOwnerDAO houseOwnerDAO;

	@Override
	public List<HouseOwner> findByUser(User user) {
		// TODO Auto-generated method stub
		return houseOwnerDAO.findByUser(user);
	}

	@Override
	public Integer addOwnedCountToUser(User user) {
		// TODO Auto-generated method stub
		
		Integer owned = 0;
		
		List<HouseOwner> houseOwnedList = findByUser(user);
		
		List<Long> houseOwnerList = new ArrayList<>();
		
		for(HouseOwner houseOwner: houseOwnedList) {
			
			Long houseOwnerId = houseOwner.getHouse().getHouseId();
			
			
			
			houseOwnerList.add(houseOwnerId);
			
			owned = houseOwnerList.size();
		
		}
		
		
		return owned;
	}

	@Override
	public List<HouseOwner> findAll() {
		// TODO Auto-generated method stub
		return houseOwnerDAO.findAll();
	}

	@Override
	public HouseOwner findByHouse(House house) {
		// TODO Auto-generated method stub
		return houseOwnerDAO.findByHouse(house);
	}
	}


