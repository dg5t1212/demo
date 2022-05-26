package com.example.demo.vo;

import java.io.Serializable;

public class OrderInfo implements Serializable{
	
	private static final long serialVersionUID = -2442571495731491245L;

	private String name;
	
	private Long price;
	
	private Long qty;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	
}
