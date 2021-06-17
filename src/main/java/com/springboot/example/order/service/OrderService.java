package com.springboot.example.order.service;

import java.util.List;
import java.util.Optional;

import com.springboot.example.exception.OrderNotFoundException;
import com.springboot.example.order.beans.Order;


public interface OrderService {
	
	public Order findOrderById(String orderId) throws OrderNotFoundException;
	public Order saveOrder(Order order);
	public List<Order> saveOrder(List<Order> orders);


}
