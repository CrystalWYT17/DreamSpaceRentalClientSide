package com.rental.user.service;

import java.util.List;



import com.rental.user.domain.House;
import com.rental.user.domain.HouseImage;

public interface HouseImageService{

	List<HouseImage> findByHouse(House house);
}
