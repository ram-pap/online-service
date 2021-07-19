package com.springboot.example.user.service;

import java.util.List;

import com.springboot.example.customer.beans.User;
import com.springboot.example.exception.UserNotFountException;


public interface UserService {
	
	public User findByFirstName(String firstName) throws UserNotFountException;
	public List<User> findByLastName(String lastName)throws UserNotFountException;
	public User save(User User) throws Exception;
	public List<User> findAllUsers() throws Exception;

	
}
