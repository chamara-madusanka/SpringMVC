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
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByID(int studentID) throws Exception {
		
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class).add(Restrictions.eq("studentID", studentID)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByProperties(String firstName, String lastName, String grade, String gradeClass) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("firstName", firstName))
				.add(Restrictions.eq("lastName", lastName))
				.add(Restrictions.eq("grade", grade))
				.add(Restrictions.eq("gradeClass", gradeClass)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByProperties(String firstName, String lastName, String grade) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("firstName", firstName))
				.add(Restrictions.eq("lastName", lastName))
				.add(Restrictions.eq("grade", grade)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByProperties(String firstName, String lastName) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("firstName", firstName))
				.add(Restrictions.eq("lastName", lastName)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByFirstnameAnd(String firstName, String grade, String gradeClass) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("firstName", firstName))
				.add(Restrictions.eq("grade", grade))
				.add(Restrictions.eq("gradeClass", gradeClass)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByFirstnameAnd(String firstName, String grade) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("firstName", firstName))
				.add(Restrictions.eq("grade", grade)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByLastnameAnd(String lastName, String grade, String gradeClass) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("lastName", lastName))
				.add(Restrictions.eq("grade", grade))
				.add(Restrictions.eq("gradeClass", gradeClass)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByFirstname(String firstName) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("firstName", firstName)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByLastnameAnd(String lastName, String grade) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("lastName", lastName))
				.add(Restrictions.eq("grade", grade)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByLastname(String lastName) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("lastName", lastName)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByGradeAndClass(String grade, String gradeClass) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("grade", grade))
				.add(Restrictions.eq("gradeClass", gradeClass)).list();
		session.close();
		return studentList;
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentByGrade(String grade) {
		Session session = sessionFactory.openSession();
		List<Student> studentList = session.createCriteria(Student.class)
				.add(Restrictions.eq("grade", grade)).list();
		session.close();
		return studentList;
	}

	@Override
	public void addStudent(Student student) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(student);
		transaction.commit();
		session.close();
	}

}
