package com.rental.user.service;

import java.util.List;

import com.rental.user.domain.Agent;

public interface AgentService {

	Agent save(Agent agent);
	
	List<Agent> findAll();
	
	Agent findById(Long id);
	
	void removeOne(Long id);
}
