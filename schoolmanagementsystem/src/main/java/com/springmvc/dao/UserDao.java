package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.ResponseModel;
import com.springmvc.model.User;
import com.springmvc.model.UserRole;

public interface UserDao {
		
	public User findByUserName(String userName);
	
	public void addUser(User user) throws Exception;
	
	public void addUserRole(UserRole userRole) throws Exception;

	public List<ResponseModel> searchUsers(ResponseModel responseModel) throws Exception;
	
}
