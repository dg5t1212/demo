package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.OrderHead;
import com.example.demo.service.OrderService;
import com.example.demo.vo.OrderInfo;

import io.swagger.annotations.Api;

@Api(tags = "訂單")
@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path = "/order", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderHead> createOrder(
			@RequestBody List<OrderInfo> orderInfoList){
		String username = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			OrderHead newOrder = this.orderService.createOrder(username, orderInfoList);
			return new ResponseEntity<>(newOrder, HttpStatus.OK);
		} catch (Exception e) {
			e.toString();
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
