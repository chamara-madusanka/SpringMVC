/*
 * @Source : SpringMVC/SchoolMangementSystem/src/main/java/com/springmvc/controllers/StudentManagementController.java
 * 
 * 
 * 
 * 
 * 
 * 
 * School management system
 */
package main.java.com.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * This controller is responsible for managing student management activities.
 * 
 * @author Chamara Jayalath
 *
 */
@Controller
public class StudentManagementController {

	/**
	 * This method will hit when the url request is "/student"
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public ModelAndView studentManagementpage() {
		return new ModelAndView("StudentManagementPage");
	}
}
