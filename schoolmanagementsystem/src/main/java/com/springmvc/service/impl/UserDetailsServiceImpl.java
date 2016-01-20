/*
 * UserDeatilsServiceImpl.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springmvc.dao.UserDao;
import com.springmvc.model.SearchUserModel;
import com.springmvc.model.UserRole;
import com.springmvc.service.UserService;

/**
 * @author Chamara Jayalath
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService, UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(final String userName) throws UsernameNotFoundException {
		com.springmvc.model.User user = userDao.findByUserName(userName);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	private UserDetails buildUserForAuthentication(com.springmvc.model.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
		Set<GrantedAuthority> setAuthority = new HashSet<>();
		for(UserRole userRole : userRoles) {
			setAuthority.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		
		List<GrantedAuthority> list = new ArrayList<>(setAuthority);
		return list;
	}

	@Override
	public void addUser(com.springmvc.model.User user) throws Exception {
		userDao.addUser(user);
	}

	@Override
	public void addUserRole(UserRole userRole) throws Exception {
		userDao.addUserRole(userRole);
	}

	@Override
	public List<SearchUserModel> searchUsers(SearchUserModel searchUserModel) throws Exception {
		
		String username = searchUserModel.getUsername();
		String role = searchUserModel.getRole();
		boolean enabled = searchUserModel.isEnabled();
		
		List<SearchUserModel> listOfUsers = new ArrayList<>();
		
		if(username.equals("")) {
			if(role.equals("")) {
				if(enabled == false) {
					listOfUsers = userDao.searchAllUsers();
				} else {
					listOfUsers = userDao.searchUsersByEnabled(enabled);
				}
			} else {
				if(enabled == false) {
					listOfUsers = userDao.searchUsersByRole(role);
				} else {
					listOfUsers = userDao.searchUsersByRoleAndEnabled(role, enabled);
				}
			}
		} else {
			if(role.equals("")) {
				if(enabled == false) {
					listOfUsers = userDao.searchUsersByName(username);
				} else {
					listOfUsers = userDao.searchUsersByNameAndEnabled(username, enabled);
				}
			} else {
				if(enabled == false) {
					listOfUsers = userDao.searchUsersByNameAndRole(username, role);
				} else {
					listOfUsers = userDao.searchUsers(searchUserModel);
				}
			}
		}
		
		return listOfUsers;
		
	}

}
