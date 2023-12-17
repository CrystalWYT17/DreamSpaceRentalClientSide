package com.rental.user.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.Agent;

public interface AgentDAO extends CrudRepository<Agent, Long> {

	List<Agent> findAll();
}
