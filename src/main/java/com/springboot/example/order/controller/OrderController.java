package com.springboot.example.order.controller;

import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.exception.OrderNotFoundException;
import com.springboot.example.order.beans.Order;
import com.springboot.example.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Qualifier("OrderServiceImpl")
	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {

		this.orderService = orderService;
	}

	@GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
	public String home() {
		return "Test Application";
	}

	@GetMapping(value = "/find/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Order findOrderById(@PathVariable String orderId) throws Exception {
		return  this.orderService.findOrderById(orderId).orElseThrow();
	}

	@PostMapping(path = "/save")
	public Order saveOrder(@RequestBody Order order) {
		System.out.println(order.toString());
		Order optOrder = this.orderService.saveOrder(order);
		if (optOrder != null)
			return optOrder;
		else
			return null;

	}

}
