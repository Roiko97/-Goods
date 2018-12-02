package com.jung.entity;

public class LostAndFound extends Communicate{
	String title ;//标题名
	int solve ; //是否解决
	@Override
	public String toString() {
		return "LostAndFound [title=" + title + ", nickname=" + nickname + ", releasetime=" + releasetime
				+ ", pagecontect=" + pagecontect + ", solve=" + solve + "]";
	}
	public LostAndFound(String title, String nickname, String releasetime, String pagecontect, int solve) {
		super();
		this.title = title;
		this.nickname = nickname;
		this.releasetime = releasetime;
		this.pagecontect = pagecontect;
		this.solve = solve;
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
	public int getSolve() {
		return solve;
	}
	public void setSolve(int solve) {
		this.solve = solve;
	}
	public LostAndFound() {
		super();
	}
	
}
