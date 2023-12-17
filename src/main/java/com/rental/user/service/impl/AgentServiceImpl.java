package com.rental.user.service.impl;
/**
 * @author Lin Lae Win Wah
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.AgentDAO;
import com.rental.user.domain.Agent;
import com.rental.user.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private AgentDAO agentDAO;
	
	@Override
	public Agent save(Agent agent) {
		// TODO Auto-generated method stub
		return agentDAO.save(agent);
	}

	@Override
	public List<Agent> findAll() {
		// TODO Auto-generated method stub
		return agentDAO.findAll();
	}

	@Override
	public Agent findById(Long id) {
		// TODO Auto-generated method stub
		return agentDAO.findById(id).get();
	}

	@Override
	public void removeOne(Long id) {
		// TODO Auto-generated method stub
		agentDAO.deleteById(id);
	}

	
}
