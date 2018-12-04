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
    this.showList(this.left_num,this.left_list,1);
}
communicationObj.prototype.showList = function (num,obj,flag) {
    var len = Math.floor(num / 2);
    var max = Math.floor(obj.length / 2);
    if (len == 0 || len == 1) {
        $('.pager > li').eq(0).attr('class', 'disabled');
        if (flag == 0)
            return;
    } else if (len == max) {
        $('.pager > li').eq(1).attr('class', 'disabled');
        $('.pager > li').eq(0).attr('class', '');
        if (flag == 1)
            return;
    } else {
        $('.pager > li').eq(1).attr('class', '');
        $('.pager > li').eq(0).attr('class', '');
    }
    $('#content').children().remove();
    if (flag == 0) {
        for (var i = (len - 2) * 2; i <= (len - 1) * 2 - 1; i++) {
            this.createList('content',i, this.left_list);
        }
        this.num -= 2;
    } else {
        for (var i = len * 2; i < (len + 1) * 2; i++) {
            this.createList('content',i, this.left_list);
            this.num++;
        }
    }
    if (Math.floor(this.num / 2) == 1) {
        $('.pager > li').eq(0).attr('class', 'disabled');
        $('.pager > li').eq(1).attr('class', '');
        if (flag == 0)
            return;
    } else if (Math.floor(this.num / 2) == max) {
        $('.pager > li').eq(1).attr('class', 'disabled');
        $('.pager > li').eq(0).attr('class', '');
        if (flag == 1)
            return;
    } else {
        $('.pager > li').eq(1).attr('class', '');
        $('.pager > li').eq(0).attr('class', '');
    }
}

function showInformation(obj) {
    var id = obj.parentNode.id;
    $('.panel-body').find('h1').html(this.left_list[id].title);
    $('.panel-body').find('h3').eq(0).html('作者：' + this.left_list[id].nickname + '<small>' + this.left_list[id].releasetime + '</small>');
    $('.panel-body').find('p').eq(0).html(this.left_list[id].pagecontect);

    if (communication.flag == 0) {
        $('.modal-right').hide();
        $('.modal-left').attr('class','modal-left col-md-8 col-md-offset-2');
    } else {
        $('.modal-right').show();
        $('.modal-left').attr('class','modal-left col-md-8');
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
    li.attr('id', id);
    span_sort.attr('class', 'badge');
    span_time.attr('class', 'badge');
    span_time.html(array[id].releasetime);
    small.html('作者：' + array.nickname);
    if (this.flag == 0) {
        if (array[id].solve == 1) {
            span_sort.html('已解决');
        } else {
            span_sort.html('未解决');
        }
    } else {
        span_sort.html('交流');
    }
    a.html(array[id].title);
    a.attr('onclick', 'showInformation.apply(communication,[this])');

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $('#content').append(li);
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
            alert('网络出现问题，无法提交');
        }
    })
}

function seeList(){

    $('#modal-list').modal();
    $('self-list')
}