package com.jung.entity;

import java.util.List;

public class Table {
	int table_id;
	String title;   //����
	String shopname;    //�̻���
	String position;   //�̻���Ƹְλ
	String address;   //�̼ҵ�ַ
	String linkman;  //��ϵ��
	String phone;     //�绰
	String content;   //���˼��
	
	
	
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int table_id) {
		this.table_id = table_id;
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
		return "Table [table_id=" + table_id + ", title=" + title + ", shopname=" + shopname + ", position=" + position
				+ ", address=" + address + ", linkman=" + linkman + ", phone=" + phone + ", content=" + content + "]";
	}
	public Table(int table_id, String title, String shopname, String position, String address, String linkman,
			String phone, String content) {
		super();
		this.table_id = table_id;
		this.title = title;
		this.shopname = shopname;
		this.position = position;
		this.address = address;
		this.linkman = linkman;
		this.phone = phone;
		this.content = content;
	}
	public Table() {
		
	}
	
	
}