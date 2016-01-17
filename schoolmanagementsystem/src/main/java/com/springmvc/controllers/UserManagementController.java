/*
 * UserManagementController.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.model.ResponseModel;
import com.springmvc.model.User;
import com.springmvc.model.UserAndRole;
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
	public @ResponseBody ResponseModel addUser(@RequestBody UserAndRole userAndRole) {
		String userName = userAndRole.getUsername();
		String password = userAndRole.getPassword();
		String role = userAndRole.getRole();
		boolean enabled = userAndRole.isEnabled();
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashedPassword = encoder.encode(password);
		
		User user = new User(userName, hashedPassword, enabled);
		UserRole userRole = new UserRole(user, role);
		
		ResponseModel model = new ResponseModel();
		
		try {
			userService.addUser(user);
			userService.addUserRole(userRole);
			model.setResponse(true);
		} catch (Exception e) {
			model.setResponse(false);
		}
		
		return model;
	}
	
	@RequestMapping(value="/searchUsers", method=RequestMethod.POST)
	public @ResponseBody List<ResponseModel> searchUsers(@RequestBody ResponseModel responseModel) {
		
		List<ResponseModel> returnModel = null;
		
		try {
			returnModel = userService.searchUsers(responseModel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return returnModel;
	}

}
