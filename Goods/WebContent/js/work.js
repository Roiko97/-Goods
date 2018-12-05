var workObj = function () {
    this.left_list = new Array();
    this.right_list = new Array();
    this.num = 0;
}
//初始化函数
workObj.prototype.init = function () {
    this.requireList();
}

function showInformation(obj) {
    var id = obj.parentNode.id;
    // $('.panel-body').find('h1').html(this.left_list[id].title);
    // $('.panel-body').find('h3').eq(0).html('作者：' + this.left_list[id].nickname + '<small>' + this.left_list[id].releasetime + '</small>');
    // $('.panel-body').find('p').eq(0).html(this.left_list[id].pagecontect);
    $('#modal-info').modal();

    $('#final').on('click', function () {
        obj.style.color = 'black';
        this.setAttribute('data-dismiss', 'modal');
    });

}
//请求数据
workObj.prototype.requireList = function () {
    var work = this;
    $.ajax({
        url: "getUserTableServlet",
        type: "post",
        dataType: "JSON",
        data: {
            'Count':Number(5),
        },
        success: function (res) {
            var json = eval(res);
            console.log(res);
            work.setList(json.userInformation);
        },
        error: function () {

        }
    });
}
workObj.prototype.setList = function (obj) {

}
//显示信息,0上一页，1下一页
workObj.prototype.showList = function (flag) {
    //分页
    var len = Math.floor(this.num / 2);
    var max = Math.floor(this.right_list.length / 2);
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
    //动态创建
    $('#content').children().remove();
    if (flag == 0) {
        for (var i = (len - 2) * 2; i <= (len - 1) * 2 - 1; i++) {
            this.createList(i, this.right_list);
        }
        this.num -= 2;
    } else {
        for (var i = len * 2; i < (len + 1) * 2; i++) {
            this.createList(i, this.right_list);
            this.num++;
        }
    }
    //分页
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
//动态创建，创建元素的同时，将数据绑定。
workObj.prototype.createdList = function (id, array) {
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
    a.html(array[id].title);
    a.attr('onclick', 'showInformation.apply(work,[this])');

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $('#content').append(li);
}