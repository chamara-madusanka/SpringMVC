/*
 * StudentServiceImpl.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.StudentDao;
import com.springmvc.model.Student;
import com.springmvc.service.StudentService;

/**
 * @author Chamara Jayalath
 *
 */
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public List<Student> getAllStudents() throws Exception {
		return studentDao.getAllStudents();
	}

}
