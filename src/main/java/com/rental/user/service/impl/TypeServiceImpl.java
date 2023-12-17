package com.rental.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.TypeDAO;
import com.rental.user.domain.Type;
import com.rental.user.service.TypeService;

@Service
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeDAO typeDAO;
	
	@Override
	public List<Type> findAll() {
		// TODO Auto-generated method stub
		return typeDAO.findAll();
	}

	@Override
	public Type findBytypeName(String typeName) {
		// TODO Auto-generated method stub
		return typeDAO.findBytypeName(typeName);
	}

	@Override
	public Type findByTypeName(String typeName) {
		// TODO Auto-generated method stub
		return typeDAO.findBytypeName(typeName);
	}
	
	

}
