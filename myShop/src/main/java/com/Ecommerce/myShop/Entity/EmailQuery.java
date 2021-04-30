package com.Ecommerce.myShop.Entity;

import org.springframework.stereotype.Component;

@Component
public class EmailQuery {

	private String name;
	private String contactNo;
	private String message;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
