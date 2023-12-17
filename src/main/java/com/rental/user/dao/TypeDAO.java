package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.Type;

public interface TypeDAO extends CrudRepository<Type, Integer>{

	List<Type> findAll();
	
	Type findBytypeName(String typeName);
	
}
