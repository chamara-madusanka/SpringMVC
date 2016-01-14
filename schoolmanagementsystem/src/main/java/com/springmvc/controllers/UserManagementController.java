/*
 * UserManagementController.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.controllers;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.User;
import com.springmvc.model.UserRole;
import com.springmvc.service.UserService;

/**
 * @author Chamara Jayalath
 *
 */
@Controller
public class UserManagementController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ModelAndView viewUserManagementPage() {

		return new ModelAndView("UserManagementPage");
	}

	@RequestMapping(value="/user/adduser", method=RequestMethod.GET)
	public ModelAndView addUser() {
		return new ModelAndView("AddUser");
	}
	
	@RequestMapping(value="/user/adduser", method=RequestMethod.POST)
	public ModelAndView addUser(@RequestParam Map<String, String> userAttributes) {
		String userName = userAttributes.get("username");
		String password = userAttributes.get("password");
		String role = userAttributes.get("userrole");
		boolean enabled = userAttributes.get("enabled").equals("Yes") ? true : false;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(password);
		
		User user = new User(userName, hashedPassword, enabled);
		userService.addUser(user);
		
		UserRole userRole = new UserRole(user, role);
		userService.addUserRole(userRole);

		return new ModelAndView("AddUser");
	}

}
