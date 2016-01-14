/*
 * UserRole.java
 *
 *
 *
 * School management system 
 */
package com.springmvc.model;

/**
 * @author Chamara Jayalath
 *
 */
public class UserRole {
	private int userRoleID;
	private User user;
	private String role;
	
	public UserRole() {
	}
	
	public UserRole(User user, String role) {
		this.user = user;
		this.role = role;
	}
	
	public UserRole(String role) {
		this.role = role;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * This is the setter method for user
	 * 
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the userRoleID
	 */
	public int getUserRoleID() {
		return userRoleID;
	}

	/**
	 * This is the setter method for userRoleID
	 * 
	 * @param userRoleID the userRoleID to set
	 */
	public void setUserRoleID(int userRoleID) {
		this.userRoleID = userRoleID;
	}

	/**
	 * @return the userRole
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This is the setter method for userRole
	 * 
	 * @param userRole the userRole to set
	 */
	public void setRole(String userRole) {
		this.role = userRole;
	}

}
