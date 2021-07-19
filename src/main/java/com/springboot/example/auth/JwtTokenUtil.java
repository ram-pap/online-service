package com.springboot.example.auth;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.springboot.example.jwt.JwtRequest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
@Component
public class JwtTokenUtil {
	private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60l;

	@Value("${jwt.secret}")
	private String jwtSecret;

	public String getUserNameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);

	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);

	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	private <T> T getClaimFromToken(String token, Function<Claims, T> resolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return resolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
	}

	public String generateToken(UserDetails request) {
		System.out.println("UserAuthentication::generateToken ");
		Map<String, Object> claims = new HashMap<String, Object>();

		return doGenerateToken(claims, request.getUsername());

	}

	private String doGenerateToken(Map<String, Object> claims, String userName) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(claims).setSubject(userName).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();

	}
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUserNameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
