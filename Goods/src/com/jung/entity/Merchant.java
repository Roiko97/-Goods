package com.jung.entity;

import java.util.List;

/**
 *  商户类 用于 周边、商户板块
 * @author jung
 *
 */
public class Merchant {
	String merchant_id; //商户唯一标识id
	String name; //商户名称
	String address; //商户地址
	String phone; //商户电话
	String info;//店铺介绍
	List<Food> food;  //商户经营食物
	String pic;
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getMerchant_id() {
		return merchant_id;
	}
	public void setMerchant_id(String merchant_id) {
		this.merchant_id = merchant_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Merchant() {
		super();
	}
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Merchant(String merchant_id, String name, String address, String phone, String info, List<Food> food,String pic) {
		super();
		this.merchant_id = merchant_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.info = info;
		this.food = food;
		this.pic = pic;
	}
	

	
}
