CREATE DATABASE sedb;
CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY COMMENT '用户编号',
	username VARCHAR(50) NOT NULL COMMENT '登录账号',
	userpass VARCHAR(50) NOT NULL COMMENT '登录密码',
	nickname VARCHAR(50) COMMENT '用户昵称',
	age INT COMMENT '用户年龄',
	gender VARCHAR(5) COMMENT '用户性别',
	phone VARCHAR(13) COMMENT '联系方式',
	email VARCHAR(20) COMMENT '用户邮箱',
	createTime DATETIME COMMENT '创建时间',
	lastLogin DATETIME COMMENT '最后登录时间',
	userStatus INT COMMENT '用户状态 0 正常 1 锁定',
    jurisdiction  INT COMMENT '用户权限'
) DEFAULT CHARSET 'utf8';

CREATE TABLE note(
	id INT auto_increment primary key comment '内容编号',
    title varchar(200) not null comment '标题名',
    author varchar(50) not null comment '作者名',
    releasetime varchar(50) not null comment '发布时间',
    pagecontect varchar(16800) not null comment '发布内容',
    readingvolume bigint comment '访问次数'
)DEFAULT CHARSET 'utf8';

CREATE TABLE  activate(
	activation VARCHAR(30) NOT NULL PRIMARY KEY COMMENT '激活码',
	activate_type VARCHAR(50) NOT NULL COMMENT '激活类型',
	activate_status INT NOT NULL DEFAULT 0 COMMENT '激活状态 0未激活 1激活 '
)DEFAULT CHARSET 'utf8';

CREATE TABLE student_authentication(
	student_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '学生学号',
	student_password VARCHAR(50) NOT NULL  COMMENT '学生密码，默认身份证后6位',
	 student_activate_status INT NOT NULL DEFAULT 0 COMMENT '学生激活状态 默认0未激活 1激活'
)DEFAULT CHARSET 'utf8';

CREATE TABLE teacher_authentication(
	teacher_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '教师工号',
	teacher_password VARCHAR(50) NOT NULL  COMMENT '教师密码，默认身份证后6位',
	teacher_activate_status INT NOT NULL DEFAULT 0 COMMENT '教师激活状态 默认0未激活 1激活'
)DEFAULT CHARSET 'utf8';

CREATE TABLE Merchant(
	id int auto_increment primary key comment '自增长id',
    merchant_id varchar(10) not null comment '商铺唯一标识号',
    name varchar(50) not null comment '商铺名称',
    address varchar(5000) comment '商铺地址',
    phone varchar(20) comment '商铺电话',
    info varchar(10000) comment '店铺介绍',
    near int default 0 comment '是否是周边商户，0表示是，1表示不是'
)DEFAULT CHARSET 'utf8';

CREATE TABLE food(
	id int auto_increment primary key comment '自增长id',
	merchant_id varchar(10) not null comment '商铺唯一标识号',
	name varchar(2000) not null comment '食物名称',
	price varchar(10) not null comment '食物价格',
	info varchar(10000) comment '食品描述'
)DEFAULT CHARSET 'utf8';

CREATE TABLE attractions(
	id int auto_increment primary key comment '自增长id',
	name varchar(50) not null comment '景点名称',
    address varchar(5000) comment '景点地址',
	price varchar(10) comment '游玩价格',
	info varchar(10000) comment '景点介绍'
)DEFAULT CHARSET 'utf8';

CREATE TABLE LostAndFound(
	id int auto_increment primary key comment '自增长id',
	title varchar(50) not null comment '标题名',
	nickname VARCHAR(50) COMMENT '发布者昵称',
	releasetime varchar(50) not null comment '发布时间',
    pagecontect varchar(10000) not null comment '发布内容',
    solve int not null default 0 comment '是否解决 默认未解决为0 解决为1'
)DEFAULT CHARSET 'utf8';

CREATE TABLE communication(
	id int auto_increment primary key comment '自增长id',
	title varchar(100) not null comment '标题名',
	nickname VARCHAR(50) COMMENT '发布者昵称',
	releasetime varchar(50) not null comment '发布时间',
    pagecontect varchar(10000) not null comment '发布内容'
)default charset 'utf8';

CREATE TABLE reply(
	id int auto_increment primary key comment '自增长id',
	target int not null comment '回复目标帖id',
	nickname VARCHAR(50) COMMENT '回复者昵称',
	releasetime varchar(50) not null comment '回复时间',
    pagecontect varchar(10000) not null comment '回复者内容'
)default charset 'utf8';

CREATE TABLE titleacademic(
	id int auto_increment primary key comment '自增长id',
    name varchar(50) not null comment '姓名',
    title varchar(1000) not null comment '标题',
	stoptime varchar(50) not null comment '截止时间',
	pagecontect varchar(15000) not null comment '内容',
	types int not null comment ' 1 代表 竞赛信息 2代表科研信息 3代表讲座信息'
)default charset 'utf8';

CREATE TABLE academic(
	id int auto_increment primary key comment '自增长id',
    mark int comment '关联id',
    types int not null comment ' 1 代表 竞赛信息 2代表科研信息 3代表讲座信息',
    announcer varchar(50) not null comment ' 发布者',
    releasetime varchar(50) not null comment '发布时间',
	pagecontect varchar(15000) comment '发布内容',
	validity int not null default 1 comment '有效性 1代表有效 0代表无效'
)default charset 'utf8';

create table dependacademic(
	id int auto_increment primary key comment '自增长id',
    mark int not null comment '关联id',
    description varchar(50) not null comment '说明',
    content varchar(200) not null comment '内容'
)default charset 'utf8';

create table application(
	id int auto_increment primary key comment '自增长id',
    nickname varchar(50) not null comment '回复者',
    mark int not null comment '关联id',
     content varchar(200) not null comment '内容'
)default charset 'utf8';

create table StudentSend(
	table_id INT auto_increment PRIMARY KEY COMMENT '表格编号',
	target int not null comment '回复目标帖id',
	name varchar(100) not null comment'学生姓名',
	phone varchar(1000) not null comment'学生电话',
	age varchar(10) not null comment '年龄',
	sex varchar(10) not null comment '性别',
	content varchar(1000) not null comment'个人简介'
)default charset 'utf8';

CREATE TABLE form(
	table_id INT auto_increment PRIMARY KEY COMMENT '表格编号',
	title varchar(100) not null comment '标题',
	shopname varchar(50) not null comment '商户名',
    position varchar(50) not null comment '商户招聘职位',
    address varchar(200) not null comment '地址',
    linkman varchar(20) not null comment '联系人',
   	phone varchar(20) not null comment '电话',
    content varchar(10000) comment '商户兼职信息'
)DEFAULT CHARSET 'utf8';