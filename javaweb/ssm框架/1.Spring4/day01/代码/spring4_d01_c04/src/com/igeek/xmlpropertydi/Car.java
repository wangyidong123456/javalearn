package com.igeek.xmlpropertydi;

public class Car {
	private Integer id;
	private String name;
	private Double price;
	
	
	
	
	public Car(Integer id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}



	public Integer getId() {
		return id;
	}
	
	
	
	
	
	public String getName() {
		return name;
	}



	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	
}
