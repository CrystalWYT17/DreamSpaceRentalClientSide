package com.rental.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.HouseAgentDAO;
import com.rental.user.domain.Agent;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseAgent;

import com.rental.user.service.HouseAgentService;

@Service
public class HouseAgentServiceImpl implements HouseAgentService{

	@Autowired
	private HouseAgentDAO houseAgenteDAO;

	

	public HouseAgent findById(Long id) {
		// TODO Auto-generated method stub
		HouseAgent houseAgent=houseAgenteDAO.findById(id).get();
		return houseAgent;
	}



	@Override
	public Agent findByHouse(House house) {
		// TODO Auto-generated method stub
		return houseAgenteDAO.findByHouse(house);
	}

	
	
	

}
