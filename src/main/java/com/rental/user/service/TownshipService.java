package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.Township;

public interface TownshipService {

	List<Township> findAll();

	Township findByTownshipName(String townshipName);
	
	Township findById(Integer townshipId);
}
