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
) DEFAULT CHARSET "utf8";
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("damu", "damu", "大慕", "2017-05-16", 0);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("xiaomu", "xiaomu", "小牧", "2017-05-16", 0);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("houjuzhang", "123456", "侯亮平", "2017-05-16", 1);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("jichangping", "111111", "季昌平", "2017-05-16", 1);
INSERT INTO users(username, userpass,nickname,createTime,userStatus)
 VALUES("chenhai", "222222", "陈海", "2017-05-16", 2);
 
 

CREATE TABLE note(
	id INT auto_increment primary key comment '内容编号',
    title varchar(50) not null comment '标题名',
    author varchar(50) not null comment '作者名',
    releasetime varchar(50) not null comment '发布时间',
    pagecontect varchar(20000) not null comment '发布内容',
    readingvolume bigint comment '访问次数'
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
	activation VARCHAR(19) NOT NULL PRIMARY KEY COMMENT '激活码',
	activate_type VARCHAR(50) NOT NULL COMMENT '激活类型',
	activate_status INT NOT NULL DEFAULT 0 COMMENT '激活状态 0未激活 1激活 '
)DEFAULT CHARSET "utf8";
INSERT INTO activate(activation,activate_type) VALUES("MSYQ-1HSY-FNNZ-YT38","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("HJAS-2S5Z-GJQZ-SDWZ","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("IWHZ-W1ZN-JDWU-21NZ","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("GJNZ-2ZNZ-D3SZ-6H82","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("ZDHZ-SHQE-6JZ2-3NN1","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("SDH2-DAJZ-JF5K-JS1Z","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("GJHZ-UWJ4-LH3H-ZWQN","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("ZNDH-SHGM-HZJI-21M3","组织负责人");
INSERT INTO activate(activation,activate_type) VALUES("1JHZ-3DSZ-GKIA-Z4DG","商家");
INSERT INTO activate(activation,activate_type) VALUES("NJJG-MZ2D-JJG6-IYBD","商家");
INSERT INTO activate(activation,activate_type) VALUES("OIEN-HYNB-1MG3-HYWK","商家");
INSERT INTO activate(activation,activate_type) VALUES("QRJN-SMFA-2M3J-ZSD7","商家");
INSERT INTO activate(activation,activate_type) VALUES("PUEN-HENZ-BIC2-SJUD","商家");
INSERT INTO activate(activation,activate_type) VALUES("S1ZF-GASD-KUNN-W2GG","商家");
INSERT INTO activate(activation,activate_type) VALUES("KNS2-ZDSH-JUEN-TNF9","商家");
INSERT INTO activate(activation,activate_type) VALUES("BHSZ-YRNS-UOJG-TT2J","商家");
INSERT INTO activate(activation,activate_type) VALUES("LINH-DSUW-AW27-1DSN","商家");
INSERT INTO activate(activation,activate_type) VALUES("YWBG-WU1S-S2ZS-12YU","商家");
INSERT INTO activate(activation,activate_type) VALUES("OPQN-WVFX-V2YT-PTYU","商家");
INSERT INTO activate(activation,activate_type) VALUES("RDNZ-SN2Z-2SIT-UYNA","组织负责人");



CREATE TABLE student_authentication(
	student_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '学生学号',
	student_password VARCHAR(50) NOT NULL  COMMENT '学生密码，默认身份证后6位',
	 student_activate_status INT NOT NULL DEFAULT 0 COMMENT '学生激活状态 默认0未激活 1激活'
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
	teacher_id VARCHAR(50) NOT NULL PRIMARY KEY COMMENT '教师工号',
	teacher_password VARCHAR(50) NOT NULL  COMMENT '教师密码，默认身份证后6位',
	teacher_activate_status INT NOT NULL DEFAULT 0 COMMENT '教师激活状态 默认0未激活 1激活'
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
	id INT auto_increment PRIMARY KEY COMMENT '表格编号',
    username varchar(50) not null comment '用户名',
    phone varchar(13) not null comment '用户电话',
    email varchar(20) comment '用户邮箱',
	expand_0 varchar(20000) comment '拓展字段零',
    expand_1 varchar(20000) comment '拓展字段一',
	expand_2 varchar(20000) comment '拓展字段二',
	expand_3 varchar(20000) comment '拓展字段三',
	expand_4 varchar(20000) comment '拓展字段四',
	expand_5 varchar(20000) comment '拓展字段五',
	expand_6 varchar(20000) comment '拓展字段六',
	expand_7 varchar(20000) comment '拓展字段七',
	expand_8 varchar(20000) comment '拓展字段八',
	expand_9 varchar(20000) comment '拓展字段九'
)DEFAULT CHARSET "utf8";




CREATE TABLE Merchant(
	id int auto_increment primary key comment '自增长id',
    merchant_id varchar(10) not null comment '商铺唯一标识号',
    name varchar(50) not null comment '商铺名称',
    address varchar(5000) comment '商铺地址',
    phone varchar(20) comment '商铺电话',
    info varchar(10000) comment '店铺介绍',
    near int default 0 comment '是否是周边商户，0表示是，1表示不是'
)DEFAULT CHARSET 'utf8';
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#FE8UA2F41GWI','三只松鼠','广东省中山市龙腾路九号电子科技大学中山学院北门111号店','0757-28823048','三只松鼠股份有限公司成立于2012年，是中国第一家定位于纯互联网食品品牌的企业，也是当前中国销售规模最大的食品电商企业。“三只松鼠”品牌一经推出，立刻受到了风险投资机构的青睐，先后获得IDG的150万美金A轮天使投资和今日资本的600万美元B轮投资。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#4EFUA24541HI','良品铺子','湖北省武汉市东西湖区走马岭革新大道8号','0823-88245524','良品铺子是一家集休闲食品研发、加工分装、零售服务的专业品牌连锁运营公司。良品铺子秉承着品质·快乐·家的企业核心价值观，坚持研发高品质产品，不断引进先进的经营管理思想。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#C583A2FS5HWI','优衣库','中国北京五棵松北京卓展购物中心','0675-30275544','UNIQLO（日文假名发音：ユニクロ），日本服装品牌，由日本迅销公司建立于1963年，当年是一家销售西服的小服装店，现已成为国际知名服装品牌。优衣库现任董事长兼总经理柳井正在日本首次引进了大卖场式的服装销售方式，通过独特的商品策划、开发和销售体系来实现店铺运作的低成本化，由此引发了优衣库的热卖潮。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#8ASGY2S55H5A','名创优品','广东省广州市天河区天河路621-625号天娱广场F2号','0122-71279554','MINISO名创优品是广东赛曼投资有限公司在中国商标网注册的品牌 [1]，注册号：16294425 [1]，国际分类：21 [1]，注册日期：2016年06月28日 [1]。MINISO名创优品奉行“简约、自然、富质感”的生活哲学和“回归自然，还原产品本质”的设计主张，秉承“尊重消费者”的品牌精神，致力于为全球消费者提供真正"优质、创意、低价"的产品，在时尚休闲消费前沿市场先后刮起“生活优品消费”之风。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#SQSG9IZ5FHH5','耐克','美国俄勒冈州波特兰市NIKE公司','0498-51649534','耐克商标图案是个小钩子。耐克一直将激励全世界的每一位运动员并为其献上最好的产品视为光荣的任务。耐克首创的气垫技术给体育界带来了一场革命。运用这项技术制造出的运动鞋可以很好地保护运动员的膝盖.在其在作剧烈运动落地时减小对膝盖的影响。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#1XS6GUZ1F4GR','阿迪达斯','德国运动用品制造商阿迪达斯AG成员公司','0336-31285754','阿迪达斯原本由两兄弟共同开设，在分道扬镳后，阿道夫的哥哥鲁道夫·达斯勒（Rudolf Dassler）开设了运动品牌puma。其经典广告语：“没有不可能”（Impossible is nothing）。2011年3月，斥资1.6亿欧元启用全新口号——adidas is all in（全倾全力）。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#0DSQS8U11T6R','屈臣氏','广东省广州市正佳广场二楼','0199-45213484','屈臣氏是长江和记有限公司旗下的国际零售及食品制造机构。集团涉及的商品包括有保健产品、美容产品、香水、化妆品、日用、食品、饮品、电子产品、洋酒及机场零售业务。屈臣氏在中国438个城市拥有超过3,200家店铺和逾6,400万会员，是中国目前最大的保健及美容产品零售连锁店。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#T0G0R3UIUIK7','百佳超市','广东省中山市东区街道兴中道6号假日广场','0915-57294450','百佳自此在内地著著领先，迎合顾客与日俱增的需求，提供一站式购物服务。二○○○年，百佳在广州开设了第一家超级广场，翌年又於广州市繁忙的天河区开设在内地的第一家购物广场。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#3H6MR3U6RIY8','星巴克','美国华盛顿州西雅图星巴克总公司','0274-18215480','星巴克旗下零售产品包括30多款全球顶级的咖啡豆、手工制作的浓缩咖啡和多款咖啡冷热饮料、新鲜美味的各式糕点食品以及丰富多样的咖啡机、咖啡杯等商品。','0');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#E3MSRI462HW7','麦当劳','美国伊利诺伊州芝加哥麦当劳总公司','0839-08235389','麦当劳餐厅在中国大陆早期译名是“麦克唐纳快餐”，直到后期才统一采用现今的港式译名。而在民间，因为麦当劳和“牡丹楼”的音近，牡丹楼也被当作是麦当劳的一个昵称，但并不普遍。','0');


INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#FE8UA2F41GWI','三只松鼠','广东省中山市龙腾路九号电子科技大学中山学院北门111号店','0757-28823048','三只松鼠股份有限公司成立于2012年，是中国第一家定位于纯互联网食品品牌的企业，也是当前中国销售规模最大的食品电商企业。“三只松鼠”品牌一经推出，立刻受到了风险投资机构的青睐，先后获得IDG的150万美金A轮天使投资和今日资本的600万美元B轮投资。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#4EFUA24541HI','良品铺子','湖北省武汉市东西湖区走马岭革新大道8号','0823-88245524','良品铺子是一家集休闲食品研发、加工分装、零售服务的专业品牌连锁运营公司。良品铺子秉承着品质·快乐·家的企业核心价值观，坚持研发高品质产品，不断引进先进的经营管理思想。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#C583A2FS5HWI','优衣库','中国北京五棵松北京卓展购物中心','0675-30275544','UNIQLO（日文假名发音：ユニクロ），日本服装品牌，由日本迅销公司建立于1963年，当年是一家销售西服的小服装店，现已成为国际知名服装品牌。优衣库现任董事长兼总经理柳井正在日本首次引进了大卖场式的服装销售方式，通过独特的商品策划、开发和销售体系来实现店铺运作的低成本化，由此引发了优衣库的热卖潮。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#8ASGY2S55H5A','名创优品','广东省广州市天河区天河路621-625号天娱广场F2号','0122-71279554','MINISO名创优品是广东赛曼投资有限公司在中国商标网注册的品牌 [1]，注册号：16294425 [1]，国际分类：21 [1]，注册日期：2016年06月28日 [1]。MINISO名创优品奉行“简约、自然、富质感”的生活哲学和“回归自然，还原产品本质”的设计主张，秉承“尊重消费者”的品牌精神，致力于为全球消费者提供真正"优质、创意、低价"的产品，在时尚休闲消费前沿市场先后刮起“生活优品消费”之风。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#SQSG9IZ5FHH5','耐克','美国俄勒冈州波特兰市NIKE公司','0498-51649534','耐克商标图案是个小钩子。耐克一直将激励全世界的每一位运动员并为其献上最好的产品视为光荣的任务。耐克首创的气垫技术给体育界带来了一场革命。运用这项技术制造出的运动鞋可以很好地保护运动员的膝盖.在其在作剧烈运动落地时减小对膝盖的影响。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#1XS6GUZ1F4GR','阿迪达斯','德国运动用品制造商阿迪达斯AG成员公司','0336-31285754','阿迪达斯原本由两兄弟共同开设，在分道扬镳后，阿道夫的哥哥鲁道夫·达斯勒（Rudolf Dassler）开设了运动品牌puma。其经典广告语：“没有不可能”（Impossible is nothing）。2011年3月，斥资1.6亿欧元启用全新口号——adidas is all in（全倾全力）。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#0DSQS8U11T6R','屈臣氏','广东省广州市正佳广场二楼','0199-45213484','屈臣氏是长江和记有限公司旗下的国际零售及食品制造机构。集团涉及的商品包括有保健产品、美容产品、香水、化妆品、日用、食品、饮品、电子产品、洋酒及机场零售业务。屈臣氏在中国438个城市拥有超过3,200家店铺和逾6,400万会员，是中国目前最大的保健及美容产品零售连锁店。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#T0G0R3UIUIK7','百佳超市','广东省中山市东区街道兴中道6号假日广场','0915-57294450','百佳自此在内地著著领先，迎合顾客与日俱增的需求，提供一站式购物服务。二○○○年，百佳在广州开设了第一家超级广场，翌年又於广州市繁忙的天河区开设在内地的第一家购物广场。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#3H6MR3U6RIY8','星巴克','美国华盛顿州西雅图星巴克总公司','0274-18215480','星巴克旗下零售产品包括30多款全球顶级的咖啡豆、手工制作的浓缩咖啡和多款咖啡冷热饮料、新鲜美味的各式糕点食品以及丰富多样的咖啡机、咖啡杯等商品。','1');
INSERT INTO Merchant(merchant_id,name,address,phone,info,near) values ('#E3MSRI462HW7','麦当劳','美国伊利诺伊州芝加哥麦当劳总公司','0839-08235389','麦当劳餐厅在中国大陆早期译名是“麦克唐纳快餐”，直到后期才统一采用现今的港式译名。而在民间，因为麦当劳和“牡丹楼”的音近，牡丹楼也被当作是麦当劳的一个昵称，但并不普遍。','1');



CREATE TABLE food(
	id int auto_increment primary key comment '自增长id',
	merchant_id varchar(10) not null comment '商铺唯一标识号',
	name varchar(2000) not null comment '食物名称',
	price varchar(10) not null comment ' 食物价格',
	info varchar(10000) comment '食品描述'
)DEFAULT CHARSET 'utf8';
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','烤鸭','20','好');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','火腿','10','好吃');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','蛋糕','60','很好吃');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','苹果','40','非常好吃');
INSERT INTO food(merchant_id,name,price,info) values ('#fgh15','布丁','90','真的很好吃');



CREATE TABLE attractions(
	id int auto_increment primary key comment '自增长id',
	name varchar(50) not null comment '景点名称',
    address varchar(5000) comment '景点地址',
	price varchar(10) comment '游玩价格',
	info varchar(10000) comment '景点介绍'
)DEFAULT CHARSET 'utf8';
INSERT INTO attractions(name,address,price,info) values ('中山水库','中山','20','好');
INSERT INTO attractions(name,address,price,info) values ('盘龙峡漂流','清远','10','好玩');
INSERT INTO attractions(name,address,price,info) values ('欢乐谷','深圳','60','很好玩');
INSERT INTO attractions(name,address,price,info) values ('长龙水上乐园','广州','40','非常好玩');
INSERT INTO attractions(name,address,price,info) values ('故宫','北京','90','真的很好玩');


CREATE TABLE LostAndFound(
	id int auto_increment primary key comment '自增长id',
	title varchar(50) not null comment '标题名',
	nickname VARCHAR(50) COMMENT '发布者昵称',
	releasetime varchar(50) not null comment '发布时间',
    pagecontect varchar(10000) not null comment '发布内容',
    solve int not null default 0 comment '是否解决 默认未解决为0 解决为1'
)DEFAULT CHARSET 'utf8';
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('1111','冬瓜','2018年1月1日','冬冬冬冬冬冬','0');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('2222','西瓜','2018年2月2日','西西西西西','1');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('3333','南瓜','2018年3月3日','南南南南南','1');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('4444','北瓜','2018年4月4日','北北北北北','0');
INSERT INTO LostAndFound(title,nickname,releasetime,pagecontect,solve) values ('5555','中瓜','2018年5月5日','中中中中中','1');


CREATE TABLE communication(
	id int auto_increment primary key comment '自增长id',
	title varchar(50) not null comment '标题名',
	nickname VARCHAR(50) COMMENT '发布者昵称',
	releasetime varchar(50) not null comment '发布时间',
    pagecontect varchar(10000) not null comment '发布内容'
)default charset 'utf8';
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('aaaa','哈哈','2018年1月1日','哈哈哈哈哈哈哈哈');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('bbbb','呵呵','2018年2月2日','呵呵呵呵呵呵呵呵');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('cccc','嘻嘻','2018年3月3日','嘻嘻嘻嘻嘻嘻嘻嘻');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('dddd','嘿嘿','2018年4月4日','嘿嘿嘿嘿嘿嘿嘿嘿');
INSERT INTO communication(title,nickname,releasetime,pagecontect) values ('eeee','咯咯','2018年5月5日','咯咯咯咯咯咯咯咯');


CREATE TABLE reply(
	id int auto_increment primary key comment '自增长id',
	target int not null comment '回复目标帖id',
	nickname VARCHAR(50) COMMENT '回复者昵称',
	releasetime varchar(50) not null comment '回复时间',
    pagecontect varchar(10000) not null comment '回复者内容'
)default charset 'utf8';
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (1,'小明','2018年1月1日','明明明明明明明明');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (1,'小红','2018年2月2日','红红红红红红红红');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (1,'小明','2018年3月3日','明明明');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (2,'小狗','2018年4月4日','狗狗狗狗狗狗狗狗');
INSERT INTO reply(target,nickname,releasetime,pagecontect) values (2,'小啊','2018年5月5日','啊啊啊啊啊啊啊啊');


CREATE TABLE academic(
	id int auto_increment primary key comment '自增长id',
    types int not null comment ' 1 代表 竞赛信息 2代表科研信息 3代表讲座信息',
    announcer varchar(50) not null comment ' 发布者',
    releasetime varchar(50) not null comment '发布时间',
	pagecontect varchar(10000) not null comment '发布内容',
	validity int not null default 1 comment '有效性 1代表有效 0代表无效'
)default charset 'utf8';

CREATE TABLE form(
	table_id INT auto_increment PRIMARY KEY COMMENT '表格编号',
	user_id int not null conmment'商家id',
	name varchar(100) not null conmment'商家名称',
	place varchar(1000) not null comment'商家位置',
	position varchar(200) not null comment '招聘职位',
	content varchar(20000) not null comment'招聘内容',
	expand_0 varchar(20000) comment '拓展字段零',
    expand_1 varchar(20000) comment '拓展字段一',
	expand_2 varchar(20000) comment '拓展字段二',
	expand_3 varchar(20000) comment '拓展字段三',
	expand_4 varchar(20000) comment '拓展字段四',
	expand_5 varchar(20000) comment '拓展字段五',
	expand_6 varchar(20000) comment '拓展字段六',
	expand_7 varchar(20000) comment '拓展字段七',
	expand_8 varchar(20000) comment '拓展字段八',
	expand_9 varchar(20000) comment '拓展字段九'
)DEFAULT CHARSET "utf8";

create table StudentSend(
	table_id INT auto_increment PRIMARY KEY COMMENT '表格编号',
	user_id int not null conmment'商家id',
	name varchar(100) not null conmment'学生姓名',
	phone varchar(1000) not null comment'学生电话'
	position varchar(200) not null comment '应聘职位',
	content varchar(20000) not null comment'个人简介',
	expand_0 varchar(20000) comment '拓展字段零',
    expand_1 varchar(20000) comment '拓展字段一',
	expand_2 varchar(20000) comment '拓展字段二',
	expand_3 varchar(20000) comment '拓展字段三',
	expand_4 varchar(20000) comment '拓展字段四',
	expand_5 varchar(20000) comment '拓展字段五',
	expand_6 varchar(20000) comment '拓展字段六',
	expand_7 varchar(20000) comment '拓展字段七',
	expand_8 varchar(20000) comment '拓展字段八',
	expand_9 varchar(20000) comment '拓展字段九'
)default charset "utf8";

create table Send(
	table_id INT AUTO_INCREMENT PRIMARY KEY COMMENT '表格编号',
    username varchar(50) not null comment '商户名',
    position varchar(13) not null comment '商户招聘职位',
    infomation varchar(200000) comment '商户兼职信息',
)default charset "utf8";
INSERT INTO Send(username,position,imfomation) values ('良品铺子','销售员','良品铺子你值得拥有');
INSERT INTO Send(username,position,imfomation) values ('中国电信','网维人员','中国电信绝对相信');
INSERT INTO Send(username,position,imfomation) values ('耐克','售后服务员','just do it');
INSERT INTO Send(username,position,imfomation) values ('优衣库','导购','做最好的试衣间');
INSERT INTO Send(username,position,imfomation) values ('名创优品','导购','名创优品你的优品');