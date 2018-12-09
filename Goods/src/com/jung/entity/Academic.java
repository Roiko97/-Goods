package com.jung.entity;

import java.util.Arrays;
import java.util.List;

public class Academic {
	int id ;//表示表格的id
	int types ;//1 代表 竞赛信息 2代表科研信息 3代表讲座信息
	String announcer ; //发布者
	String releasetime; //发布时间
	String pagecontect ; //发布内容
	int validity ; // 有效性 1代表有效 0代表无效
	List<DependAcademic> dependAcademic ; //依附内容
	int mark;
	
	public List<DependAcademic> getDependAcademic() {
		return dependAcademic;
	}
	public void setDependAcademic(List<DependAcademic> dependAcademic) {
		this.dependAcademic = dependAcademic;
	}
	
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public Academic(int id, int types, String announcer, String releasetime, String pagecontect, int validity,
			List<DependAcademic> dependAcademic, int mark) {
		super();
		this.id = id;
		this.types = types;
		this.announcer = announcer;
		this.releasetime = releasetime;
		this.pagecontect = pagecontect;
		this.validity = validity;
		this.dependAcademic = dependAcademic;
		this.mark = mark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Academic() {
		super();
	}
	
}
