
function formSumbit(){
	
	const title = $('#title').val();
	const shopname = $('#shopname').val();
	const position = $('#position').val();
	const address = $('#address').val();
	const linkman = $('#linkman').val();
	const phone = $('#phone').val();
	const content = $('#content').val();
	
	const url = "userSendServlet";
	if(!checkText(title,shopname,position,address,linkman,phone,content)){
		alert("请输入完整的字段！");
		return;
	}
	
	let map = new Map();
	map.set("title",title);
	map.set("shopname",shopname);
	map.set("position",position);
	map.set("address",address);
	map.set("linkman",linkman);
	map.set("phone",phone);
	map.set("content",content);
	console.log(map);
	sendForm(map, url, 'post');
	
//	$.ajax({
//		url: url,
//		type: "post",
//		dataType: "json",
//		data:{
//		   "title": title,
//		   "shopname": shopname,
//			"position": position,
//			"address": address,
//			"linkman": linkman,
//			"phone": phone,
//			"content": content
//		},
//		success: function(res){
//			if(res.result == 'success'){
//				alert("发布成功，正在跳转");
//					setTimeout(location.href = "work.jsp",1000);
//				}else {
//					alert("发布失败！");
//				}
//			},
//		error: function(){
//			alert("发布失败,网络问题!");
//		}
//	});
	
}
//提交虚拟表单
function sendForm(param_map, url, method){
	var form = document.createElement("form");
	form.setAttribute("action", url);
	form.setAttribute("method", method);
	form.style.display = "none";
	
	//追加参数
	for(var entry of param_map){
		var param_input = document.createElement("input");
		param_input.setAttribute("type","text");
		param_input.setAttribute("name",entry[0]);
		param_input.setAttribute("value",entry[1]);
		form.appendChild(param_input);
	}
	//body追加form表单
	document.body.appendChild(form);
	form.submit();
}
//加载信息
function loadInformation(){
	var wSrolly = window.scrollY;
	var wInnerH = window.innerHeight;
	var bScrollh = window.body.scrollHeight;
	if(wSrolly + wInnerH >= bScrollh){
		news.init();
	}
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
//内容清空
function formClear(){
	document.getElementsByName('title')[0].value = null;
	document.getElementsByName('shopname')[0].value = null;
	document.getElementsByName('position')[0].value = null;
	document.getElementsByName('address')[0].value = null;
	document.getElementsByName('linkman')[0].value = null;
	document.getElementsByName('phone')[0].value = null;
	document.getElementById('content').value = null;

}
function checkText(title,shopname,position,address,linkman,phone,content){
	if($.isEmptyObject(title) || $.isEmptyObject(shopname) || $.isEmptyObject(position) || $.isEmptyObject(address) || $.isEmptyObject(linkman) || $.isEmptyObject(phone) || $.isEmptyObject(content)){
		return false;
	}
	return true;
}
//document.getElementById('submit').addEventListener('onclick',debounce(formSumbit,50000));