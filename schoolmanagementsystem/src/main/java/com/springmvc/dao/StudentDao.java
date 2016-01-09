/*
 * StudentDao.java
 *
 *
 *
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
	
	public List<Student> getStudentByID(int studentID) throws Exception;

	public List<Student> getStudentByProperties(String firstName, String lastName, String grade, String gradeClass);

	public List<Student> getStudentByProperties(String firstName, String lastName, String grade);

	public List<Student> getStudentByProperties(String firstName, String lastName);

	public List<Student> getStudentByFirstnameAnd(String firstName, String grade, String gradeClass);

	public List<Student> getStudentByFirstnameAnd(String firstName, String grade);

	public List<Student> getStudentByLastnameAnd(String lastName, String grade, String gradeClass);

	public List<Student> getStudentByFirstname(String firstName);

	public List<Student> getStudentByLastnameAnd(String lastName, String grade);

	public List<Student> getStudentByLastname(String lastName);

	public List<Student> getStudentByGradeAndClass(String grade, String gradeClass);

	public List<Student> getStudentByGrade(String grade);

}
