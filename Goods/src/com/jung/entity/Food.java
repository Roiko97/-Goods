package com.jung.entity;

/**
 *  食物板块 用于存储食物信息
 * @author jung
 *
 */
public class Food {
	String merchant_id; // 店铺的唯一指定id
	String  name; //食物的名称
	String price; //食物的价格
	String info ; //食物的介绍信息
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
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
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "Food [merchant_id=" + merchant_id + ", name=" + name + ", price=" + price + ", info=" + info + "]";
	}
	public Food(String merchant_id, String name, String price, String info) {
		super();
		this.merchant_id = merchant_id;
		this.name = name;
		this.price = price;
		this.info = info;
	}
	public Food() {
		super();
	}
	
	
}
