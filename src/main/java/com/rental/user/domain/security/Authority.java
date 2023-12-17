package com.rental.user.domain.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String authority;
	
	public Authority(String authority) {
		// TODO Auto-generated constructor stub
		this.authority=authority;
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}

}
