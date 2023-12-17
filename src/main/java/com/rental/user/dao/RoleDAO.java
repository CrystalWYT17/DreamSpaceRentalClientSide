package com.rental.user.dao;

/**
 * @author Wutt Yee Tun
 */

import org.springframework.data.repository.CrudRepository;

import com.rental.user.domain.Role;

public interface RoleDAO extends CrudRepository<Role, Integer>{

}
