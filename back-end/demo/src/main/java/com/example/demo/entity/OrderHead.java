package com.example.demo.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "order_head")
@ApiModel(description = "訂單主檔")
public class OrderHead {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	@ApiModelProperty(value = "UUID")
	private UUID _id;
	
	@Column(name = "total_Amount")
	@ApiModelProperty(value = "總金額")
	private Long totalAmount;
	
	@Column(name = "customer_name")
	@ApiModelProperty(value = "客戶名稱")
	private String customerName;
	
	@OneToMany(mappedBy = "orderHead", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//	@JoinColumn(name = "_id")
	@OrderBy("index_no asc")
	private List<OrderItem> orderItemList;

	public UUID get_id() {
		return _id;
	}

	public void set_id(UUID _id) {
		this._id = _id;
	}
	
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Long totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
}
