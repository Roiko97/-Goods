package com.jung.entity;

import java.util.List;

public class Send extends Table{
	String title;   //标题
	List<StudentSend> students; //学生提交的应聘表格
	
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
	public List<StudentSend> getStudents() {
		return students;
	}
	public void setStudents(List<StudentSend> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Send [title=" + title + ", students=" + students + ", id=" + table_id + ", shopname=" + shopname
				+ ", position=" + position + ", address=" + address + ", linkman=" + linkman + ", phone=" + phone
				+ ", content=" + content + "]";
	}
	
	public Send() {
		super();
	}
	
	
	
}