package com.springboot.example.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.springboot.example.auth.JwtTokenUtil;
import com.springboot.example.user.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserAuthenticationService;

	@Autowired
	private JwtTokenUtil jwtTokenUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String username = null;
		String jwtToken = null;
		String requestHeader = request.getHeader("Authorization");
		if (requestHeader != null && requestHeader.startsWith("Bearer")) {
			jwtToken = requestHeader.substring(7);
			try {
				username = jwtTokenUtils.getUserNameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		} else {
			logger.warn("JWT Token does not begin with Bearer String");
		}
		// Once we get the token validate it.

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			UserDetails userdetails = this.jwtUserAuthenticationService.loadUserByUsername(username);
			// if token is valid configure Spring Security to manually set
			// authentication

			if (jwtTokenUtils.validateToken(jwtToken, userdetails)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						userdetails, null, userdetails.getAuthorities());
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}

		}
		filterChain.doFilter(request, response);
	}

}
