package com.example.demo.vo;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "使用者資料")
public class SystemUserVO implements Serializable{
	
	private static final long serialVersionUID = -5184922426479397955L;
	
	@ApiModelProperty(value = "帳號")
	private String account;
	@ApiModelProperty(value = "名稱")
	private String name;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
