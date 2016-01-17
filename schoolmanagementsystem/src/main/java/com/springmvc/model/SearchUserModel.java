/*
 * SearchUserModel.java
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
public class SearchUserModel {
	String username;
	String role;
	boolean enabled;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * This is the setter method for username
	 * 
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This is the setter method for role
	 * 
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * This is the setter method for enabled
	 * 
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
