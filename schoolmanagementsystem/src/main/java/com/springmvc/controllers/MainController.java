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

import org.apache.log4j.Logger;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	private static final Logger logger = Logger.getLogger(MainController.class);

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

		if(logger.isDebugEnabled()) {
			logger.debug("Debug message from logger");
		}

		ModelAndView modelAndView = new ModelAndView("HomePage");

		return modelAndView;
	}

	/**
	 * This methode is for handling logging request.
	 * 
	 * @return ModelAndView
	 * @throws IOException 
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView handleLogging(HttpServletResponse httpServletResponse, @RequestParam(value="logout", required=false) String logout) throws IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if(!(authentication instanceof AnonymousAuthenticationToken)) {
			String redirect = "redirect:/home";
			httpServletResponse.sendRedirect(redirect);
		}

		ModelAndView modelAndView = new ModelAndView("LoginPage");

		return modelAndView;
	}

}
