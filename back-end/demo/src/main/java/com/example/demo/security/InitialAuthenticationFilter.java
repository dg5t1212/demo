package com.example.demo.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.demo.entity.SystemUser;
import com.example.demo.utils.JWTUtils;
import com.example.demo.vo.SystemUserVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import io.jsonwebtoken.io.IOException;

@Component
public class InitialAuthenticationFilter extends OncePerRequestFilter {
	
	private static final Log log = LogFactory.getLog(InitialAuthenticationFilter.class);

	@Autowired
	private AuthenticationManager manager;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException, java.io.IOException {
		ObjectMapper mapper = new ObjectMapper();
		SystemUser systemUser = mapper.readValue(request.getInputStream(),SystemUser.class);
		String username = systemUser.getAccount();
		String password = systemUser.getPassword();
		Authentication a = new UsernamePasswordAuthentication(username, password);
		manager.authenticate(a);

		String jwt = JWTUtils.generateToken(username);
		
		SystemUserVO systemUserVO = new SystemUserVO();
		systemUserVO.setAccount(username);
		systemUserVO.setName(username);
		Gson gson = new Gson();
		String responseText = gson.toJson(systemUserVO, SystemUserVO.class);
		
		response.setHeader("Access-Control-Allow-Origin","http://localhost:8081");
		response.setHeader("Access-Control-Expose-Headers","Authorization");
		response.setHeader("Authorization", jwt);
		response.getWriter().print(responseText);

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		log.info("Request Path:"+request.getServletPath());
		return !request.getServletPath().equals("/auth/login");
	}
}
