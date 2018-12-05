package com.jung.entity;

import java.util.List;

public class Send {
	String table_id; //表格id
	String name; //商家名
	String position; //商家招聘职位
	String info ; //商家兼职信息
	List<Table> students; //学生提交的应聘表格
	
	public String getTable_id() {
		return table_id;
	}
	public void setTable_id(String table_id) {
		this.table_id = table_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<Table> getStudents() {
		return students;
	}
	public void setStudents(List<Table> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Send [table_id=" + table_id + ", name=" + name + ", position=" + position + ", info=" + info
				 + ", students=" + students + "]";
	}
	public Send(String table_id, String name, String position, String info, List<Table> students) {
		super();
		this.table_id = table_id;
		this.name = name;
		this.position = position;
		this.info = info;
		this.students = students;
	}
	
}
