package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.utils.MD5Utils;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	private UserDetailsServiceImp userDetailsServiceImp;
	
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String account = authentication.getName();
		String password = String.valueOf(authentication.getCredentials());
		UserDetails userDetails = userDetailsServiceImp.loadUserByUsername(account);
		
		String md5Password = MD5Utils.encrypt(password);
		
		if( account.equals(userDetails.getUsername()) && md5Password.equals(userDetails.getPassword()) ) {
			Authentication auth = new UsernamePasswordAuthenticationToken(account, password, userDetails.getAuthorities());
			return auth;
		}else {
			throw new BadCredentialsException("帳號或密碼錯誤");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthentication.class);
	}

}
