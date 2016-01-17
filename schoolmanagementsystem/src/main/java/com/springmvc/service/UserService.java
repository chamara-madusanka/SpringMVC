/*
 * UserService.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.service;

import java.util.List;

import com.springmvc.model.ResponseModel;
import com.springmvc.model.SearchUserModel;
import com.springmvc.model.User;
import com.springmvc.model.UserAndRole;
import com.springmvc.model.UserRole;

/**
 * @author Chamara Jayalath
 *
 */
public interface UserService {
	
	public void addUser(User user) throws Exception;
	
	public void addUserRole(UserRole userRole) throws Exception;

	public List<SearchUserModel> searchUsers(SearchUserModel searchUserModel) throws Exception;
	
}
