package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.SystemUser;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, UUID>{

	public List<SystemUser> findAll();
	
	public List<SystemUser> findByAccount(String account);
	
	public Optional<SystemUser> findSystemuserByAccount(String account);
	
}
