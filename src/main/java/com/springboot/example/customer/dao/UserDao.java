
package com.springboot.example.customer.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.springboot.example.customer.beans.User;


@Repository
public interface UserDao extends MongoRepository<User, String> {

	public User findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);
	public User saveUser(User user);

}
