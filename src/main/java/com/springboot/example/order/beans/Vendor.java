package com.springboot.example.order.beans;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vendor {
	
	@Id
	private String vendorId;
	private String vendorName;
	private Address address;
	private Date registredDate;
	private List<Product> products;
	
	
	public Vendor() {
		
	}
	public Vendor(String vendorId, String vendorName, Address address, Date registredDate,List<Product> products) {
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.address = address;
	
		this.registredDate = registredDate;
		this.products = products;
	}
	public String getVendorId() {
		return vendorId;
	}
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Date getRegistredDate() {
		return registredDate;
	}
	public void setRegistredDate(Date registredDate) {
		this.registredDate = registredDate;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + ", address=" + address + ", registredDate=" + registredDate + ", products="+products+"]";
	}
	
	
	

}
