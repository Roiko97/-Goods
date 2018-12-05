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
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("damu", "damu", "��Ľ", "2017-05-16", 0);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("xiaomu", "xiaomu", "С��", "2017-05-16", 0);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("houjuzhang", "123456", "����ƽ", "2017-05-16", 1);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("jichangping", "111111", "����ƽ", "2017-05-16", 1);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("chenhai", "222222", "�º�", "2017-05-16", 2);
 
 

CREATE TABLE note(
	id INT auto_increment primary key comment '���ݱ��',
    title varchar(50) not null comment '������',
    author varchar(50) not null comment '������',
    releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(20000) not null comment '��������',
    readingvolume bigint comment '���ʴ���'
)DEFAULT CHARSET 'utf8';
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs1','admin','2018-10-20','aaa',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs2','admin','2018-10-21','bbb',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs3','admin','2018-10-22','ccc',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs4','admin','2018-10-23','ddd',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs5','admin','2018-10-24','eee',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs6','admin','2018-10-25','fff',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs7','admin','2018-10-26','ggg',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs8','admin','2018-10-27','hhh',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs9','admin','2018-10-28','iii',0);
insert into note(title,author,releasetime,pagecontect,readingvolume) values('cs10','admin','2018-10-29','jjj',0);


CREATE TABLE  activate(
	activation VARCHAR(19) NOT NULL PRIMARY KEY COMMENT '������',
	activate_type VARCHAR(50) NOT NULL COMMENT '��������',
	activate_status INT NOT NULL DEFAULT 0 COMMENT '����״̬ 0δ���� 1���� '
)DEFAULT CHARSET "utf8";
INSERT INTO activate(activation,activate_type) VALUES("MSYQ-1HSY-FNNZ-YT38","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("HJAS-2S5Z-GJQZ-SDWZ","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("IWHZ-W1ZN-JDWU-21NZ","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("GJNZ-2ZNZ-D3SZ-6H82","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("ZDHZ-SHQE-6JZ2-3NN1","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("SDH2-DAJZ-JF5K-JS1Z","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("GJHZ-UWJ4-LH3H-ZWQN","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("ZNDH-SHGM-HZJI-21M3","��֯������");
INSERT INTO activate(activation,activate_type) VALUES("1JHZ-3DSZ-GKIA-Z4DG","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("NJJG-MZ2D-JJG6-IYBD","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("OIEN-HYNB-1MG3-HYWK","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("QRJN-SMFA-2M3J-ZSD7","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("PUEN-HENZ-BIC2-SJUD","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("S1ZF-GASD-KUNN-W2GG","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("KNS2-ZDSH-JUEN-TNF9","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("BHSZ-YRNS-UOJG-TT2J","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("LINH-DSUW-AW27-1DSN","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("YWBG-WU1S-S2ZS-12YU","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("OPQN-WVFX-V2YT-PTYU","�̼�");
INSERT INTO activate(activation,activate_type) VALUES("RDNZ-SN2Z-2SIT-UYNA","��֯������");



CREATE TABLE student_authentication(
	student_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT 'ѧ��ѧ��',
	student_password VARCHAR(50) NOT NULL  COMMENT 'ѧ�����룬Ĭ�����֤��6λ',
	 student_activate_status INT NOT NULL DEFAULT 0 COMMENT 'ѧ������״̬ Ĭ��0δ���� 1����'
)DEFAULT CHARSET "utf8";
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1101","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1102","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1103","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1104","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1105","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1106","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1107","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1108","123456");
INSERT INTO teacher_authentication(teacher_id,teacher_password) VALUES("1109","123456");




CREATE TABLE teacher_authentication(
	teacher_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '��ʦ����',
	teacher_password VARCHAR(50) NOT NULL  COMMENT '��ʦ���룬Ĭ�����֤��6λ',
	teacher_activate_status INT NOT NULL DEFAULT 0 COMMENT '��ʦ����״̬ Ĭ��0δ���� 1����'
)DEFAULT CHARSET "utf8";
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010101","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010102","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010103","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010104","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010105","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010106","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010107","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010108","123456");
INSERT INTO student_authentication(student_id,student_password) VALUES("201601010109","123456");


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
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#FE8UA2F41GWI','��ֻ����','�㶫ʡ��ɽ������·�źŵ��ӿƼ���ѧ��ɽѧԺ����111�ŵ�','0757-28823048','��ֻ����ɷ����޹�˾������2012�꣬���й���һ�Ҷ�λ�ڴ�������ʳƷƷ�Ƶ���ҵ��Ҳ�ǵ�ǰ�й����۹�ģ����ʳƷ������ҵ������ֻ����Ʒ��һ���Ƴ��������ܵ��˷���Ͷ�ʻ������������Ⱥ���IDG��150������A����ʹͶ�ʺͽ����ʱ���600����ԪB��Ͷ�ʡ�','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#4EFUA24541HI','��Ʒ����','����ʡ�人�ж���������������´��8��','0823-88245524','��Ʒ������һ�Ҽ�����ʳƷ�з����ӹ���װ�����۷����רҵƷ��������Ӫ��˾����Ʒ���ӱ�����Ʒ�ʡ����֡��ҵ���ҵ���ļ�ֵ�ۣ�����з���Ʒ�ʲ�Ʒ�����������Ƚ��ľ�Ӫ����˼�롣','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#C583A2FS5HWI','���¿�','�й���������ɱ���׿չ��������','0675-30275544','UNIQLO�����ļ�����������˥������ձ���װƷ�ƣ����ձ�Ѹ����˾������1963�꣬������һ������������С��װ�꣬���ѳ�Ϊ����֪����װƷ�ơ����¿����ζ��³����ܾ������������ձ��״������˴�����ʽ�ķ�װ���۷�ʽ��ͨ�����ص���Ʒ�߻���������������ϵ��ʵ�ֵ��������ĵͳɱ������ɴ����������¿����������','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#8ASGY2S55H5A','������Ʒ','�㶫ʡ��������������·621-625������㳡F2��','0122-71279554','MINISO������Ʒ�ǹ㶫����Ͷ�����޹�˾���й��̱���ע���Ʒ�� [1]��ע��ţ�16294425 [1]�����ʷ��ࣺ21 [1]��ע�����ڣ�2016��06��28�� [1]��MINISO������Ʒ���С���Լ����Ȼ�����ʸС���������ѧ�͡��ع���Ȼ����ԭ��Ʒ���ʡ���������ţ����С����������ߡ���Ʒ�ƾ���������Ϊȫ���������ṩ����"���ʡ����⡢�ͼ�"�Ĳ�Ʒ����ʱ����������ǰ���г��Ⱥ����������Ʒ���ѡ�֮�硣','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#SQSG9IZ5FHH5','�Ϳ�','�������ո��ݲ�������NIKE��˾','0498-51649534','�Ϳ��̱�ͼ���Ǹ�С���ӡ��Ϳ�һֱ������ȫ�����ÿһλ�˶�Ա��Ϊ��������õĲ�Ʒ��Ϊ���ٵ������Ϳ��״������漼���������������һ�������������������������˶�Ь���Ժܺõر����˶�Ա��ϥ��.�������������˶����ʱ��С��ϥ�ǵ�Ӱ�졣','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#1XS6GUZ1F4GR','���ϴ�˹','�¹��˶���Ʒ�����̰��ϴ�˹AG��Ա��˾','0336-31285754','���ϴ�˹ԭ�������ֵܹ�ͬ���裬�ڷֵ�����󣬰�����ĸ��³���򡤴�˹�գ�Rudolf Dassler���������˶�Ʒ��puma���侭�������û�в����ܡ���Impossible is nothing����2011��3�£�����1.6��ŷԪ����ȫ�¿ںš���adidas is all in��ȫ��ȫ������','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#0DSQS8U11T6R','������','�㶫ʡ���������ѹ㳡��¥','0199-45213484','�������ǳ����ͼ����޹�˾���µĹ������ۼ�ʳƷ��������������漰����Ʒ�����б�����Ʒ�����ݲ�Ʒ����ˮ����ױƷ�����á�ʳƷ����Ʒ�����Ӳ�Ʒ����Ƽ���������ҵ�����������й�438������ӵ�г���3,200�ҵ��̺���6,400���Ա�����й�Ŀǰ���ı��������ݲ�Ʒ���������ꡣ','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#T0G0R3UIUIK7','�ټѳ���','�㶫ʡ��ɽ�ж����ֵ����е�6�ż��չ㳡','0915-57294450','�ټ��Դ����ڵ��������ȣ�ӭ�Ϲ˿����վ����������ṩһվʽ������񡣶������꣬�ټ��ڹ��ݿ����˵�һ�ҳ����㳡��������춹����з�æ��������������ڵصĵ�һ�ҹ���㳡��','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#3H6MR3U6RIY8','�ǰͿ�','������ʢ��������ͼ�ǰͿ��ܹ�˾','0274-18215480','�ǰͿ��������۲�Ʒ����30���ȫ�򶥼��Ŀ��ȶ����ֹ�������Ũ�����ȺͶ����������ϡ�������ζ�ĸ�ʽ���ʳƷ�Լ��ḻ�����Ŀ��Ȼ������ȱ�����Ʒ��','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#E3MSRI462HW7','����','��������ŵ����֥�Ӹ������ܹ�˾','0839-08235389','���Ͳ������й���½���������ǡ�������ɿ�͡���ֱ�����ڲ�ͳһ�����ֽ�ĸ�ʽ������������䣬��Ϊ���ͺ͡�ĵ��¥����������ĵ��¥Ҳ�����������͵�һ���ǳƣ��������ձ顣','0');


INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#FE8UA2F41GWI','��ֻ����','�㶫ʡ��ɽ������·�źŵ��ӿƼ���ѧ��ɽѧԺ����111�ŵ�','0757-28823048','��ֻ����ɷ����޹�˾������2012�꣬���й���һ�Ҷ�λ�ڴ�������ʳƷƷ�Ƶ���ҵ��Ҳ�ǵ�ǰ�й����۹�ģ����ʳƷ������ҵ������ֻ����Ʒ��һ���Ƴ��������ܵ��˷���Ͷ�ʻ������������Ⱥ���IDG��150������A����ʹͶ�ʺͽ����ʱ���600����ԪB��Ͷ�ʡ�','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#4EFUA24541HI','��Ʒ����','����ʡ�人�ж���������������´��8��','0823-88245524','��Ʒ������һ�Ҽ�����ʳƷ�з����ӹ���װ�����۷����רҵƷ��������Ӫ��˾����Ʒ���ӱ�����Ʒ�ʡ����֡��ҵ���ҵ���ļ�ֵ�ۣ�����з���Ʒ�ʲ�Ʒ�����������Ƚ��ľ�Ӫ����˼�롣','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#C583A2FS5HWI','���¿�','�й���������ɱ���׿չ��������','0675-30275544','UNIQLO�����ļ�����������˥������ձ���װƷ�ƣ����ձ�Ѹ����˾������1963�꣬������һ������������С��װ�꣬���ѳ�Ϊ����֪����װƷ�ơ����¿����ζ��³����ܾ������������ձ��״������˴�����ʽ�ķ�װ���۷�ʽ��ͨ�����ص���Ʒ�߻���������������ϵ��ʵ�ֵ��������ĵͳɱ������ɴ����������¿����������','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#8ASGY2S55H5A','������Ʒ','�㶫ʡ��������������·621-625������㳡F2��','0122-71279554','MINISO������Ʒ�ǹ㶫����Ͷ�����޹�˾���й��̱���ע���Ʒ�� [1]��ע��ţ�16294425 [1]�����ʷ��ࣺ21 [1]��ע�����ڣ�2016��06��28�� [1]��MINISO������Ʒ���С���Լ����Ȼ�����ʸС���������ѧ�͡��ع���Ȼ����ԭ��Ʒ���ʡ���������ţ����С����������ߡ���Ʒ�ƾ���������Ϊȫ���������ṩ����"���ʡ����⡢�ͼ�"�Ĳ�Ʒ����ʱ����������ǰ���г��Ⱥ����������Ʒ���ѡ�֮�硣','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#SQSG9IZ5FHH5','�Ϳ�','�������ո��ݲ�������NIKE��˾','0498-51649534','�Ϳ��̱�ͼ���Ǹ�С���ӡ��Ϳ�һֱ������ȫ�����ÿһλ�˶�Ա��Ϊ��������õĲ�Ʒ��Ϊ���ٵ������Ϳ��״������漼���������������һ�������������������������˶�Ь���Ժܺõر����˶�Ա��ϥ��.�������������˶����ʱ��С��ϥ�ǵ�Ӱ�졣','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#1XS6GUZ1F4GR','���ϴ�˹','�¹��˶���Ʒ�����̰��ϴ�˹AG��Ա��˾','0336-31285754','���ϴ�˹ԭ�������ֵܹ�ͬ���裬�ڷֵ�����󣬰�����ĸ��³���򡤴�˹�գ�Rudolf Dassler���������˶�Ʒ��puma���侭�������û�в����ܡ���Impossible is nothing����2011��3�£�����1.6��ŷԪ����ȫ�¿ںš���adidas is all in��ȫ��ȫ������','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#0DSQS8U11T6R','������','�㶫ʡ���������ѹ㳡��¥','0199-45213484','�������ǳ����ͼ����޹�˾���µĹ������ۼ�ʳƷ��������������漰����Ʒ�����б�����Ʒ�����ݲ�Ʒ����ˮ����ױƷ�����á�ʳƷ����Ʒ�����Ӳ�Ʒ����Ƽ���������ҵ�����������й�438������ӵ�г���3,200�ҵ��̺���6,400���Ա�����й�Ŀǰ���ı��������ݲ�Ʒ���������ꡣ','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#T0G0R3UIUIK7','�ټѳ���','�㶫ʡ��ɽ�ж����ֵ����е�6�ż��չ㳡','0915-57294450','�ټ��Դ����ڵ��������ȣ�ӭ�Ϲ˿����վ����������ṩһվʽ������񡣶������꣬�ټ��ڹ��ݿ����˵�һ�ҳ����㳡��������춹����з�æ��������������ڵصĵ�һ�ҹ���㳡��','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#3H6MR3U6RIY8','�ǰͿ�','������ʢ��������ͼ�ǰͿ��ܹ�˾','0274-18215480','�ǰͿ��������۲�Ʒ����30���ȫ�򶥼��Ŀ��ȶ����ֹ�������Ũ�����ȺͶ����������ϡ�������ζ�ĸ�ʽ���ʳƷ�Լ��ḻ�����Ŀ��Ȼ������ȱ�����Ʒ��','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#E3MSRI462HW7','����','��������ŵ����֥�Ӹ������ܹ�˾','0839-08235389','���Ͳ������й���½���������ǡ�������ɿ�͡���ֱ�����ڲ�ͳһ�����ֽ�ĸ�ʽ������������䣬��Ϊ���ͺ͡�ĵ��¥����������ĵ��¥Ҳ�����������͵�һ���ǳƣ��������ձ顣','1');



CREATE TABLE food(
	id int auto_increment primary key comment '������id',
	merchant_id varchar(10) not null comment '����Ψһ��ʶ��',
	name varchar(2000) not null comment 'ʳ������',
	price varchar(10) not null comment ' ʳ��۸�',
	info varchar(10000) comment 'ʳƷ����'
)DEFAULT CHARSET 'utf8';
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','��Ѽ','20','��');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','����','10','�ó�');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','����','60','�ܺó�');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','ƻ��','40','�ǳ��ó�');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','����','90','��ĺܺó�');



CREATE TABLE attractions(
	id int auto_increment primary key comment '������id',
	name varchar(50) not null comment '��������',
    address varchar(5000) comment '�����ַ',
	price varchar(10) comment '����۸�',
	info varchar(10000) comment '�������'
)DEFAULT CHARSET 'utf8';
INSERT INTO attractions(name,address,price,info) values ('��ɽˮ��','��ɽ','20','��');
INSERT INTO attractions(name,address,price,info) values ('����ϿƯ��','��Զ','10','����');
INSERT INTO attractions(name,address,price,info) values ('���ֹ�','����','60','�ܺ���');
INSERT INTO attractions(name,address,price,info) values ('����ˮ����԰','����','40','�ǳ�����');
INSERT INTO attractions(name,address,price,info) values ('�ʹ�','����','90','��ĺܺ���');


CREATE TABLE LostAndFound(
	id int auto_increment primary key comment '������id',
	title varchar(50) not null comment '������',
	nickname VARCHAR(50) COMMENT '�������ǳ�',
	releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(10000) not null comment '��������',
    solve int not null default 0 comment '�Ƿ��� Ĭ��δ���Ϊ0 ���Ϊ1'
)DEFAULT CHARSET 'utf8';
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('1111','����','2018��1��1��','������������','0');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('2222','����','2018��2��2��','����������','1');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('3333','�Ϲ�','2018��3��3��','����������','1');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('4444','����','2018��4��4��','����������','0');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('5555','�й�','2018��5��5��','����������','1');


CREATE TABLE communication(
	id int auto_increment primary key comment '������id',
	title varchar(50) not null comment '������',
	nickname VARCHAR(50) COMMENT '�������ǳ�',
	releasetime varchar(50) not null comment '����ʱ��',
    pagecontect varchar(10000) not null comment '��������'
)default charset 'utf8';
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('aaaa','����','2018��1��1��','����������������');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('bbbb','�Ǻ�','2018��2��2��','�ǺǺǺǺǺǺǺ�');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('cccc','����','2018��3��3��','����������������');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('dddd','�ٺ�','2018��4��4��','�ٺٺٺٺٺٺٺ�');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('eeee','����','2018��5��5��','����������������');


CREATE TABLE reply(
	id int auto_increment primary key comment '������id',
	target int not null comment '�ظ�Ŀ����id',
	nickname VARCHAR(50) COMMENT '�ظ����ǳ�',
	releasetime varchar(50) not null comment '�ظ�ʱ��',
    pagecontect varchar(10000) not null comment '�ظ�������'
)default charset 'utf8';
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (1,'С��','2018��1��1��','����������������');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (1,'С��','2018��2��2��','���������');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (1,'С��','2018��3��3��','������');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (2,'С��','2018��4��4��','����������������');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (2,'С��','2018��5��5��','����������������');


CREATE TABLE academic(
	id int auto_increment primary key comment '������id',
    types int not null comment ' 1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ',
    announcer varchar(50) not null comment ' ������',
    releasetime varchar(50) not null comment '����ʱ��',
	pagecontect varchar(10000) not null comment '��������',
	validity int not null default 1 comment '��Ч�� 1������Ч 0������Ч'
)default charset 'utf8';

CREATE TABLE form(
	table_id INT auto_increment PRIMARY KEY COMMENT '�����',
	user_id int not null conmment'�̼�id',
	name varchar(100) not null conmment'�̼�����',
	place varchar(1000) not null comment'�̼�λ��',
	position varchar(200) not null comment '��Ƹְλ',
	content varchar(20000) not null comment'��Ƹ����',
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

create table StudentSend(
	table_id INT auto_increment PRIMARY KEY COMMENT '�����',
	user_id int not null conmment'�̼�id',
	name varchar(100) not null conmment'ѧ������',
	phone varchar(1000) not null comment'ѧ���绰'
	position varchar(200) not null comment 'ӦƸְλ',
	content varchar(20000) not null comment'���˼��',
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
)default charset "utf8";

create table Send(
	table_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '�����',
    username varchar(50) not null comment '�̻���',
    position varchar(13) not null comment '�̻���Ƹְλ',
    infomation varchar(200000) comment '�̻���ְ��Ϣ',
)default charset "utf8";
INSERT INTO Send(username,position,imfomation) values ('��Ʒ����','����Ա','��Ʒ������ֵ��ӵ��');
INSERT INTO Send(username,position,imfomation) values ('�й�����','��ά��Ա','�й����ž�������');
INSERT INTO Send(username,position,imfomation) values ('�Ϳ�','�ۺ����Ա','just do it');
INSERT INTO Send(username,position,imfomation) values ('���¿�','����','����õ����¼�');
INSERT INTO Send(username,position,imfomation) values ('������Ʒ','����','������Ʒ�����Ʒ');