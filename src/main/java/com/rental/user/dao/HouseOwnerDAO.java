package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.House;
import com.rental.user.domain.HouseOwner;
import com.rental.user.domain.User;





public interface HouseOwnerDAO extends CrudRepository<HouseOwner, Long> {
	
	List<HouseOwner> findByUser(User user);
	
	List<HouseOwner> findAll();
	
	HouseOwner findByHouse(House house);
	

}
