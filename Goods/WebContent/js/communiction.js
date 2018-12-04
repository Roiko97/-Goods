var communicationObj = function () {
    this.left_list = new Array();
    this.self_list = new Array();
    this.left_num = 0;
    this.self_num = 0;
    this.flag = 1;
}


communicationObj.prototype.init = function () {
    if (this.flag == 0) {
        $('.page-header > h2').html('失物招领');
        $('.page-header > p').html('物归原主，善良至真');
    } else {
        $('.page-header > h2').html('交流');
        $('.page-header > p').html('沟通产生美');

    }
    this.requirList();
}

communicationObj.prototype.setList = function (obj) {
    if (this.flag == 0) {
        this.left_list = obj.lostAndFound;
    } else {
        this.left_list = obj.communication;
    }
    console.log(this.left_list);
    this.left_num = this.showList(this.left_list,this.left_num,'.left-part',1);
}
function previous(flag){
    if(flag == 0){
        this.left_num = this.showList(this.left_list,this.left_num,'.left-part',0)
    }else{
        this.self_num = this.showList(this.self_list,this.self_num,'#modal-list',0)
    }

}

function next(flag){
    if(flag == 0){
        this.left_num = this.showList(this.left_list,this.left_num,'.left-part',1)
    }else{
        this.self_num = this.showList(this.self_list,this.self_num,'#modal-list',1)
    }
}

communicationObj.prototype.showList = function (list,num,name,flag) {
    var len = Math.floor(num / 2);
    var max = Math.floor(list.length / 2);
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
        for (var i = (len - 2) * 2; i <= (len - 1) * 2 - 1; i++) {
            this.createList(name +'> .content',i, list);
        }
        num -= 2;
    } else {
        for (var i = len * 2; i < (len + 1) * 2; i++) {
            this.createList(name +'> .content',i, list);
            num++;
        }
    }
    if (Math.floor(num / 2) == 1) {
        $(name+'> .pager > li').eq(0).attr('class', 'disabled');
        $(name+'> .pager > li').eq(1).attr('class', '');
        if (flag == 0)
            return num;
    } else if (Math.floor(num / 2) == max) {
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

    if (communication.flag == 0) {
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
    if (this.flag == 0) {
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
communicationObj.prototype.createList = function (id,count, array) {

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
    if (this.flag == 0) {
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
    sort.apply(this,[0]);
    $('#modal-list').modal();
}
function showSlefList(){
    this.self_num = this.showList(this.self_list,this.self_num,'#modal-list',1)
}
function sort(flag){
    let choose;
    if(flag == 0){
        choose = "laf";
    }else{
        choose = "com";
    }
    let that = this;
    $.ajax({
        url:'QueryMyselfServlet',
        type:'post',
        dataType:'json',
        data:{
            'choose':choose,
        },
        success:function(res){
            let json = eval(res);
            console.log(res);
            that.self_list = json;
            showSlefList.apply(that,[]);
        },
    });

}