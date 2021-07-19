package com.springboot.example.customer.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.springboot.example.order.beans.Address;

@Document
public class User {
	
	@Id
	private String userId;
	
	private String firstName;
	private String lastName;
	private Address address;
	private String mobileNo;
	private String email;
	public User() {
	
	}
	public User(String userId, Address address, String firstName, String lastName,
			String mobileNo,String email) {
		this.userId = userId;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNo = mobileNo;
		this.email = email;
	}
	public String getCustomerId() {
		return userId;
	}
	public void setCustomerId(String userId) {
		this.userId = userId;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "User [UserId=" + userId + ", address1=" + address + ", firstName=" + firstName + ", lastName=" + lastName + ", mobline No=" + mobileNo + ",  email"+email+"]";
	}
	

}
