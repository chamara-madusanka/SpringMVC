/*
 * UserAndRole.java
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
public class UserAndRole {

	private String username;
	private String password;
	private boolean enabled;
	private String role;

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
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This is the setter method for password
	 * 
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
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

}
