package com.jung.entity;

public class DependAcademic {
	int mark; //����id
	String description;//�ֶ�˵��
	String content; //�ֶ�����
	@Override
	public String toString() {
		return "DependAcademic [mark=" + mark + ", description=" + description + ", content=" + content + "]";
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public DependAcademic(int mark, String description, String content) {
		super();
		this.mark = mark;
		this.description = description;
		this.content = content;
	}
	public DependAcademic() {
		super();
	}
	
	
}
