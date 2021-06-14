package com.springboot.example.order.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Contact {
	@Id
	private String contactId;
	private String mobileNo;
	private String mobileNo2;
	private String email;
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Contact(String contactId, String mobileNo, String mobileNo2, String email) {
		super();
		this.contactId = contactId;
		this.mobileNo = mobileNo;
		this.mobileNo2 = mobileNo2;
		this.email = email;
	}

	public String getContactId() {
		return contactId;
	}
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getMobileNo2() {
		return mobileNo2;
	}
	public void setMobileNo2(String mobileNo2) {
		this.mobileNo2 = mobileNo2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", mobileNo=" + mobileNo + ", mobileNo2=" + mobileNo2 + ", email="
				+ email + "]";
	}
	
	

}
