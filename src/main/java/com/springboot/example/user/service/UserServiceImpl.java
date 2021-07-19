package com.springboot.example.user.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Service;

import com.springboot.example.customer.beans.User;
import com.springboot.example.customer.dao.UserDao;
import com.springboot.example.exception.UserNotFountException;

@Service
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User findByFirstName(String firstName) throws UserNotFountException {
		User cust = this.userDao.findByFirstName(firstName);
		try {
			if (cust != null) {
				return cust;
			} else
				throw new UserNotFountException("No Customer Found with first Name " + firstName);
		} catch (UserNotFountException e) {
			throw new UserNotFountException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}

	@Override
	public List<User> findByLastName(String lastName) throws UserNotFountException {
		List<User> list = this.userDao.findByLastName(lastName);
		try {
			if (list != null || !list.isEmpty()) {
				return list;
			} else
				throw new UserNotFountException("No Customer Found with last Name " + lastName);
		} catch (UserNotFountException e) {
			throw new UserNotFountException(e.getMessage());
		} catch (Throwable e) {
			throw new RuntimeErrorException(null, e.getMessage());
		}
	}

	@Override
	public User save(User customer) throws Exception {
		try {
			return this.userDao.save(customer);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public List<User> findAllUsers() throws Exception {
		try {
			return this.userDao.findAll();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
