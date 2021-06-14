package com.springboot.example.order.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.springboot.example.exception.OrderNotFoundException;
import com.springboot.example.order.beans.Order;
import com.springboot.example.order.dao.OrderDao;

@Service
public class OrderServiceImpl implements OrderService {

	@Qualifier("OrderDao")
	private OrderDao orderDao;

	@Autowired
	public OrderServiceImpl(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Optional<Order> findOrderById(String orderId) throws OrderNotFoundException {
		Optional<Order> optOrder = this.orderDao.findById(orderId);
		try {
			if (optOrder.isPresent()) {
				return optOrder;
			}else
				throw new OrderNotFoundException("No Order was found with "+orderId);
		} catch (OrderNotFoundException e) {
			throw new OrderNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}
	public Order saveOrder(Order order) {

		return this.orderDao.save(order);
	}

	public List<Order> saveOrder(List<Order> orders) {

		return this.orderDao.saveAll(orders);
	}

}
