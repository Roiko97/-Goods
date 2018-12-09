package com.jung.entity;

public class Titleacademic {
	int id ;
	String name;
	String title;
	String stoptime;
	String pagecontect;
	int type;  //' 1 代表 竞赛信息 2代表科研信息 3代表讲座信息'
	
	@Override
	public String toString() {
		return "Titleacademic [id=" + id + ", name=" + name + ", title=" + title + ", stoptime=" + stoptime
				+ ", pagecontect=" + pagecontect + ", type=" + type + "]";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Titleacademic(int id, String name, String title, String stoptime, String pagecontect, int type) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.stoptime = stoptime;
		this.pagecontect = pagecontect;
		this.type = type;
	}
	public Titleacademic() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStoptime() {
		return stoptime;
	}
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}
	public String getPagecontect() {
		return pagecontect;
	}
	public void setPagecontect(String pagecontect) {
		this.pagecontect = pagecontect;
	}
	
	
	
}
