package com.example.demo.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "goods")
@ApiModel(description = "商品資料")
public class Goods {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id")
	@ApiModelProperty(value = "UUID")
	private UUID _id;
	
	@Column(name = "name")
	@ApiModelProperty(value = "商品名稱")
	private String name;
	
	
	@Column(name = "[desc]")
	@ApiModelProperty(value = "商品描述")
	private String desc;
	
	
	@Column(name = "upload_id")
	@JsonAlias(value = "upload_id")
	@JsonProperty(value = "upload_id")
	@ApiModelProperty(value = "uploadFile的外鍵")
	private UUID uploadId;

	public UUID get_id() {
		return _id;
	}

	public void set_id(UUID _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public UUID getUploadId() {
		return uploadId;
	}

	public void setUploadId(UUID uploadId) {
		this.uploadId = uploadId;
	}
	
	
}
