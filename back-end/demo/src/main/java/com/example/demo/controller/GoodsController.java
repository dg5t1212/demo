package com.example.demo.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Goods;
import com.example.demo.service.GoodsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "商品")
@RestController
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	
	@ApiOperation(value = "取得所有商品", response = Goods.class, responseContainer = "List")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = Goods.class, responseContainer = "List"),
			@ApiResponse(code = 403, message = "權限不足"),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/goods", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<Goods>> searchAllGoods() {
		try {
			Iterable<Goods> allGoods = this.goodsService.findAllGoods();
			return new ResponseEntity<>(allGoods, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
	@ApiOperation(value = "取得指定商品")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = Goods.class),
			@ApiResponse(code = 403, message = "權限不足"),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/goods/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Goods> searchGoods(
			@PathVariable(value = "id") UUID id) {
		try {
			Goods goods = this.goodsService.findById(id);
			return new ResponseEntity<>(goods, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "新增商品")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = Goods.class),
			@ApiResponse(code = 403, message = "權限不足"),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/goods/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Goods> createGoods(
			@RequestBody Goods goods) {
		try {
			Goods newGoods = this.goodsService.createGoods(goods);
			return new ResponseEntity<>(newGoods, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "更新商品")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = Goods.class),
			@ApiResponse(code = 403, message = "權限不足"),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/goods/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Goods> updateGoods(
			@RequestBody Goods goods, 
			@PathVariable(value = "id") UUID id) {
		try {
			Goods newGoods = this.goodsService.updateById(id, goods);
			return new ResponseEntity<>(newGoods, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@ApiOperation(value = "刪除商品")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = Void.class),
			@ApiResponse(code = 403, message = "權限不足"),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/goods/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteGoods(
			@PathVariable(value = "id") UUID id) {
		try {
			this.goodsService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
