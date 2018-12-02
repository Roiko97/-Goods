package com.jung.entity;

import java.math.BigInteger;
/**
 *  记录发布信息模块
 * @author jung
 *
 */
public class Note {
	private String title ;//标题名
	private String author; //作者名
	private String releasetime ;//发布时间
	private String pagecontect; //发布内容
	private BigInteger readingvolume;//访问次数
	private int range;//读取数字的范围
	private int rangeto;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
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
	public BigInteger getReadingvolume() {
		return readingvolume;
	}
	public void setReadingvolume(BigInteger readingvolume) {
		this.readingvolume = readingvolume;
	}
	public Note() {
		super();
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getRangeto() {
		return rangeto;
	}
	public void setRangeto(int rangeto) {
		this.rangeto = rangeto;
	}
	public Note(String title, String author, String releasetime, String pagecontect, BigInteger readingvolume,
			int range, int rangeto) {
		super();
		this.title = title;
		this.author = author;
		this.releasetime = releasetime;
		this.pagecontect = pagecontect;
		this.readingvolume = readingvolume;
		this.range = range;
		this.rangeto = rangeto;
	}
	@Override
	public String toString() {
		return "Note [title=" + title + ", author=" + author + ", releasetime=" + releasetime + ", pagecontect="
				+ pagecontect + ", readingvolume=" + readingvolume + ", range=" + range + ", rangeto=" + rangeto + "]";
	}
	
	
}
