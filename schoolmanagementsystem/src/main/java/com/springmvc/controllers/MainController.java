/*
 * @Source : /SpringMVC/SchoolMangementSystem/src/main/java/com/springmvc/controllers/MainController.java
 * 
 * 
 * 
 * 
 * 
 * School management system
 * 
 */
package com.springmvc.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * This is the main controller. It will handle welcome and logging.
 * 
 * @author Chamara Madusanka Jayalath
 *
 */
@Controller
public class MainController {

	@ModelAttribute
	public void getHeaderMessage(Model model) {
		model.addAttribute("headerMessage", "SCHOOL MANAGEMENT SYSTEM");
	}

	/**
	 * This is the method for redirecting "/" url to "/home". 
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public void handleDefaultPage(HttpServletResponse httpServletResponse) throws IOException {

		String redirect = "redirect:/home";
		httpServletResponse.sendRedirect(redirect);
	}

	/**
	 * This is the method for handling home page request.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public ModelAndView handleHomePage() {

		ModelAndView modelAndView = new ModelAndView("HomePage");

		return modelAndView;
	}

	/**
	 * This methode is for handling logging request.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView handleLogging(@RequestParam(value="logout", required=false) String logout) {

		ModelAndView modelAndView = new ModelAndView("LoginPage");

		return modelAndView;
	}

}
