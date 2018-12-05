function formPush() {
    const title = $('#title').val();
    const content = $('#content').val();
    const url = $('#sort').val() == 0 ? "WritingLostAndFoundServlet" : "WritingCommunicationServlet";
    const date = new Date();
    const year = date.getUTCFullYear();
    const month = date.getUTCMonth();
    const day = date.getUTCDate();
    const time = year + "年" + month + "月" + day + "日";
    if(!checkText(title,content)){
        return;
    }
    
    let map = new Map();
    map.set("title", title);
    map.set("releasetime", time);
    map.set("pagecontect", content);

    if (url == 'WritingCommunicationServlet') {
        sendForm(map,url,'post');
    } else {
        $.ajax({
            url: url,
            type: "post",
            dataType: "json",
            data: {
                "title": title,
                "nickname": "damu",
                "releasetime": time,
                "pagecontect": content,
            },
            success: function (res) {
                if (res.result == 'success') {
                    alert('发布成功，正在跳转');
                    setTimeout(location.href = "communication.jsp",1000);
                } else {
                    alert('发布失败!');
                }

            },
            error: function () {
                // alert("发布失败，网络问题！");
            }
        });
    }
}
//虚拟表单
function sendForm(param_map, url, method){
    var form = document.createElement("form");
    form.setAttribute("action", url);
    form.setAttribute("method", method);
    form.style.display = "none";
    
    //追加参数
    for(var entry of param_map){
        var param_input = document.createElement("input");
        param_input.setAttribute("type", "text");
        
        param_input.setAttribute("name", entry[0]);
        param_input.setAttribute("value", entry[1]);
        form.appendChild(param_input);
    }
    
    //body追加form表单
    document.body.appendChild(form);
    
     form.submit();//提交(注意，这里的提交调用者是form表单，不是submit按钮)
}
//加载信息
function loadInformation() {
    var wScrollY = window.scrollY;
    var wInnerH = window.innerHeight;
    var bScrollH = document.body.scrollHeight;
    if (wScrollY + wInnerH >= bScrollH) {
        news.init();
    }
}
//函数防抖动
function debounce(fn, delay) {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        clearTimeout(timer);
        timer = setTimeout(function () {
            fn.apply(context, args);
        }, delay);
    }
}
function formEmpty() {
    document.getElementsByName('title')[0].value = null;
    document.getElementsByName('content')[0].value = null;
}

function checkText(title,content) {
    if($.isEmptyObject(title) || $.isEmptyObject(content))
    {
        return false;
    }
    return true;
}
document.getElementById('submit').addEventListener('onclick', debounce(formPush, 50000));