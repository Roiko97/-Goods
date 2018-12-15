package com.jung.entity;

import java.util.List;

public class StudentSend extends Table{
	int target;          //目标id
	private String name;    //姓名
	private String phone;   //电话
	private String age;  //年龄
	private String sex;  //性别
	private String content;   //个人简介
	
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "StudentSend [target=" + target + ", name=" + name + ", phone=" + phone + ", age=" + age + ", sex=" + sex
				+ ", content=" + content + "]";
	}
	public StudentSend(int id, String title, String shopname, String position, String address, String linkman,
			String phone, String content, int target, String name, String phone2, String age, String sex,
			String content2) {
		super(id, title, shopname, position, address, linkman, phone, content);
		this.target = target;
		this.name = name;
		phone = phone2;
		this.age = age;
		this.sex = sex;
		content = content2;
	}
	public StudentSend() {
		
	}
	
	
}