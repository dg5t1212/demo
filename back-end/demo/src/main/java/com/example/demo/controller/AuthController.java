package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.SystemUser;
import com.example.demo.vo.SystemUserVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(tags = "登入")
@RestController
public class AuthController {
	
	@ApiOperation(value = "Login 用戶登入系統並在Response Header Authorization取得token", response = SystemUserVO.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "成功", response = SystemUserVO.class),
			@ApiResponse(code = 401, message = ""),
			@ApiResponse(code = 500, message = "系統錯誤")})
	@RequestMapping(path = "/auth/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SystemUserVO> login(@RequestBody SystemUser systemUser){
		try {
			SystemUserVO systemUserVO = new SystemUserVO();
			systemUserVO.setAccount(systemUser.getAccount());
			systemUserVO.setName(systemUser.getAccount());
			return new ResponseEntity<>(systemUserVO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
