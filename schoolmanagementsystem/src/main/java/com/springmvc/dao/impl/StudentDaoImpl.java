/*
 * StudentDaoImpl.java
 *
 *
 *
 *
 *
 *
 * School management system 
 */
package com.springmvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.StudentDao;
import com.springmvc.model.Student;

/**
 * @author Chamara Jayalath
 *
 */

public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() throws Exception {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class).list();
		session.close();
		return studentList;
	}

}
