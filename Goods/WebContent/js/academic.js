var academicObj = function () {
    this.right_list = new Array();
    this.self_list = new Array();
    this.right_num = 0;
    this.self_num = 0;
    this.right_flag = 1;
    this.self_flag = 1;
}

academicObj.prototype.competition = function () {
    this.right_flag = 1;
    this.init();
}
academicObj.prototype.science = function () {
    this.right_flag = 2;
    this.init();
}
academicObj.prototype.chair = function () {
    this.right_flag = 3;
    this.init();
}

academicObj.prototype.init = function () {
    let flag = this.right_flag;
    $('.nav-tabs > li').removeClass();
    if (flag == 1) {
        $('.nav-tabs > li').eq(0).attr('class', 'active');
    } else if (flag == 2) {
        $('.nav-tabs > li').eq(1).attr('class', 'active');
    } else {
        $('.nav-tabs > li').eq(2).attr('class', 'active');
    }
    this.requirList(this.right_flag);
}
var title = (function getTitle() {
    return $('title').attr('title');
}());

academicObj.prototype.setList = function (obj) {
    this.right_list = obj.allAcademic;
    if (title != 'table') {
        this.right_num = this.showList(this.right_list, this.right_num, '.right-part', 1, this.right_flag);
    } else {
        return;
    }
}

function previous(flag) {
    if (flag == 0) {
        this.right_num = this.showList(this.right_list, this.right_num, '.right-part', 0, this.right_flag);
    } else {
        this.self_num = this.showList(this.self_list, this.self_num, '.self-list', 0, this.self_flag);
    }

}

function next(flag) {
    if (flag == 0) {
        this.right_num = this.showList(this.right_list, this.right_num, '.right-part', 1, this.right_flag);
    } else {
        this.self_num = this.showList(this.self_list, this.self_num, '.self-list', 1, this.self_flag);
    }
}

academicObj.prototype.showList = function (list, num, name, flag, sort) {
    let page = Math.floor(list.length / 2) < 6 ? Math.floor(list.length / 2) : 6;
    var max = list.length;
    var len = num;
    let morpage = 0;
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
    if (name == 'right') {
        flag = this.right_flag;
        array = this.right_list;
    } else {
        flag = this.self_flag;
        array = this.self_list;
    }
    $('#modal-info').find('h1').html(array[id].title);
    $('#modal-info').find('h3').eq(0).html('作者：' + array[id].name + '<small>' + array[id].stoptime + '</small>');
    $('#modal-info').find('p').eq(0).html(array[id].pagecontect);


    $('#modal-info').modal();

    $('#final').on('click', function () {
        obj.style.color = 'black';
        this.setAttribute('data-dismiss', 'modal');
    });

    $('#apply').on('click', function () {
        location.href = "./table.jsp?flag=1&id=" + id+"&types="+flag;
    });
}
academicObj.prototype.requirList = function (types) {
    let that = this;
    var url = 'GetAcademicInfoServlet';
    $.ajax({
        url: url,
        type: 'post',
        dataType: 'json',
        data: {
            'types': Number(types),
        },
        success: function (res) {
            let json = eval(res);
            if ($.isEmptyObject(json.allAcademic)) {
                alert('数据异常！');
                return;
            }
            that.setList(json);
        },
        error: function () {
            alert('网络中断，未能响应服务器请求！');
        }
    })
}
academicObj.prototype.createList = function (id, count, array, sort) {
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
    if (sort == 1) {
        span_sort.html('竞赛');
    } else if (sort == 2) {
        span_sort.html('科研');
    } else {
        span_sort.html('讲座');
    }
    a.html(array[count].title);
    let str = id.split('-')[0];
    str = str.split('.')[1];
    a.attr('onclick', "showInformation.apply(academic,[this,'" + str + "'])");

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $(id).append(li);
}


function seeList() {
    this.self_num = 0;
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    if (sessionText == 'null') {
        alert('请先登录');
        return;
    }
    sort.apply(this, [1]);

}

function showSlefList() {
    this.self_num = this.showList(this.self_list, this.self_num, '.self-list', 1, this.self_flag);
    $('#modal-list').modal();
}

function sort(choose) {
    let flag = 2;
    this.self_flag = choose;
    let that = this;
    $.ajax({
        url: 'AcademicServlet',
        type: 'post',
        dataType: 'json',
        data: {
            'flag': Number(flag),
            'types': Number(choose),
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