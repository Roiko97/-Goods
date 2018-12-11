package com.jung.entity;

import java.util.List;

public class Table {
	int id;
	String title;   //标题
	String shopname;    //商户名
	String position;   //商户招聘职位
	String address;   //商家地址
	String linkman;  //联系人
	String phone;     //电话
	String content;   //个人简介
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Table [id=" + id + ", title=" + title + ", shopname=" + shopname + ", position=" + position
				+ ", address=" + address + ", linkman=" + linkman + ", phone=" + phone + ", content=" + content + "]";
	}
	public Table(int id, String title, String shopname, String position, String address, String linkman, String phone,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.shopname = shopname;
		this.position = position;
		this.address = address;
		this.linkman = linkman;
		this.phone = phone;
		this.content = content;
	}
	public Table() {
		super();
	}
	
	
	

	
}
