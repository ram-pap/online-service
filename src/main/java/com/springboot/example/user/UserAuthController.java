package com.springboot.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.auth.JwtTokenUtil;
import com.springboot.example.jwt.JwtRequest;
import com.springboot.example.jwt.JwtResponse;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserAuthController {
	
	@Autowired
	private JwtUserDetailsService userAuthentication;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@PostMapping("/login")
	public ResponseEntity authenticate(@RequestBody JwtRequest request) throws Exception {
		System.out.println("Authentication controller........");
		String encodedPassword = passwordEncoder.encode(request.getPassword());
		System.out.println(encodedPassword);
		authenticate(request.getUserName(),request.getPassword());
        UserDetails userDetails =userAuthentication.loadUserByUsername(request.getUserName());
		 String token  =jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse().setJwtToken(token));  
	}
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
}
