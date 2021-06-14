package com.springboot.example.customer.beans;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import com.springboot.example.order.beans.Address;
import com.springboot.example.order.beans.Contact;
@Document
public class Customer {
	
	@Id
	private String customerId;
	private Address address;
	private String firstName;
	private String lastName;
	private Contact contact;
	public Customer() {
	
	}
	public Customer(String customerId, Address address, String firstName, String lastName,
			Contact contact) {
		this.customerId = customerId;
		this.address = address;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", address1=" + address + ", firstName=" + firstName + ", lastName=" + lastName + ", contact=" + contact + "]";
	}
	
	
}
