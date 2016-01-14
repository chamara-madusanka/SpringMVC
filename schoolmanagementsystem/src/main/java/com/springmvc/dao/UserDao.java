package com.springmvc.dao;

import com.springmvc.model.User;

public interface UserDao {
		
	public User findByUserName(String userName);
	
	public void addUser(User user);
	
}
