package com.springboot.example.customer.controller;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.example.customer.beans.Customer;
import com.springboot.example.customer.service.CustomerService;
import com.springboot.example.exception.CustomerNotFountException;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Qualifier("CustomerServiceImpl")
	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	@SuppressWarnings("deprecation")
	@GetMapping("/")
	public String home() {
		return "I am ready to serve : " + new Date().getDate();
	}
	@GetMapping(value = "/fname/{fname}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findByFirstName(@PathVariable("fname") String firstName)
			throws CustomerNotFountException {
		return this.customerService.findByFirstName(firstName);
	}

	@GetMapping(value = "/lname/{lname}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<?> findByLastName(@PathVariable("lname") String lastName) throws CustomerNotFountException {
		return this.customerService.findByLastName(lastName);
	}
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer save(@RequestBody Customer customer) throws Exception {
		return this.customerService.save(customer);
	}
	@GetMapping(value = "/showAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findAllCustomers() throws Exception {
		return this.customerService.findAllCustomers();
	}
}
