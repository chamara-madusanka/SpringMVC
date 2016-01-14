/*
 * UserService.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.service;

import com.springmvc.model.User;
import com.springmvc.model.UserRole;

/**
 * @author Chamara Jayalath
 *
 */
public interface UserService {
	
	public void addUser(User user);
	
	public void addUserRole(UserRole userRole);
	
}
