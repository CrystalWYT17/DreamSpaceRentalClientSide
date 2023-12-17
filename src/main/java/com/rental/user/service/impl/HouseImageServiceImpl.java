package com.rental.user.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Khin Pyae Pyae Phyo
 */
import org.springframework.stereotype.Service;

import com.rental.user.dao.HouseImageDAO;
import com.rental.user.domain.House;
import com.rental.user.domain.HouseImage;
import com.rental.user.service.HouseImageService;

@Service
public class HouseImageServiceImpl implements HouseImageService {

	@Autowired
	private HouseImageDAO houseImageDAO;

	@Override
	public List<HouseImage> findByHouse(House house) {
		// TODO Auto-generated method stub
		
		return houseImageDAO.findByHouse(house);
	}
	
	
}
