package com.jung.entity;

public class Reply extends Communicate{
	int target; //Ä¿±êÌû×Óid
	public Reply() {
		super();
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
	
	public Reply(int target,String nickname,String releasetime,String pagecontect) {
		super(nickname,releasetime,pagecontect);
		this.target = target;
	}
	public int getTarget() {
		return target;
	}
	public void setTarget(int target) {
		this.target = target;
	}
	@Override
	public String toString() {
		return "Reply [target=" + target + ", nickname=" + nickname + ", releasetime=" + releasetime + ", pagecontect="
				+ pagecontect + "]";
	}
	
	
}

