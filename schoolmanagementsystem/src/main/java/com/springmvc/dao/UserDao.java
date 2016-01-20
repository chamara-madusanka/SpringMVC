package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.SearchUserModel;
import com.springmvc.model.User;
import com.springmvc.model.UserRole;

public interface UserDao {
		
	public User findByUserName(String userName);
	
	public void addUser(User user) throws Exception;
	
	public void addUserRole(UserRole userRole) throws Exception;

	public List<SearchUserModel> searchUsers(SearchUserModel searchUserModel) throws Exception;

	public List<SearchUserModel> searchAllUsers() throws Exception;

	public List<SearchUserModel> searchUsersByEnabled(boolean enabled) throws Exception;

	public List<SearchUserModel> searchUsersByRole(String role) throws Exception;

	public List<SearchUserModel> searchUsersByRoleAndEnabled(String role, boolean enabled) throws Exception;

	public List<SearchUserModel> searchUsersByName(String username) throws Exception;

	public List<SearchUserModel> searchUsersByNameAndEnabled(String username, boolean enabled) throws Exception;

	public List<SearchUserModel> searchUsersByNameAndRole(String username, String role) throws Exception;
	
}
