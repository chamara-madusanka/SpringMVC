/*
 * StudentService.java
 *
 *
 *
 *
 *
 *
 * School management system 
 */
package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Student;

/**
 * @author Chamara Jayalath
 *
 */
public interface StudentService {

	public List<Student> getStudents(Student student) throws Exception;

}
