package com.springboot.example.jwt;

public class JwtResponse {
	
	private String jwtToken;
	
	public JwtResponse() {
		
	}

	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public JwtResponse setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
		return this;
	}
	
	

}
