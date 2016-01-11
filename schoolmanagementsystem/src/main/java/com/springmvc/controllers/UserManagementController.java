/*
 * UserManagementController.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Chamara Jayalath
 *
 */
@Controller
public class UserManagementController {

	@RequestMapping(value="/user", method=RequestMethod.GET)
	public ModelAndView viewUserManagementPage() {

		return new ModelAndView("UserManagementPage");
	}

	@RequestMapping(value="/user/adduser", method=RequestMethod.GET)
	public ModelAndView addUser() {
		return new ModelAndView("AddUser");
	}

}
