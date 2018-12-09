CREATE DATABASE sedb;
CREATE TABLE users(
	id INT AUTO_INCREMENT PRIMARY KEY COMMENT '�û����',
	username VARCHAR(50) NOT NULL COMMENT '��¼�˺�',
	userpass VARCHAR(50) NOT NULL COMMENT '��¼����',
	nickname VARCHAR(50) COMMENT '�û��ǳ�',
	age INT COMMENT '�û�����',
	gender VARCHAR(5) COMMENT '�û��Ա�',
	phone VARCHAR(13) COMMENT '��ϵ��ʽ',
	email VARCHAR(20) COMMENT '�û�����',
	createTime DATETIME COMMENT '����ʱ��',
	lastLogin DATETIME COMMENT '����¼ʱ��',
	userStatus INT COMMENT '�û�״̬ 0 ���� 1 ����',
    jurisdiction  INT COMMENT '�û�Ȩ��'
) DEFAULT CHARSET "utf8";

 
 

CREATE TABLE note(
	id INT auto_increment primary key comment '���ݱ��',
    title varchar(50) not null comment '������',
    author varchar(50) not null comment '������',
    releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(20000) not null comment '��������',
    readingvolume bigint comment '���ʴ���'
)DEFAULT CHARSET 'utf8';



CREATE TABLE  activate(
	activation VARCHAR(19) NOT NULL PRIMARY KEY COMMENT '������',
	activate_type VARCHAR(50) NOT NULL COMMENT '��������',
	activate_status INT NOT NULL DEFAULT 0 COMMENT '����״̬ 0δ���� 1���� '
)DEFAULT CHARSET "utf8";



CREATE TABLE student_authentication(
	student_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT 'ѧ��ѧ��',
	student_password VARCHAR(50) NOT NULL  COMMENT 'ѧ�����룬Ĭ�����֤��6λ',
	 student_activate_status INT NOT NULL DEFAULT 0 COMMENT 'ѧ������״̬ Ĭ��0δ���� 1����'
)DEFAULT CHARSET "utf8";





CREATE TABLE teacher_authentication(
	teacher_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '��ʦ����',
	teacher_password VARCHAR(50) NOT NULL  COMMENT '��ʦ���룬Ĭ�����֤��6λ',
	teacher_activate_status INT NOT NULL DEFAULT 0 COMMENT '��ʦ����״̬ Ĭ��0δ���� 1����'
)DEFAULT CHARSET "utf8";



CREATE TABLE form(
	id INT auto_increment PRIMARY KEY COMMENT '�����',
    username varchar(50) not null comment '�û���',
    phone varchar(13) not null comment '�û��绰',
    email varchar(20) comment '�û�����',
	expand_0 varchar(20000) comment '��չ�ֶ���',
    expand_1 varchar(20000) comment '��չ�ֶ�һ',
	expand_2 varchar(20000) comment '��չ�ֶζ�',
	expand_3 varchar(20000) comment '��չ�ֶ���',
	expand_4 varchar(20000) comment '��չ�ֶ���',
	expand_5 varchar(20000) comment '��չ�ֶ���',
	expand_6 varchar(20000) comment '��չ�ֶ���',
	expand_7 varchar(20000) comment '��չ�ֶ���',
	expand_8 varchar(20000) comment '��չ�ֶΰ�',
	expand_9 varchar(20000) comment '��չ�ֶξ�'
)DEFAULT CHARSET "utf8";




CREATE TABLE Merchant(
	id int auto_increment primary key comment '������id',
    merchant_id varchar(10) not null comment '����Ψһ��ʶ��',
    name varchar(50) not null comment '��������',
    address varchar(5000) comment '���̵�ַ',
    phone varchar(20) comment '���̵绰',
    info varchar(10000) comment '���̽���',
    near int default 0 comment '�Ƿ����ܱ��̻���0��ʾ�ǣ�1��ʾ����'
)DEFAULT CHARSET 'utf8';


CREATE TABLE food(
	id int auto_increment primary key comment '������id',
	merchant_id varchar(10) not null comment '����Ψһ��ʶ��',
	name varchar(2000) not null comment 'ʳ������',
	price varchar(10) not null comment 'ʳ��۸�',
	info varchar(10000) comment 'ʳƷ����'
)DEFAULT CHARSET 'utf8';



CREATE TABLE attractions(
	id int auto_increment primary key comment '������id',
	name varchar(50) not null comment '��������',
    address varchar(5000) comment '�����ַ',
	price varchar(10) comment '����۸�',
	info varchar(10000) comment '�������'
)DEFAULT CHARSET 'utf8';

CREATE TABLE LostAndFound(
	id int auto_increment primary key comment '������id',
	title varchar(50) not null comment '������',
	nickname VARCHAR(50) COMMENT '�������ǳ�',
	releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(10000) not null comment '��������',
    solve int not null default 0 comment '�Ƿ��� Ĭ��δ���Ϊ0 ���Ϊ1'
)DEFAULT CHARSET 'utf8';



CREATE TABLE communication(
	id int auto_increment primary key comment '������id',
	title varchar(50) not null comment '������',
	nickname VARCHAR(50) COMMENT '�������ǳ�',
	releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(10000) not null comment '��������'
)default charset 'utf8';



CREATE TABLE reply(
	id int auto_increment primary key comment '������id',
	target int not null comment '�ظ�Ŀ����id',
	nickname VARCHAR(50) COMMENT '�ظ����ǳ�',
	releasetime varchar(50) not null comment '�ظ�ʱ��',
    pagecontect varchar(10000) not null comment '�ظ�������'
)default charset 'utf8';


CREATE TABLE titleacademic(
	id int auto_increment primary key comment '������id',
    name varchar(50) not null comment '����',
    title varchar(1000) not null comment '����',
	stoptime varchar(50) not null comment '��ֹʱ��',
	pagecontect varchar(20000) not null comment '����',
	types int not null comment ' 1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ'
)default charset 'utf8';
CREATE TABLE academic(
	id int auto_increment primary key comment '������id',
    mark int not null comment '����id',
    types int not null comment ' 1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ',
    announcer varchar(50) not null comment ' ������',
    releasetime varchar(50) not null comment '����ʱ��',
	pagecontect varchar(20000) not null comment '��������',
	validity int not null default 1 comment '��Ч�� 1������Ч 0������Ч'
)default charset 'utf8';
create table dependacademic(
	id int auto_increment primary key comment '������id',
    mark int not null comment '����id',
    description varchar(50) not null comment '˵��',
    content varchar(100) not null comment '����'
)default charset 'utf8';

create table application(
	id int auto_increment primary key comment '������id',
    nickname varchar(50) not null comment '�ظ���',
    mark int not null comment '����id',
     content varchar(100) not null comment '����'
)default charset 'utf8';


CREATE TABLE form(
	table_id INT auto_increment PRIMARY KEY COMMENT '�����',
	user_id varchar(10) not null comment '�̻�id',
	name varchar(100) not null comment'�̼�����',
	place varchar(1000) not null comment'�̼�λ��',
	position varchar(200) not null comment '��Ƹְλ',
	content varchar(1000) not null comment'��Ƹ����',
	expand_0 varchar(1000) comment '��չ�ֶ���',
    expand_1 varchar(1000) comment '��չ�ֶ�һ',
	expand_2 varchar(1000) comment '��չ�ֶζ�',
	expand_3 varchar(1000) comment '��չ�ֶ���',
	expand_4 varchar(1000) comment '��չ�ֶ���',
	expand_5 varchar(1000) comment '��չ�ֶ���',
	expand_6 varchar(1000) comment '��չ�ֶ���',
	expand_7 varchar(1000) comment '��չ�ֶ���'
)DEFAULT CHARSET "utf8";
INSERT INTO form(user_id,name,place,position,content) values ('#41SADFGAS','��Ʒ����','������¥','����Ա','��Ʒ������ֵ��ӵ��');
INSERT INTO form(user_id,name,place,position,content) values ('#FS241HYAS','H&M','�ͷ��Ƶ�','�곤','����õ��Լ���H&M');
INSERT INTO form(user_id,name,place,position,content) values ('#2462SFEYS','�¶���','�������','��ʦ','����ʦ���¶���');

create table StudentSend(
	table_id INT auto_increment PRIMARY KEY COMMENT '�����',
	user_id varchar(10) not null comment '�̻�id',
	name varchar(100) not null comment'ѧ������',
	phone varchar(1000) not null comment'ѧ���绰',
	position varchar(200) not null comment 'ӦƸְλ',
	content varchar(1000) not null comment'���˼��',
	expand_0 varchar(1000) comment '��չ�ֶ���',
    expand_1 varchar(1000) comment '��չ�ֶ�һ',
	expand_2 varchar(1000) comment '��չ�ֶζ�',
	expand_3 varchar(1000) comment '��չ�ֶ���',
	expand_4 varchar(1000) comment '��չ�ֶ���',
	expand_5 varchar(1000) comment '��չ�ֶ���',
	expand_6 varchar(1000) comment '��չ�ֶ���',
	expand_7 varchar(1000) comment '��չ�ֶ���'
)default charset "utf8";
INSERT INTO StudentSend(user_id,name,phone,position,content) values ('#41SADFGAS','���׷�','15324141245','����Ա','������������');
INSERT INTO StudentSend(user_id,name,phone,position,content) values ('#2462SFEYS','������','15375648843','����Ա','������������');


 create table Send(
	table_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '�����',
    username varchar(50) not null comment '�̻���',
    position varchar(50) not null comment '�̻���Ƹְλ',
    infomation varchar(10000) comment '�̻���ְ��Ϣ'
)default charset "utf8";
INSERT INTO Send(username,position,infomation) values ('��Ʒ����','����Ա','��Ʒ������ֵ��ӵ��');
INSERT INTO Send(username,position,infomation) values ('�й�����','��ά��Ա','�й����ž�������');
INSERT INTO Send(username,position,infomation) values ('�Ϳ�','�ۺ����Ա','just do it');
INSERT INTO Send(username,position,infomation) values ('���¿�','����','����õ����¼�');
INSERT INTO Send(username,position,infomation) values ('������Ʒ','����','������Ʒ�����Ʒ');