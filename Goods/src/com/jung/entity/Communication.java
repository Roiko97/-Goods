package com.jung.entity;

import java.util.Arrays;
import java.util.List;

public class Communication extends Communicate{
	String title ;//标题名
	List<Reply> reply; //回复
	
	public Communication(String title, List<Reply> reply) {
		super();
		this.title = title;
		this.reply = reply;
	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public Communication() {
		super();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public List<Reply> getReply() {
		return reply;
	}
	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}
	@Override
	public String toString() {
		return "Communication [title=" + title + ", reply=" + reply + ", id=" + id + ", nickname=" + nickname
				+ ", releasetime=" + releasetime + ", pagecontect=" + pagecontect + "]";
	}
	
	
	
	
}
