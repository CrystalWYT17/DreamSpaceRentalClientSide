package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.HouseRenter;
import com.rental.user.domain.User;

public interface HouseRenterDAO extends CrudRepository<HouseRenter, Long>{

	
	List<HouseRenter> findByUser(User user);
	
	List<HouseRenter> findAll();
}
