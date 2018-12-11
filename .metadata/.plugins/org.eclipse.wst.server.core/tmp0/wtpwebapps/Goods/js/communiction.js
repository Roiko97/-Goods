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
    this.left_num = this.showList(this.left_list, this.left_num, '.left-part', 1, this.left_flag);
}

function previous(flag) {
    if (flag == 0) {
        this.left_num = this.showList(this.left_list, this.left_num, '.left-part', 0, this.left_flag);
    } else {
        this.self_num = this.showList(this.self_list, this.self_num, '.self-list', 0, this.self_flag);
    }

}

function next(flag) {
    if (flag == 0) {
        this.left_num = this.showList(this.left_list, this.left_num, '.left-part', 1, this.left_flag);
    } else {
        this.self_num = this.showList(this.self_list, this.self_num, '.self-list', 1, this.self_flag);
    }
}

communicationObj.prototype.showList = function (list, num, name, flag, sort) {
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
        $(name + '> .content').children().remove();
        if (len % page == 0) {
            for (var i = len - page * 2; i < len - page; i++) {
                this.createList(name + '> .content', i, list, sort);
            }
            num -= page;
        } else{
            for (var i = len -page - morepage; i < len - morepage; i++) {
                this.createList(name + '> .content', i, list, sort);
            }
            num = len - 1;
        }
    } else {
        if (max <= len) {
            return num;
        } else if (max - len < page) {
            page = max - len;
        }
        $(name + '> .content').children().remove();
        for (var i = len; i < len + page; i++) {
            this.createList(name + '> .content', i, list, sort);
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

function showInformation(obj, name) {
    var id = obj.parentNode.id;
    let flag = 0;
    let array = '';
    if (name == 'left') {
        flag = this.left_flag;
        array = this.left_list;
    } else {
        flag = this.self_flag;
        array = this.self_list;
    }
    $('#modal-info').find('h1').html(array[id].title);
    $('#modal-info').find('h3').eq(0).html('作者：' + array[id].nickname + '<small>' + array[id].releasetime + '</small>');
    $('#modal-info').find('p').eq(0).html(array[id].pagecontect);

    if (flag == 0) {
        lafShow();
    } else {
        comShow(array, id);
    }

    $('#modal-info').modal();

    $('#final').on('click', function () {
        obj.style.color = 'black';
        this.setAttribute('data-dismiss', 'modal');
    });

    $('#submit').attr('onclick', 'sendReply.apply(communication,[' + id + '])');
}

function lafShow() {
    $('#modal-info').find('.modal-right').hide();
    $('#modal-info').find('.modal-left').attr('class', 'modal-left col-md-8 col-md-offset-2');
}

function comShow(array, id) {
    $('#modal-info').find('.modal-right').show();
    $('#modal-info').find('.modal-left').attr('class', 'modal-left col-md-8');
    for (list of arry[id].reply) {
        var div = $('<div></div>');
        div.attr('class', 'list-group-item');

        var h4 = $('<h4></h4>');
        h4.html(list.nickname);

        var time = $('<p></p>');
        time.attr('class', 'text-muted time text-right');
        time.html(list.releasetime);

        var comment = $('<p></p>');
        comment.attr('class', 'text-left');
        comment.html(list.pagecontect);

        div.append(h4);
        div.append(time);
        div.append(comment);

        $('#comment').append(div);
    }
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
communicationObj.prototype.createList = function (id, count, array, sort) {
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
    let str = id.split('-')[0];
    str = str.split('.')[1];
    a.attr('onclick', "showInformation.apply(communication,[this,'" + str + "'])");

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $(id).append(li);
}

function sendReply(id) {
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    if (sessionText == 'null') {
        alert('请先登录');
        $("#login-Modal").modal();
        return;
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
            'target': Number(this.left_list[id].id),
            'releasetime': time,
            'pagecontect': content,
        },
        success: function (res) {
            console.log(res);
        },
        error: function () {
            alert('无法连接，请先登录');
        }
    })
}

function seeList() {
    this.self_num = 0;
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    if (sessionText == 'null') {
        alert('请先登录');
        $("#login-Modal").modal();
        return;
    }
    sort.apply(this, [0]);

}

function showSlefList() {
    this.self_num = this.showList(this.self_list, this.self_num, '.self-list', 1, this.self_flag);
    $('#modal-list').modal();
}

function sort(flag) {
    let choose;
    if (flag == 0) {
        choose = "laf";
        this.self_flag = 0;
    } else {
        choose = "com";
        this.self_flag = 1;
    }
    this.self_num = 0;
    let that = this;
    console.log(choose);
    $.ajax({
        url: 'QueryMyselfServlet',
        type: 'post',
        dataType: 'json',
        data: {
            'choose': choose,
        },
        success: function (res) {
            let json = eval(res);
            console.log(json);
            if ($.isEmptyObject(json.queryResult)) {
                alert("未发布相关信息");
                return false;
            } else {
                that.self_list = json.queryResult;
                showSlefList.apply(that, []);
            }
        },
    });

}