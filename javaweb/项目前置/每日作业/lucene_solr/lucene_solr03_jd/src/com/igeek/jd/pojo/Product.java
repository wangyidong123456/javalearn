package com.igeek.jd.pojo;

public class Product {
	private String pid;
	private String name;
	private String price;
	private String picture;

	public Product() {
		super();
	}

	public Product(String pid, String name, String price, String picture) {
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.picture = picture;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
}
