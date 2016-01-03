/*
 * @Source : SpringMVC/schoolmanagementsystem/src/main/java/com/springmvc/model/Student.java
 *
 *
 *
 *
 *
 *
 * School management system 
 */
package com.springmvc.model;

import java.util.Date;

/**
 * @author Chamara Jayalath
 *
 */
public class Student {

	private int studentID;
	private String firstName;
	private String midName;
	private String lastName;
	private Date birthdate;
	private String address;
	private String grade;
	private String gradeClass;

	/**
	 * @return the studentID
	 */
	public int getStudentID() {
		return studentID;
	}

	/**
	 * This is the setter method for studentID
	 * 
	 * @param studentID the studentID to set
	 */
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * This is the setter method for firstName
	 * 
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the midName
	 */
	public String getMidName() {
		return midName;
	}

	/**
	 * This is the setter method for midName
	 * 
	 * @param midName the midName to set
	 */
	public void setMidName(String midName) {
		this.midName = midName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * This is the setter method for lastName
	 * 
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthdate
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * This is the setter method for birthdate
	 * 
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This is the setter method for address
	 * 
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * This is the setter method for grade
	 * 
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * @return the gradeClass
	 */
	public String getGradeClass() {
		return gradeClass;
	}

	/**
	 * This is the setter method for gradeClass
	 * 
	 * @param gradeClass the gradeClass to set
	 */
	public void setGradeClass(String gradeClass) {
		this.gradeClass = gradeClass;
	}

}
