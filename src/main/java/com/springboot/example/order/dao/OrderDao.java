package com.springboot.example.order.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.example.order.beans.Order;

@Repository
public interface OrderDao extends MongoRepository<Order, String> {
	
	public Optional<Order> findByOrderByOrderId(String orderid);
}

