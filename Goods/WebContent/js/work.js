var workObj = function () {
    this.right_list = new Array();  //所有json
	this.self_list = new Array();  //查看自己的
    this.right_num = 0;
	this.self_num = 0;
	this.self_length = 0;
    this.right_flag = 1;
	this.self_flag = 1;
}
var self_num = 0;
var students = new Array(); //存储学生简历
var jusristion = -1;  //用户权限
//初始化函数
workObj.prototype.init = function () {
    this.requireList();
}
workObj.prototype.setList = function (obj) {
    this.right_list = obj.context;
    this.right_num=this.showList(this.right_list,this.right_num,'.right-list',1,this.right_flag);
}
//请求数据
workObj.prototype.requireList = function () {
    let work = this;
    $.ajax({
        url: "getUserTableServlet",
        type: "post",
        dataType: "JSON",
        data: {},
        success: function (res) {
            let json = eval(res);
            console.log(res);
            work.setList(json);
        },
        error: function () {
            alert("网络中断，未能响应服务器请求!");
        }
    });
}
//上一页点击事件
function previous(flag) {
    if(flag == 0) {
        this.right_num = this.showList(this.right_list,this.right_num,'.right-list',0,this.right_flag);
	}
}
//下一页点击事件
function next(flag) {
    if(flag == 0) {
        this.right_num = this.showList(this.right_list,this.right_num,'.right-list',1,this.right_flag);
    }
}
//显示信息,0上一页，1下一页
workObj.prototype.showList = function (list,num,name,flag,sort) {
     let page = Math.floor(list.length / 2) < 6 ? Math.floor(list.length / 2) : 6;
    var max = list.length;
    var len = num;
    let morepage = 0;
     if (flag == 0) {
        if (max <= len && max % page != 0) {
            morepage = max % page;
        } else if (len == 0 || len == page) {
            return num;
        }
        $(name + '> #content').children().remove();
        if (len % page == 0) {
            for (var i = len - page * 2; i < len - page; i++) {
                this.createList(name + '> #content', i, list, sort);
            }
            num -= page;
        } else{
            for (var i = len -page - morepage; i < len - morepage; i++) {
                this.createList(name + '> #content', i, list, sort);
            }
            num = len - 1;
        }
    } else {
        if (max <= len) {
            return num;
        } else if (max - len < page) {
            page = max - len;
        }
        $(name + '> #content').children().remove();
        for (var i = len; i < len + page; i++) {
            this.createList(name + '> #content', i, list, sort);
            num++;
        }
    }
    return pageCheck(name, num, max, page);
}
function pageCheck(name, num, max, page) {
    if (Math.floor(num / page) == 1) {
        $(name + '> .pager > li').eq(0).attr('class', 'disabled');
        $(name + '> .pager > li').eq(1).attr('class', '');
        if (flag == 0)
            return num;
    } else if (num == max) {
        $(name + '> .pager > li').eq(1).attr('class', 'disabled');
        $(name + '> .pager > li').eq(0).attr('class', '');
        if (flag == 1)
            return num;
    } else {
        $(name + '> .pager > li').eq(1).attr('class', '');
        $(name + '> .pager > li').eq(0).attr('class', '');
    }
    return num;
}
//动态创建，创建元素的同时，将数据绑定。
workObj.prototype.createList = function (id,count,array,sort) {
    var li = $('<li></li>');
    var span_sort = $('<span></span>');
    var span_time = $('<span></span>');
    var small = $('<small></small>');
    var a = $('<a></a>');

    li.attr('class', 'list-group-item');;
    li.attr('id', count);
    span_sort.attr('class', 'badge');  //发布类型
    span_time.attr('class', 'badge');   //发布时间
    span_time.html(array[count].position);
    // small.html('作者：' + array.nickname);
    span_sort.html('兼职');
    a.html(array[count].title);  //兼职title 
    a.attr('onclick', 'showInformation.apply(work,[this])');

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $(id).append(li);
}
//详情页
function showInformation(obj) {
    var id = obj.parentNode.id;
    $('#modal-info').find('h1').html(this.right_list[id].title);
    $('#modal-info').find('h3').eq(0).html('商家：' + this.right_list[id].shopname +"&nbsp;&nbsp;" +'<small>' +'职位：'+ this.right_list[id].position + '</small>');
    $('#modal-info').find('p').eq(0).html('<p class="text-center">'+this.right_list[id].content+'</p>'+'<p class="text-left">'+'联系人：'+this.right_list[id].linkman+'</p>' + '<p class="text-left">'+'联系方式：'+this.right_list[id].phone+'</p>' + '<p class="text-left">'+'地址：'+this.right_list[id].address+'</p>');
    $('#modal-info').modal();

    $('#final').on('click', function () {
        obj.style.color = 'black';
        this.setAttribute('data-dismiss', 'modal');
    });

}
//查看个人发布
function seeList(){
    this.self_num = 0;
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    if(sessionText == 'null'){
        alert("请先登录");
        return;
    } 
    sort.apply(this);
}
function sort(){
    $.ajax({
        url:'ChoosemyselfServlet',
        type:'post',
        dataType:'json',
        data:{
        },
        success:function(res){
            let json = eval(res);
            console.log(json);
            if($.isEmptyObject(json.querySelfResult)){
                alert("没有相关信息");
                return false;
            }else{
               setSelftList(json);
            }
        },
    });

}
function setSelftList(obj){
	this.self_list = obj.querySelfResult;
	this.self_length = obj.querySelfResult.length;
	jusristion = obj.jusristion;
	//如果是权限是学生 就执行  否则不管
	if(jusristion == 1){
		for(i = 0; i < this.self_length; i++){
				for(j = 0 ;j < this.self_list[i][0].students.length; j++){
					if(this.self_list[i][0].students[j].target == this.self_list[i][0].table_id){
						students[i] = this.self_list[i][0].students[j];
						console.log(students[i]);
					}
				}
			}
		showSelfInfomation(this.self_list,self_num);
		} else if(jusristion == 3){
			showSelfInfomation(this.self_list,self_num);	
		}
}
function showSelfInfomation(list,num){
	$('.modal-right > #comment').children().remove();
	$('.modal-left').find('h2').html(list[num][0].title);
	$('.modal-left').find('h3').html('商家：' + list[num][0].shopname + '&nbsp;&nbsp;' + '<small>' + '职位：' + list[num][0].position + '</small>');
	$('.modal-left').find('p').html('<p class="text-center">'+list[num][0].content+'</p>'+'<p class="text-left">'+'联系人：'+list[num][0].linkman+'</p>' + '<p class="text-left">'+'联系方式：'+list[num][0].phone+'</p>' + '<p class="text-left">'+'地址：'+list[num][0].address+'</p>');
	
	//如果是学生执行
	if(jusristion == 1){
		var div = $('<div></div>');
		div.attr('class', 'list-group-item');
		
		var h4 = $('<h4></h4>');
		h4.attr('class', 'text-center');
		h4.html('姓名：' + students[num].name);
		
		var divchirld = $('<div></div>');
		divchirld.attr('class','text-left');
		var p_sex = $('<p></p>');
		p_sex.html('性别：' + students[num].sex);
		var p_age = $('<p></p>');
		p_age.html('年龄：' + students[num].age);
		var p_phone = $('<p></p>');
		p_phone.html('电话：' + students[num].phone);
		var p_content = $('<p></p>');
		p_content.html('自我介绍：' + students[num].content);
		
		divchirld.append(p_sex);
		divchirld.append(p_age);
		divchirld.append(p_phone);
		divchirld.append(p_content);
		div.append(h4);
		div.append(divchirld);
		
		$('#comment').append(div); 
	}else if(jusristion == 3){ //商家
	for(selflist of list[num][0].students){
		var div = $('<div></div>');
		div.attr('class', 'list-group-item');
		
		var h4 = $('<h4></h4>');
		h4.attr('class', 'text-center');
		h4.html('姓名：' + selflist.name);
		
		var divchirld = $('<div></div>');
		divchirld.attr('class','text-left');
		var p_sex = $('<p></p>');
		p_sex.html('性别：' + selflist.sex);
		var p_age = $('<p></p>');
		p_age.html('年龄：' + selflist.age);
		var p_phone = $('<p></p>');
		p_phone.html('电话：' + selflist.phone);
		var p_content = $('<p></p>');
		p_content.html('自我介绍：' + selflist.content);
		
		divchirld.append(p_sex);
		divchirld.append(p_age);
		divchirld.append(p_phone);
		divchirld.append(p_content);
		div.append(h4);
		div.append(divchirld);
		
		$('#comment').append(div); 
	}
		
	}
	
	$('#modal-list').modal();
}
//返回上一条
function previousinfo(){
	if(self_num > 0){
	    self_num -= 1;
		showSelfInfomation(this.self_list,self_num);
	} else  if(self_num ==0){
		$('.modal-left > .pager .navbar-fixed-bottom > .li').attr('class','disabled');
	}
}



//下一条
function nextinfo(){
	if(self_num < this.self_length - 1){
		self_num += 1;
		showSelfInfomation(this.self_list,self_num);
	} else if(self_num == this.self_length - 1){
		$('.modal-left > .pager .navbar-fixed-bottom > .li').attr('class','disabled');
	}
}
 islogin = function(){
	var session = $.trim(document.getElementById('username').innerHTML);
	if(session == 'null'){
		return false;
	}
	return true;
}
//发布兼职
submitwork = function(){
	if(!islogin()){
		alert('请先登录');
		return;
	}else{
		location.href='workissue.jsp';
	}
}



//兼职应聘
applywork = function(){
	if(!islogin()){
		alert('请先登录');
		return;
	}else {
		$('#modal-contribute').modal();
	}
}
function workformSubmit(){
	const name = $('#name').val();
	const age = $('#age').val();
	const sex = $('#sex').find("option:selected").text();
	const phone = $('#phone').val();
	const content = $('#selfcontent').val();
	const url = "studentSendServlet";
	if(!checkText(name,age,phone,content)){
		alert("请填写完整的字段！");
		return;
	}
	
	let map = new Map();
	map.set("name",name);
	map.set("age",age);
	map.set("sex",sex);
	map.set("phone",phone);
	map.set("content",content);
	sendForm(map, url , 'post');
}
function sendForm(param_map, url, method){
	var form = document.createElement("form");
	form.setAttribute("action", url);
	form.setAttribute("method",method);
	form.style.display = "none";
	for(var entry of param_map){
		var param_input = document.createElement("input");
		param_input.setAttribute("type","text");
		param_input.setAttribute("name",entry[0]);
		param_input.setAttribute("value",entry[1]);
		form.appendChild(param_input);
	}
	document.body.appendChild(form);
	form.submit();
}
function checkText(name,age,phone,content){
	if($.isEmptyObject(name) || $.isEmptyObject(age) || $.isEmptyObject(phone) || $.isEmptyObject(content)){
		return false;
	}
	return true;
}
//函数防抖动
function debounce(fn,delay){
	let timer = null;
	return function(){
		let context = this;
		let args = arguments;
		clearTimeout(timer);
		timer = setTimeout(function() {
			fn.apply(context,args);
		},delay);
	}
}
//document.getElementById('submit').addEventListener('onclick',debounce(workformSubmit,50000));