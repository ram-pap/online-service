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
import org.springframework.web.bind.annotation.RestController;
import com.springboot.example.customer.beans.User;
import com.springboot.example.exception.UserNotFountException;
import com.springboot.example.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Qualifier("CustomerServiceImpl")
	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@SuppressWarnings("deprecation")
	@GetMapping("/")
	public String home() {
		return "I am ready to serve : " + new Date().getDate();
	}
	@GetMapping(value = "/fname/{fname}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User findByFirstName(@PathVariable("fname") String firstName)
			throws UserNotFountException {
		return this.userService.findByFirstName(firstName);
	}

	@GetMapping(value = "/lname/{lname}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<?> findByLastName(@PathVariable("lname") String lastName) throws UserNotFountException {
		return this.userService.findByLastName(lastName);
	}
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User save(@RequestBody User user) throws Exception {
		return this.userService.save(user);
	}
	@GetMapping(value = "/showAll", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAllUsers() throws Exception {
		return this.userService.findAllUsers();
	}
}
