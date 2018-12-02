package com.jung.entity;

import java.math.BigInteger;
/**
 *  ��¼������Ϣģ��
 * @author jung
 *
 */
public class Note {
	private String title ;//������
	private String author; //������
	private String releasetime ;//����ʱ��
	private String pagecontect; //��������
	private BigInteger readingvolume;//���ʴ���
	private int range;//��ȡ���ֵķ�Χ
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
