/*
 * ResponseModel.java
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
public class ResponseModel {
	
	private boolean response;
	
	public ResponseModel() {
	}
	
	public ResponseModel(boolean response) {
		this.response = response;
	}

	/**
	 * @return the response
	 */
	public boolean isResponse() {
		return response;
	}

	/**
	 * This is the setter method for response
	 * 
	 * @param response the response to set
	 */
	public void setResponse(boolean response) {
		this.response = response;
	}

}
