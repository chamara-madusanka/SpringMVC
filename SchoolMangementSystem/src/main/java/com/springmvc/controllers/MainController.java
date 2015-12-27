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
package main.java.com.springmvc.controllers;

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
		model.addAttribute("headerMessage", "Welcome to the SCHOOL MANAGEMENT SYSTEM");
	}

	/**
	 * This is the home page controller method
	 */
	@RequestMapping(value={"/", "/home"}, method=RequestMethod.GET)
	public ModelAndView homePage() {
		ModelAndView modelAndView = new ModelAndView("Home");
		return modelAndView;
	}

	/**
	 * This methode is for handling logging request.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/logging", method=RequestMethod.GET)
	public ModelAndView handleLogging(@RequestParam(value="logout", required=false) String logout) {

		ModelAndView modelAndView = new ModelAndView("LoggingPage");

		return modelAndView;
	}

	/**
	 * This is the methode for handling welcome page request.
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
    protected ModelAndView handleWelcome() {

        ModelAndView modelAndView = new ModelAndView("WelcomePage");

        return modelAndView;
    }

}
