package com.jung.entity;

public class Application {
	int id ;
	int mark; //表示该表格的id
	String content ;
	String nickname;
	
	
	public Application(int id, int mark, String content, String nickname) {
		super();
		this.id = id;
		this.mark = mark;
		this.content = content;
		this.nickname = nickname;
	}
	
	public Application(int mark, String nickname) {
		super();
		this.mark = mark;
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Application() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
