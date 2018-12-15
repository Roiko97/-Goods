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
) DEFAULT CHARSET 'utf8';

CREATE TABLE note(
	id INT auto_increment primary key comment '���ݱ��',
    title varchar(200) not null comment '������',
    author varchar(50) not null comment '������',
    releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(16800) not null comment '��������',
    readingvolume bigint comment '���ʴ���'
)DEFAULT CHARSET 'utf8';

CREATE TABLE  activate(
	activation VARCHAR(30) NOT NULL PRIMARY KEY COMMENT '������',
	activate_type VARCHAR(50) NOT NULL COMMENT '��������',
	activate_status INT NOT NULL DEFAULT 0 COMMENT '����״̬ 0δ���� 1���� '
)DEFAULT CHARSET 'utf8';

CREATE TABLE student_authentication(
	student_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT 'ѧ��ѧ��',
	student_password VARCHAR(50) NOT NULL  COMMENT 'ѧ�����룬Ĭ�����֤��6λ',
	 student_activate_status INT NOT NULL DEFAULT 0 COMMENT 'ѧ������״̬ Ĭ��0δ���� 1����'
)DEFAULT CHARSET 'utf8';

CREATE TABLE teacher_authentication(
	teacher_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '��ʦ����',
	teacher_password VARCHAR(50) NOT NULL  COMMENT '��ʦ���룬Ĭ�����֤��6λ',
	teacher_activate_status INT NOT NULL DEFAULT 0 COMMENT '��ʦ����״̬ Ĭ��0δ���� 1����'
)DEFAULT CHARSET 'utf8';

CREATE TABLE Merchant(
	id int auto_increment primary key comment '������id',
    merchant_id varchar(10) not null comment '����Ψһ��ʶ��',
    name varchar(50) not null comment '��������',
    address varchar(5000) comment '���̵�ַ',
    phone varchar(20) comment '���̵绰',
    info varchar(10000) comment '���̽���',
    near int default 0 comment '�Ƿ����ܱ��̻���0��ʾ�ǣ�1��ʾ����',
	pic varchar(500) comment 'ͼƬ'
)DEFAULT CHARSET 'utf8';

CREATE TABLE food(
	id int auto_increment primary key comment '������id',
	merchant_id varchar(10) not null comment '����Ψһ��ʶ��',
	name varchar(2000) not null comment 'ʳ������',
	price varchar(10) not null comment 'ʳ��۸�',
	info varchar(10000) comment 'ʳƷ����',
    pic varchar(500) comment 'ͼƬ'
)DEFAULT CHARSET 'utf8';

CREATE TABLE attractions(
	id int auto_increment primary key comment '������id',
	name varchar(50) not null comment '��������',
    address varchar(5000) comment '�����ַ',
	price varchar(10) comment '����۸�',
	info varchar(10000) comment '�������',
	pic varchar(500) comment 'ͼƬ'
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
	title varchar(100) not null comment '������',
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
	pagecontect varchar(15000) not null comment '����',
	types int not null comment ' 1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ'
)default charset 'utf8';

CREATE TABLE academic(
	id int auto_increment primary key comment '������id',
    mark int comment '����id',
    types int not null comment ' 1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ',
    announcer varchar(50) not null comment ' ������',
    releasetime varchar(50) not null comment '����ʱ��',
	pagecontect varchar(15000) comment '��������',
	validity int not null default 1 comment '��Ч�� 1������Ч 0������Ч'
)default charset 'utf8';

create table dependacademic(
	id int auto_increment primary key comment '������id',
    mark int not null comment '����id',
    description varchar(50) not null comment '˵��',
    content varchar(200) not null comment '����'
)default charset 'utf8';

create table application(
	id int auto_increment primary key comment '������id',
    nickname varchar(50) not null comment '�ظ���',
    mark int not null comment '����id',
     content varchar(200) not null comment '����'
)default charset 'utf8';

create table StudentSend(
	table_id INT auto_increment PRIMARY KEY COMMENT '�����',
	target int not null comment '�ظ�Ŀ����id',
	name varchar(100) not null comment'ѧ������',
	phone varchar(1000) not null comment'ѧ���绰',
	age varchar(10) not null comment '����',
	sex varchar(10) not null comment '�Ա�',
	content varchar(1000) not null comment'���˼��'
)default charset 'utf8';

CREATE TABLE form(
	table_id INT auto_increment PRIMARY KEY COMMENT '�����',
	title varchar(100) not null comment '����',
	shopname varchar(50) not null comment '�̻���',
    position varchar(50) not null comment '�̻���Ƹְλ',
    address varchar(200) not null comment '��ַ',
    linkman varchar(20) not null comment '��ϵ��',
   	phone varchar(20) not null comment '�绰',
    content varchar(10000) comment '�̻���ְ��Ϣ'
)DEFAULT CHARSET 'utf8';