package com.igeek.springmvc.pojo;

import java.util.Date;

/**
 * 商品
 * @author cp
 *
 */
public class Item {
	
	private Integer id;
	
	private String name;
	private Double price;
	private Date createtime;
	private String detail;
	
	
	
	public Item(String name, Double price, Date createtime, String detail) {
		this.name = name;
		this.price = price;
		this.createtime = createtime;
		this.detail = detail;
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
}
