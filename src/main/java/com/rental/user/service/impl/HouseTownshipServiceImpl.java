package com.rental.user.service.impl;

import java.util.List;

/**
 * @author ThetHninSu
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.HouseTownshipDAO;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseTownship;
import com.rental.user.service.HouseTownshipService;

@Service
public class HouseTownshipServiceImpl implements HouseTownshipService {

	@Autowired
	private HouseTownshipDAO houseTownshipDAO;
	
	@Override
	public List<House> findByTownship(String townshipName) {
		// TODO Auto-generated method stub
		List<House> houseList = houseTownshipDAO.findByTownship(townshipName);
		return houseList;
	}

	@Override
	public HouseTownship findbyId(Integer id) {
		// TODO Auto-generated method stub
		HouseTownship houseTownship = houseTownshipDAO.findById(id).get();
		return houseTownship;
	}

}
