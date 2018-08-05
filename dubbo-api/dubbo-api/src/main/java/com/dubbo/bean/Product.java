package com.dubbo.bean;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String name;

	private Double price;

	private String category;
	
	private String brand;
	
	public String getId() {
		return id;
	}
	public Product setId(String id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	public Double getPrice() {
		return price;
	}
	public Product setPrice(Double price) {
		this.price = price;
		return this;
	}
	public String getCategory() {
		return category;
	}
	public Product setCategory(String category) {
		this.category = category;
		return this;
	}
	public String getBrand() {
		return brand;
	}
	public Product setBrand(String brand) {
		this.brand = brand;
		return this;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", category=" + category + ", brand="
				+ brand + "]";
	}
}
