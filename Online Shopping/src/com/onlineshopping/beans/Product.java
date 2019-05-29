package com.onlineshopping.beans;

public class Product {

	private String code;
	private String name;
	private float amount;

	public Product() {
	}
	
	public Product(String code, String name, float amount) {
		this.code = code;
		this.name = name;
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
