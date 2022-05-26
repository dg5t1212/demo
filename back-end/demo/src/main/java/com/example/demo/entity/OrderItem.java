package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "order_item")
@ApiModel(description = "訂單明細")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	@ApiModelProperty(value = "UUID")
	private UUID _id;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "head_id")
	@ApiModelProperty(value = "主檔UUID")
	private OrderHead orderHead;
	
	@Column(name = "index_no")
	@ApiModelProperty(value = "項次")
	private Long indexNo;
	
	@Column(name = "goods_name")
	@ApiModelProperty(value = "商品名稱")
	private String goodsName;
	
	@Column(name = "amount")
	@ApiModelProperty(value = "單項總額")
	private Long amount;
	
	@Column(name = "qty")
	@ApiModelProperty(value = "數量")
	private Long qty;

	public UUID get_id() {
		return _id;
	}

	public void set_id(UUID _id) {
		this._id = _id;
	}

	public OrderHead getOrderHead() {
		return orderHead;
	}

	public void setOrderHead(OrderHead orderHead) {
		this.orderHead = orderHead;
	}

	public Long getIndexNo() {
		return indexNo;
	}

	public void setIndexNo(Long indexNo) {
		this.indexNo = indexNo;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}
}
