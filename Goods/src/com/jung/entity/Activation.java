package com.jung.entity;

import java.util.Date;


public class Activation {
	private String teacher_id; //教师工号
	private String teacher_password; //教师密码
    private Integer teacher_activate_status; //教师激活状态
    private String student_id; //学生工号
    private String student_password; //学工密码
    private Integer student_activate_status; //学生激活状态
    private String activation; //激活码
    private Integer activate_status; //商家、组织负责人激活状态
	public String getTeacher_id() {
		return teacher_id;
	}
	public String getTeacher_password() {
		return teacher_password;
	}
	public void setTeacher_password(String teacher_password) {
		this.teacher_password = teacher_password;
	}
	public String getStudent_password() {
		return student_password;
	}
	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}
	public void setTeacher_id(String teacher_id) {
		this.teacher_id = teacher_id;
	}
	public Integer getTeacher_activate_status() {
		return teacher_activate_status;
	}
	public void setTeacher_activate_status(Integer teacher_activate_status) {
		this.teacher_activate_status = teacher_activate_status;
	}
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public Integer getStudent_activate_status() {
		return student_activate_status;
	}
	public void setStudent_activate_status(Integer student_activate_status) {
		this.student_activate_status = student_activate_status;
	}
	public String getActivation() {
		return activation;
	}
	public void setActivation(String activation) {
		this.activation = activation;
	}
	public Integer getActivate_status() {
		return activate_status;
	}
	public void setActivate_status(Integer activate_status) {
		this.activate_status = activate_status;
	}
	@Override
	public String toString() {
		return "Activation [teacher_id=" + teacher_id + ", teacher_activate_status=" + teacher_activate_status
				+ ", student_id=" + student_id + ", student_activate_status=" + student_activate_status
				+ ", activation=" + activation + ", activate_status=" + activate_status + "]";
	}
	public Activation(String teacher_id, Integer teacher_activate_status, String student_id,
			Integer student_activate_status, String activation, Integer activate_status) {
		super();
		this.teacher_id = teacher_id;
		this.teacher_activate_status = teacher_activate_status;
		this.student_id = student_id;
		this.student_activate_status = student_activate_status;
		this.activation = activation;
		this.activate_status = activate_status;
	}
	public Activation(String student_id) {
		super();
		this.student_id = student_id;
	}
	public Activation() {
		super();
	}
	
	

	
}
	