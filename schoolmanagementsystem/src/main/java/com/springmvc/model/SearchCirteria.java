package com.springmvc.model;

public class SearchCirteria {

	private int studentID;
	private String firstName;
	private String lastName;
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
}
