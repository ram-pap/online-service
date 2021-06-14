package com.springboot.example.customer.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.springboot.example.customer.beans.Customer;
import com.springboot.example.customer.dao.CustomerDao;
import com.springboot.example.exception.CustomerNotFountException;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer findByFirstName(String firstName) throws CustomerNotFountException {
		Customer cust = this.customerDao.findByFirstName(firstName);
		try {
			if (cust != null) {
				return cust;
			} else
				throw new CustomerNotFountException("No Customer Found with first Name " + firstName);
		} catch (CustomerNotFountException e) {
			throw new CustomerNotFountException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}

	@Override
	public List<Customer> findByLastName(String lastName) throws CustomerNotFountException {
		List<Customer> list = this.customerDao.findByLastName(lastName);
		try {
			if (list != null || !list.isEmpty()) {
				return list;
			} else
				throw new CustomerNotFountException("No Customer Found with last Name " + lastName);
		} catch (CustomerNotFountException e) {
			throw new CustomerNotFountException(e.getMessage());
		} catch (Throwable e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}

	@Override
	public Customer save(Customer customer) throws Exception {
		try {
			return this.customerDao.save(customer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public List<Customer> findAllCustomers() throws Exception {
		try {
			return this.customerDao.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
