/*
 * StudentServiceImpl.java
 *
 *
 *
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

	public List<Student> getStudents(Student student) throws Exception {

		List<Student> studentsList = null;
		
		if((student.getStudentID()) != 0) {
			studentsList = studentDao.getStudentByID(student.getStudentID());

		} else if(!student.getFirstName().isEmpty() && !student.getLastName().isEmpty()) {
			
			if(!student.getGrade().isEmpty()) {
				if(!student.getGradeClass().isEmpty()) {
					studentsList = studentDao.getStudentByProperties(
							student.getFirstName(), student.getLastName(), 
							student.getGrade(), student.getGradeClass());
				} else {
					studentsList = studentDao.getStudentByProperties(
							student.getFirstName(), student.getLastName(), 
							student.getGrade());
				}
			} else {
				studentsList = studentDao.getStudentByProperties(
						student.getFirstName(), student.getLastName());
			}
			
		} else if(!student.getFirstName().isEmpty()) {
			
			if(!student.getGrade().isEmpty()) {
				if(!student.getGradeClass().isEmpty()) {
					studentsList = studentDao.getStudentByFirstnameAnd(
							student.getFirstName(), student.getGrade(), student.getGradeClass());
				} else {
					studentsList = studentDao.getStudentByFirstnameAnd(
							student.getFirstName(), student.getGrade());
				}
			} else {
				studentsList = studentDao.getStudentByFirstname(student.getFirstName());
			}
			
		} else if(!student.getLastName().isEmpty()) {
			
			if(!student.getGrade().isEmpty()) {
				if(!student.getGradeClass().isEmpty()) {
					studentsList = studentDao.getStudentByLastnameAnd(student.getLastName(), student.getGrade(), student.getGradeClass());
				} else {
					studentsList = studentDao.getStudentByLastnameAnd(student.getLastName(), student.getGrade());
				}
			} else {
				studentsList = studentDao.getStudentByLastname(student.getLastName());
			}
			
		} else if(!student.getGrade().isEmpty()) {
			
			if(!student.getGradeClass().isEmpty()) {
				studentsList = studentDao.getStudentByGradeAndClass(student.getGrade(), student.getGradeClass());
			} else {
				studentsList = studentDao.getStudentByGrade(student.getGrade());
			}
			
		} else {
			studentsList = studentDao.getAllStudents();
		}
		return studentsList;
	}

	@Override
	public boolean addStudent(Student student) throws Exception {
		
		if(student != null) {
			studentDao.addStudent(student);
			return true;
		}

		return false;
	}

}
