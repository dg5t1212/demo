package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderHeadRepository;
import com.example.demo.dao.OrderItemRepository;
import com.example.demo.entity.OrderHead;
import com.example.demo.entity.OrderItem;
import com.example.demo.vo.OrderInfo;

@Service
public class OrderService {
	
	@Autowired
	private OrderHeadRepository orderHeadRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Transactional
	public OrderHead createOrder(String name, List<OrderInfo> orderInfoList) {
		List<OrderItem> orderItemList = new ArrayList<>();
		OrderHead orderHead = new OrderHead();
		orderHead.setCustomerName(name);
		
		
		long totalAmount = 0;
		long indexNo = 1;
		
		for(OrderInfo orderInfo : orderInfoList) {
			long amount = orderInfo.getPrice() * orderInfo.getQty();
			totalAmount += amount;
			OrderItem orderItem = new OrderItem();
			orderItem.setAmount(amount);
			orderItem.setGoodsName(orderInfo.getName());
			orderItem.setIndexNo(indexNo++);
			orderItem.setQty(orderInfo.getQty());
			orderItem.setOrderHead(orderHead);
			
			orderItemList.add(orderItem);
		}
		
		orderHead.setTotalAmount(totalAmount);
		orderHead.setOrderItemList(orderItemList);
		
		return this.orderHeadRepository.save(orderHead);
	}
}
