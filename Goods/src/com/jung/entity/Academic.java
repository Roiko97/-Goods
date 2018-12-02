package com.jung.entity;

public class Academic {
	int types ; // 1 代表 竞赛信息 2代表科研信息 3代表讲座信息
	String announcer;  //发布者
	String releasetime; //发布时间
	String pagecontect;  //发布内容
	int validity;
	public Academic(int types, String announcer, String releasetime, String pagecontect, int validity) {
		super();
		this.types = types;
		this.announcer = announcer;
		this.releasetime = releasetime;
		this.pagecontect = pagecontect;
		this.validity = validity;
	}
	public Academic() {
		super();
	}
	public int getTypes() {
		return types;
	}
	public void setTypes(int types) {
		this.types = types;
	}
	public String getAnnouncer() {
		return announcer;
	}
	public void setAnnouncer(String announcer) {
		this.announcer = announcer;
	}
	public String getReleasetime() {
		return releasetime;
	}
	public void setReleasetime(String releasetime) {
		this.releasetime = releasetime;
	}
	public String getPagecontect() {
		return pagecontect;
	}
	public void setPagecontect(String pagecontect) {
		this.pagecontect = pagecontect;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	@Override
	public String toString() {
		return "Academic [types=" + types + ", announcer=" + announcer + ", releasetime=" + releasetime
				+ ", pagecontect=" + pagecontect + ", validity=" + validity + "]";
	} 
	
}
