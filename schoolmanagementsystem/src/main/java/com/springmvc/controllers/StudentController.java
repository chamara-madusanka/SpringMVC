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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.model.Student;
import com.springmvc.service.StudentService;

/**
 * This controller is responsible for managing student management activities.
 * 
 * @author Chamara Jayalath
 *
 */
@Controller
public class StudentController {

	@Autowired
	StudentService studentService;

	/**
	 * This method will hit when the url request is "/student"
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public String studentManagementpage() {

		return "StudentManagementPage";
	}
	
	@RequestMapping(value="/searchstudent", method=RequestMethod.POST)
	public @ResponseBody List<Student> studentSearch(@RequestBody Student student) {

		List<Student> studentsList = null;
		try {
			studentsList = studentService.getStudents(student);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return studentsList;
	}
	
	@RequestMapping(value="/student/addstudent", method=RequestMethod.GET)
	public String addStudent() {
		
		return "AddStudentPage";
		
	}
}
