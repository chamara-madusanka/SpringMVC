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
package com.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.Student;
import com.springmvc.service.StudentService;

/**
 * This controller is responsible for managing student management activities.
 * 
 * @author Chamara Jayalath
 *
 */
@Controller
public class StudentManagementController {
	
	@Autowired
	StudentService studentService;

	/**
	 * This method will hit when the url request is "/student"
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String studentManagementpage(Model model) {
		model.addAttribute("student", new Student());
		
		try {
			model.addAttribute("studentList", studentService.getAllStudents());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "StudentManagementPage";
	}
}
