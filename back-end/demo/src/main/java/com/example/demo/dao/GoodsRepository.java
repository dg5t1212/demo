package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Goods;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, UUID> {

	public List<Goods> findAll();

	public Optional<Goods> findById(UUID id);

}
