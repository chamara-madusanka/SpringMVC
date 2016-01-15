package com.springmvc.dao;

import com.springmvc.model.User;
import com.springmvc.model.UserRole;

public interface UserDao {
		
	public User findByUserName(String userName);
	
	public void addUser(User user) throws Exception;
	
	public void addUserRole(UserRole userRole) throws Exception;
	
}
