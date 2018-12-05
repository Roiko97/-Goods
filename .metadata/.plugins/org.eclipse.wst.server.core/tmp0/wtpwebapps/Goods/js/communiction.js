var communicationObj = function () {
    this.left_list = new Array();
    this.self_list = new Array();
    this.left_num = 0;
    this.self_num = 0;
    this.left_flag = 1;
    this.self_flag = 1;
}


communicationObj.prototype.init = function () {
    if (this.left_flag == 0) {
        $('.page-header > h2').html('失物招领');
        $('.page-header > p').html('物归原主，善良至真');
    } else {
        $('.page-header > h2').html('交流');
        $('.page-header > p').html('沟通产生美');

    }
    this.requirList();
}

communicationObj.prototype.setList = function (obj) {
    if (this.left_flag == 0) {
        this.left_list = obj.lostAndFound;
    } else {
        this.left_list = obj.communication;
    }
    this.left_num = this.showList(this.left_list,this.left_num,'.left-part',1,this.left_flag);
}
function previous(flag){
    if(flag == 0){
        this.left_num = this.showList(this.left_list,this.left_num,'.left-part',0,this.left_flag);
    }else{
        this.self_num = this.showList(this.self_list,this.self_num,'.self-list',0,this.self_flag);
    }

}

function next(flag){
    if(flag == 0){
        this.left_num = this.showList(this.left_list,this.left_num,'.left-part',1,this.left_flag);
    }else{
        this.self_num = this.showList(this.self_list,this.self_num,'.self-list',1,this.self_flag);
    }
}

communicationObj.prototype.showList = function (list,num,name,flag,sort) {
    let page = 2;
    if(list.length % 2 == 0){
        page = 2;
    }else{
        page = 3;
    }
    var max = Math.floor(list.length / page);
    var len = Math.floor(num / page);
    if (len == 0 || len == 1) {
        $(name+'> .pager > li').eq(0).attr('class', 'disabled');
        if (flag == 0)
            return num;
    } else if (len == max) {
        $(name+'> .pager > li').eq(1).attr('class', 'disabled');
        $(name+'> .pager > li').eq(0).attr('class', '');
        if (flag == 1)
            return num;
    } else {
        $(name+'> .pager > li').eq(1).attr('class', '');
        $(name+'> .pager > li').eq(0).attr('class', '');
    }
    $(name +'> .content').children().remove();
    if (flag == 0) {
        for (var i = (len - 2) * page; i <= (len - 1) * page - 1; i++) {
            this.createList(name +'> .content',i, list,sort);
        }
        num -= page;
    } else {
        for (var i = len * page; i < (len + 1) * page; i++) {
            this.createList(name +'> .content',i, list,sort);
            num++;
        }
    }
    if (Math.floor(num / page) == 1) {
        $(name+'> .pager > li').eq(0).attr('class', 'disabled');
        $(name+'> .pager > li').eq(1).attr('class', '');
        if (flag == 0)
            return num;
    } else if (Math.floor(num / page) == max) {
        $(name+'> .pager > li').eq(1).attr('class', 'disabled');
        $(name+'> .pager > li').eq(0).attr('class', '');
        if (flag == 1)
            return num;
    } else {
        $(name+'> .pager > li').eq(1).attr('class', '');
        $(name+'> .pager > li').eq(0).attr('class', '');
    }
    return num;
}

function showInformation(obj) {
    var id = obj.parentNode.id;
    $('#modal-info').find('h1').html(this.left_list[id].title);
    $('#modal-info').find('h3').eq(0).html('作者：' + this.left_list[id].nickname + '<small>' + this.left_list[id].releasetime + '</small>');
    $('#modal-info').find('p').eq(0).html(this.left_list[id].pagecontect);

    for(list of this.left_list[id].reply)
    {
        var div = $('<div></div>');
        div.attr('class','list-group-item');

        var h4 = $('<h4></h4>');
        h4.html(list.nickname);

        var time = $('<p></p>');
        time.attr('class','text-muted time text-right');
        time.html(list.releasetime);

        var comment = $('<p></p>');
        comment.attr('class','text-left');
        comment.html(list.pagecontect);

        div.append(h4);
        div.append(time);
        div.append(comment);

        $('#comment').append(div);
    }

    if (communication.left_flag == 0) {
        $('#modal-info > .modal-right').hide();
        $('#modal-info > .modal-left').attr('class','modal-left col-md-8 col-md-offset-2');
    } else {
        $('#modal-info > .modal-right').show();
        $('#modal-info > .modal-left').attr('class','modal-left col-md-8');
    }

    $('#modal-info').modal();

    $('#final').on('click', function () {
        obj.style.color = 'black';
        this.setAttribute('data-dismiss', 'modal');
    });

    $('#submit').attr('onclick','sendReply.apply(communication,['+id+'])');
}
communicationObj.prototype.requirList = function () {
    let com = this;
    var url;
    if (this.left_flag == 0) {
        url = 'LostAndFoundServlet';
    } else {
        url = 'CommunicationServlet';
    }
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data: {},
        success: function (res) {
            let json = eval(res);
            console.log(res);
            com.setList(json);
        },
        error: function () {
            alert('网络中断，未能响应服务器请求！');
        }
    })
}
communicationObj.prototype.createList = function (id,count, array,sort) {
    var li = $('<li></li>');
    var span_sort = $('<span></span>');
    var span_time = $('<span></span>');
    var small = $('<small></small>');
    var a = $('<a></a>');

    li.attr('class', 'list-group-item');;
    li.attr('id', count);
    span_sort.attr('class', 'badge');
    span_time.attr('class', 'badge');
    span_time.html(array[count].releasetime);
    small.html('作者：' + array.nickname);
    if (sort == 0) {
        if (array[count].solve == 1) {
            span_sort.html('已解决');
        } else {
            span_sort.html('未解决');
        }
    } else {
        span_sort.html('交流');
    }
    a.html(array[count].title);
    a.attr('onclick', 'showInformation.apply(communication,[this])');

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $(id).append(li);
}

function sendReply(id) {
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    if(sessionText == 'null'){
        alert('请先登录');
        return ;
    }
    let content = $('#comment-cont').val();
    const date = new Date();
    const year = date.getUTCFullYear();
    const month = date.getUTCMonth();
    const day = date.getUTCDate();
    const time = year + "年" + month + "月" + day + "日";
    $.ajax({
        url: 'ReplyServlet',
        type: 'post',
        dataType: 'json',
        data: {
            'target':Number(this.left_list[id].id),
            'releasetime':time,
            'pagecontect':content,
        },
        success: function (res) {
            console.log(res);
        },
        error: function () {
            alert('无法连接，请先登录');
        }
    })
}

function seeList(){
    this.self_num = 0;
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    if(sessionText == 'null'){
        alert('请先登录');
        return ;
    }
    sort.apply(this,[0]);
    
}
function showSlefList(){
    this.self_num = this.showList(this.self_list,this.self_num,'.self-list',1,this.self_flag);
    $('#modal-list').modal();
}
function sort(flag){
    let choose;
    if(flag == 0){
        choose = "laf";
        this.self_flag = 0;
    }else{
        choose = "com";
        this.self_flag = 1;
    }
    let that = this;
    console.log(choose);
    $.ajax({
        url:'QueryMyselfServlet',
        type:'post',
        dataType:'json',
        data:{
            'choose':choose,
        },
        success:function(res){
            let json = eval(res);
            console.log(json);
            if($.isEmptyObject(json.queryResult)){
                alert("未发布相关信息");
                return false;
            }else{
                that.self_list = json.queryResult;
                showSlefList.apply(that,[]);
            }
        },
    });

}