package com.springboot.example.customer.service;

import java.util.List;

import com.springboot.example.customer.beans.Customer;
import com.springboot.example.exception.CustomerNotFountException;

public interface CustomerService {
	
	public Customer findByFirstName(String firstName) throws CustomerNotFountException;
	public List<Customer> findByLastName(String lastName)throws CustomerNotFountException;
	public Customer save(Customer customer) throws Exception;
	public List<Customer> findAllCustomers() throws Exception;

	
}
