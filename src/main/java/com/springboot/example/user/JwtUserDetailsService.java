package com.springboot.example.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.example.auth.JwtTokenUtil;
import com.springboot.example.jwt.JwtRequest;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("rampapolu07".equals(username)) {
			String encodepass=  passwordEncoder.encode("password");
			return new User(username,encodepass,
					new ArrayList());
		} else
			throw new UsernameNotFoundException("User not found with username: " + username);

	}

}
