package com.bootstrap.springboot.auth;
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

import com.bootstrap.springboot.service.JwtUserDetailsService;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

@Autowired
private JwtUserDetailsService jwtUserDetailsService;

@Autowired
private JwtTokenUtil jwtTokenUtil;

@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
throws ServletException, IOException {
	final String requestTokenHeader = request.getHeader("Authorization");

String username = null;
String jwtToken = null;

// JWT Token está no form "Bearer token". Remova a palavra Bearer e pegue somente o Token
if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
	jwtToken = requestTokenHeader.substring(7);
try {
	username = jwtTokenUtil.getUsernameFromToken(jwtToken);
} catch (IllegalArgumentException e) {
	System.out.println("Unable to get JWT Token");
} catch (Exception e) {
	System.out.println("JWT Token has expired");
}
} else {
	logger.warn("JWT Token does not begin with Bearer String");
}

// Tendo o token, valide o.
if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	UserDetails userDetails = this.jwtUserDetailsService.loadUserByUsername(username);



if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
	UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
			userDetails, null, userDetails.getAuthorities());
	usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
}
chain.doFilter(request, response);
}

}