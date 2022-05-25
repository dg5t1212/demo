package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.SystemUserRepository;
import com.example.demo.entity.SystemUser;

@Service
public class SystemUserService {

	@Autowired
	private SystemUserRepository systemUserRepository;
	
	public List<SystemUser> findAll(){
		return this.systemUserRepository.findAll();
	}
	
	public SystemUser findByAccount(String account){
		SystemUser systemUser = null;
		List<SystemUser> systemUserList = this.systemUserRepository.findByAccount(account);
		if(systemUserList != null && systemUserList.size() > 0) {
			systemUser = systemUserList.get(0);
		}
		return systemUser;
	}
	
	
}
