var communicationOBJ = function () {
    this.left_list = new Array();
    this.right_list = new Array();
    this.num = 0;
    this.flag = 1;
}

communicationOBJ.prototype.init = function () {
    this.requirList();
}
communicationOBJ.prototype.setList = function (obj) {
    if (this.flag == 0) {
        this.left_list = obj.lostAndFound;
    } else {
        this.left_list = obj.communication;
    }
    console.log(this.left_list);
    this.showList(1);
}
communicationOBJ.prototype.showList = function (flag) {
    var len = Math.floor(this.num / 6);
    var max = Math.floor(this.left_list.length / 6);
    $('#content').children().remove();
    if (flag == 0) {
        for (var i = len * 6; i > (len - 1) * 6; i--) {
            console.log(i);
            this.createList(i, this.left_list);
        }
    } else {
        for (var i = len * 6; i < (len + 1) * 6; i++) {
            console.log(i);
            this.createList(i, this.left_list);
        }
    }
}

function showInformation(obj) {
    $('#modal-info').modal();
}
communicationOBJ.prototype.requirList = function () {
    let com = this;
    var url;
    console.log(this.flag);
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
            console.log(json);
            com.setList(json);
        },
        error: function () {
            alert('网络中断，未能响应服务器请求！');
        }
    })
}
communicationOBJ.prototype.createList = function (count, array) {
    var id = count = 0 ? this.num.toString() : count;

    var li = $('<li></li>');
    var span_sort = $('<span></span>');
    var span_time = $('<span></span>');
    var small = $('<small></small>');
    var a = $('<a></a>');

    li.attr('class', 'list-group-item');;
    li.attr('id', count);
    span_sort.attr('class', 'badge');
    span_time.attr('class', 'badge');
    // span_time.html(array[count].releasetime);
    small.html('作者：' + array.nickname);
    if (this.flag == 0) {
        span_sort.html('未解决');
        span_sort.html('已解决');
    } else {
        span_sort.html('交流');
    }
    a.html(array[count].title);
    a.attr('href', 'javascript:onclick = showInformation.apply(communication,[this])');

    span_sort.appendTo(li);
    span_time.appendTo(li);
    a.appendTo(li);
    $('#content').append(li);
    this.num++;
}