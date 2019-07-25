package com.iremenber.api.vo;

import java.math.BigDecimal;

public class Product {
	public Product() {
		
	}
	public Product(String name,BigDecimal price,String img) {
		this.name=name;
		this.price=price;
		this.img=img;
	}
	private BigDecimal price;
	private String name;
	private String img;
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
