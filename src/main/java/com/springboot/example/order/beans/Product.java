package com.springboot.example.order.beans;


import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	@Id
	private String productID;
	private String productName;
	private double price;
	private double adjustedPrice;
	private String manufacturer;
	private List<Vendor> vendors;
	
	
	public Product() {
		
	}

	public Product(String productID, String productName, double price, String manufacturer,List<Vendor> vendors) {
	
		this.productID = productID;
		this.productName = productName;
		this.price = price;
		this.manufacturer = manufacturer;
		this.vendors = vendors;
		
	}
	
	
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", price=" + price
				+ ", manufacturer=" + manufacturer + ",vendors="+vendors+"]";
	}

	public double getAdjustedPrice() {
		return adjustedPrice;
	}

	public void setAdjustedPrice(double adjustedPrice) {
		this.adjustedPrice = adjustedPrice;
	}

	public List<Vendor> getVendors() {
		return vendors;
	}

	public void setVendors(List<Vendor> vendors) {
		this.vendors = vendors;
	}


	

}
