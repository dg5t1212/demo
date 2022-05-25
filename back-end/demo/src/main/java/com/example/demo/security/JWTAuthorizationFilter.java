package com.example.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.utils.JWTUtils;

//@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {
	
	private static final Log log = LogFactory.getLog(JWTAuthorizationFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = request.getHeader("Authorization");
			if( StringUtils.hasText(jwt) ) {
				jwt = jwt.replace("Bearer ", "");
			}else {
				throw new Exception("缺少JWT Token");
			}
			String username = "";
		
			username = JWTUtils.parserToken(jwt);
			Authentication auth = new UsernamePasswordAuthenticationToken(username, null, null);
			SecurityContextHolder.getContext().setAuthentication(auth);

			filterChain.doFilter(request, response);
		}catch (Exception e) {
			log.info(e.toString());
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		}
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		log.info("Request Path:"+request.getServletPath());
		return request.getServletPath().equals("/auth/login");
	}

}
