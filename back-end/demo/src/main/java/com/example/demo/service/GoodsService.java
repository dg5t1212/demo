package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.GoodsRepository;
import com.example.demo.entity.Goods;

@Service
public class GoodsService {

	@Autowired
	private GoodsRepository goodsRepository;
	
	public List<Goods> findAllGoods(){
		return this.goodsRepository.findAll();
	}
	
	public Goods findById(UUID id){
		return this.goodsRepository.findById(id).orElse(null);
	}
	
	public Goods createGoods(Goods goods) {
		return this.goodsRepository.save(goods);
	}
	
	public Goods updateById(UUID id, Goods goods) {
		Optional<Goods> isExistGoods = this.goodsRepository.findById(id);
		if( !isExistGoods.isPresent() ) {
			return null;
		}
		Goods oriGoods = isExistGoods.get();
		oriGoods.setDesc(goods.getDesc());
		oriGoods.setName(goods.getName());
		this.goodsRepository.save(oriGoods);
		return oriGoods;
	}
	
	public void deleteById(UUID id) {
		this.goodsRepository.deleteById(id);
	}
	
}
