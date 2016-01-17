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
import com.springmvc.model.ResponseModel;
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
	public List<ResponseModel> searchUsers(ResponseModel responseModel) throws Exception {
		return userDao.searchUsers(responseModel);
	}

}
