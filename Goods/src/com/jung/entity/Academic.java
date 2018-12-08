package com.jung.entity;

import java.util.Arrays;
import java.util.List;

public class Academic {
	int id ;//��ʾ����id
	int types ;//1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ
	String announcer ; //������
	String releasetime; //����ʱ��
	String pagecontect ; //��������
	int validity ; // ��Ч�� 1������Ч 0������Ч
	List<DependAcademic> dependAcademic ; //��������

	
	public List<DependAcademic> getDependAcademic() {
		return dependAcademic;
	}
	public void setDependAcademic(List<DependAcademic> dependAcademic) {
		this.dependAcademic = dependAcademic;
	}
	public Academic(int id, int types, String announcer, String releasetime, String pagecontect, int validity,
			List<DependAcademic> dependAcademic) {
		super();
		this.id = id;
		this.types = types;
		this.announcer = announcer;
		this.releasetime = releasetime;
		this.pagecontect = pagecontect;
		this.validity = validity;
		this.dependAcademic = dependAcademic;
	}
	@Override
	public String toString() {
		return "Academic [id=" + id + ", types=" + types + ", announcer=" + announcer + ", releasetime=" + releasetime
				+ ", pagecontect=" + pagecontect + ", validity=" + validity + ", dependAcademic=" + dependAcademic
				+ "]";
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
