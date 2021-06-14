package com.springboot.example.order.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
	@Id
	private String addressId;
	private String houseNo;
	private String apptName;
	private String street1;
	private String street2;
	private String landMark;
	private String city;
	private String state;
	private String country;
	private String zip;
	

	public Address() {

	}

	public Address(String addressId, String houseNo, String apptName, String street1, String street2, String landMark,
			String city, String state, String country, String zip) {
		super();
		this.addressId = addressId;
		this.houseNo = houseNo;
		this.apptName = apptName;
		this.street1 = street1;
		this.street2 = street2;
		this.landMark = landMark;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
		
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getApptName() {
		return apptName;
	}

	public void setApptName(String apptName) {
		this.apptName = apptName;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", houseNo=" + houseNo + ", apptName=" + apptName + ", street1="
				+ street1 + ", street2=" + street2 + ", landMark=" + landMark + ", City=" + city + ", state=" + state
				+ ", country=" + country + ", zip=" + zip + "]";
	}

}
