package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.Type;

public interface TypeService {

	List<Type> findAll();
	
	Type findBytypeName(String typeName);

	Type findByTypeName(String typeName);
	
}
