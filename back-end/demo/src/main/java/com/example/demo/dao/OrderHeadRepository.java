package com.example.demo.dao;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.OrderHead;

@Repository
public interface OrderHeadRepository extends JpaRepository<OrderHead, UUID>{

}
