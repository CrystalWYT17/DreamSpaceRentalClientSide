package com.rental.user.service;

import java.util.Set;

/**
 * @author Wutt Yee Tun
 */

import com.rental.user.domain.User;
import com.rental.user.domain.UserRole;

public interface UserService {
	
	User findByEmail(String email);
	
	User findByUsername(String username);
	
	User createUser(User user,Set<UserRole>  userRoles);
	
	User updateUser(User user);
	
	User saveUser(User user);
	
	User findById(Long id);

}
