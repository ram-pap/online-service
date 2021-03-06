package com.springboot.example.order.controller;

import java.util.Date;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.example.exception.Error;
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
	public ResponseEntity findOrderById(@PathVariable String orderId) throws Exception {

		Order order = this.orderService.findOrderById(orderId);
		try {
			if (order != null)
				return ResponseEntity.ok(order);
			else
				throw new Exception();
		} catch (Throwable e) {
			return ResponseEntity.ok(new Error().setTimeStamp(new Date()).setStatus(HttpStatus.CONFLICT)
					.setMessage(e.getMessage()).setError(e.getCause()));
		}

	}

	@PostMapping(path = "/save")
	public ResponseEntity saveOrder(@RequestBody Order order) {
		System.out.println(order.toString());
		Order optOrder = null;
		try {
			optOrder = this.orderService.saveOrder(order);
			if (optOrder != null)
				return ResponseEntity.ok(optOrder);
			else
				throw new Exception();

		} catch (Throwable e) {
			return ResponseEntity.ok(new Error().setTimeStamp(new Date()).setStatus(HttpStatus.CONFLICT)
					.setMessage(e.getMessage()).setError(e.getCause()));
		}

	}

}
