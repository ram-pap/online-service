package com.springboot.example.order.beans;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Order {
	
    @Id
	private String orderId;
	private List<Product> products;
	private String customerID;
	private Date orderDate;
	
	
	public Order() {
	
	}
	
	public Order(String orderId,String customerID, Date orderDate,List<Product> products) {
		
		this.orderId = orderId;
		this.products = products;
		this.customerID = customerID;
		this.orderDate = orderDate;
	}

	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", products=" + products + ", customerID=" + customerID + ", orderDate="
				+ orderDate + "]";
	}


	
	


}
