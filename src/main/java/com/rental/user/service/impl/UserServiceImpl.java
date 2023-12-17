package com.rental.user.service.impl;

import java.util.Set;

/**
 * @author Wutt Yee Tun
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rental.user.dao.RoleDAO;
import com.rental.user.dao.UserDAO;
import com.rental.user.domain.User;
import com.rental.user.domain.UserRole;
import com.rental.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.findByEmail(email);
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDAO.findByUsername(username);
	}

	@Override
	public User createUser(User user, Set<UserRole> userRoles) {
		// TODO Auto-generated method stub
		
		User localUser = userDAO.findByEmail(user.getEmail());
		if(localUser != null) {
			LOG.info("User {} already exists. Use other email.",user.getEmail());
		}
		else {
			for(UserRole ur : userRoles) {
				roleDAO.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			
			localUser = userDAO.save(user);
		} 
		
		
		
		return localUser;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id).get();
	}

}
