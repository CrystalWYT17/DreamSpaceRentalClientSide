package com.rental.user.dao;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.User;

public interface UserDAO extends CrudRepository<User, Long>{

	User findByEmail(String email);
	
	User findByUsername(String username);
	
}
