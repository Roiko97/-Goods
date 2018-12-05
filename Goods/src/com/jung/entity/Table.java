package com.jung.entity;

import java.util.List;

public class Table {
	String table_id; //表格id
	private int range;  //选中的商家信息
	private String Name;    //姓名
	private String Phone;   //电话
	private String Place;   //商家地址
	private String position;  //职位
	private String content;   //个人简介
	private String expand_1;  //拓展字段1
	private String expand_2;  //拓展字段2
	private String expand_3;  //拓展字段3
	private String expand_4;  //拓展字段4
	private String expand_5;  //拓展字段5
	private String expand_6;  //拓展字段6
	private String expand_7;  //拓展字段7
	private String expand_8;  //拓展字段8
	private String expand_9;  //拓展字段9
	
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public String getTable_id() {
		return table_id;
	}
	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getExpand_1() {
		return expand_1;
	}
	public void setExpand_1(String expand_1) {
		this.expand_1 = expand_1;
	}
	public String getExpand_2() {
		return expand_2;
	}
	public void setExpand_2(String expand_2) {
		this.expand_2 = expand_2;
	}
	public String getExpand_3() {
		return expand_3;
	}
	public void setExpand_3(String expand_3) {
		this.expand_3 = expand_3;
	}
	public String getExpand_4() {
		return expand_4;
	}
	public void setExpand_4(String expand_4) {
		this.expand_4 = expand_4;
	}
	public String getExpand_5() {
		return expand_5;
	}
	public void setExpand_5(String expand_5) {
		this.expand_5 = expand_5;
	}
	public String getExpand_6() {
		return expand_6;
	}
	public void setExpand_6(String expand_6) {
		this.expand_6 = expand_6;
	}
	public String getExpand_7() {
		return expand_7;
	}
	public void setExpand_7(String expand_7) {
		this.expand_7 = expand_7;
	}
	public String getExpand_8() {
		return expand_8;
	}
	public void setExpand_8(String expand_8) {
		this.expand_8 = expand_8;
	}
	public String getExpand_9() {
		return expand_9;
	}
	public void setExpand_9(String expand_9) {
		this.expand_9 = expand_9;
	}
	@Override
	public String toString() {
		return "Table [table_id=" + table_id + ", Name=" + Name + ", Phone=" + Phone + ", Place=" + Place
				+ ", position=" + position + ", content=" + content + ", expand_1=" + expand_1 + ", expand_2="
				+ expand_2 + ", expand_3=" + expand_3 + ", expand_4=" + expand_4 + ", expand_5=" + expand_5
				+ ", expand_6=" + expand_6 + ", expand_7=" + expand_7 + ", expand_8=" + expand_8 + ", expand_9="
				+ expand_9 + "]";
	}
	public Table(String table_id, String name, String phone, String place, String position, String content,
			String expand_1, String expand_2, String expand_3, String expand_4, String expand_5, String expand_6,
			String expand_7, String expand_8, String expand_9) {
		super();
		this.table_id = table_id;
		Name = name;
		Phone = phone;
		Place = place;
		this.position = position;
		this.content = content;
		this.expand_1 = expand_1;
		this.expand_2 = expand_2;
		this.expand_3 = expand_3;
		this.expand_4 = expand_4;
		this.expand_5 = expand_5;
		this.expand_6 = expand_6;
		this.expand_7 = expand_7;
		this.expand_8 = expand_8;
		this.expand_9 = expand_9;
	}
	public Table() {
		// TODO Auto-generated constructor stub
	}
	
	
}
