package com.iremenber.api.vo;

import java.util.List;
/**
 * 	商家
 * @author zhangming
 *
 */
public class Mall {
	private Mall() {
		
	}
	private Mall(String name,List<Product> products) {
		this.name = name;
		this.products = products;
	}
	private String name;
	private List<Product> products;
	public static Mall getJDMall(List<Product> products) {
		return new Mall("京东",products);
	}
	public static Mall getTMall(List<Product> products) {
		return new Mall("天猫",products);
	}
	public static Mall getTMall() {
		return null;
		
	}
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
