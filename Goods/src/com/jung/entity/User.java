package com.jung.entity;

import java.util.Date;

public class User {
    private Integer id; //编号
    private String username; //账号
    private String userpass; //密码
    private String nickname; //昵称
    private Integer age; //年龄
    private String gender; //性别
    private String phone; //电话
    private String email; //邮箱
    private Date createTime; //创建时间
    private Date lastLogin; //最后登录时间
    private Integer userStatus;  //用户状态
    private Integer jurisdiction; //用户权限

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", nickname='" + nickname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", createTime=" + createTime +
                ", lastLogin=" + lastLogin +
                ", userStatus=" + userStatus +
                ", jurisdiction=" + jurisdiction +
                '}';
    }

    public User(String username, String userpass) {
        this.username = username;
        this.userpass = userpass;
    }

	public User(Integer id, String username, String userpass, String nickname, Integer age, String gender, String phone,
			String email, Date createTime, Date lastLogin, Integer userStatus, Integer jurisdiction) {
		super();
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.nickname = nickname;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.createTime = createTime;
		this.lastLogin = lastLogin;
		this.userStatus = userStatus;
		this.jurisdiction = jurisdiction;
	}

	public User() {
		super();
	}

	public User(String username, String userpass, String nickname, String phone) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.nickname = nickname;
		this.phone = phone;
	}

	public User(String nickname, String phone, String email) {
		super();
		this.nickname = nickname;
		this.phone = phone;
		this.email = email;
	}
    
}
