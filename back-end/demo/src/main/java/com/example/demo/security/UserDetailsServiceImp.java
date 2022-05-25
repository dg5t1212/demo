package com.example.demo.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.SystemUser;
import com.example.demo.service.SystemUserService;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService{

	private static final Log log = LogFactory.getLog(UserDetailsServiceImp.class);
	
	@Autowired
	private SystemUserService systemUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		SystemUser userEntity = this.systemUserService.findByAccount(username);
		if( null == userEntity ) {
			log.info("使用者資料不存在");
			throw new UsernameNotFoundException("使用者資料不存在");
		}
		
		UserDetails userDetails =  User.withUsername(username)
				.password(userEntity.getPassword())
				.authorities("backendUser")
				.accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
		
		return userDetails;
	}

}
