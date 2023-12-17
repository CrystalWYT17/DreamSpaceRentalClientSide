package com.rental.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.TownshipDAO;
import com.rental.user.domain.Township;
import com.rental.user.service.TownshipService;

@Service
public class TownshipServiceImpl implements TownshipService{

	@Autowired
	private TownshipDAO townshipDAO;
	
	@Override
	public List<Township> findAll() {
		// TODO Auto-generated method stub
		return townshipDAO.findAll();
	}

	@Override
	public Township findById(Integer townshipId) {
		// TODO Auto-generated method stub
		return townshipDAO.findById(townshipId).get();
	}

	@Override
	public Township findByTownshipName(String townshipName) {
		// TODO Auto-generated method stub
		return townshipDAO.findByTownshipName(townshipName);
	}

}
