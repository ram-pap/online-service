package com.springboot.example.order.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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

	public Order findOrderById(String orderId) throws OrderNotFoundException {
		Optional<Order> optOrder = this.orderDao.findById(orderId);
		try {
			if (optOrder.isPresent()) {
				return optOrder.get();
			}else
				throw new OrderNotFoundException("No Order was found with "+orderId);
		} catch (OrderNotFoundException e) {
			throw new OrderNotFoundException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}
	public Order saveOrder(Order order) throws Throwable {
		
		Order savedOrder =  this.orderDao.save(order);
		try {
		if(savedOrder !=null)
			return savedOrder;
		else
			throw new Exception("Unable save Order : "+order.toString()+" Due to : ");
		}catch(Throwable t) {
			throw new Throwable(t.getMessage()+t.getCause());
		}
		
	}

	public List<Order> saveOrder(List<Order> orders) {

		return this.orderDao.saveAll(orders);
	}

}
