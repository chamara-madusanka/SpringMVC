/*
 * StudentDao.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Student;

/**
 * @author Chamara Jayalath
 *
 */
public interface StudentDao {

	public List<Student> getAllStudents() throws Exception;
}
