var circumObj = function () {
    this.attractions = new Array();
    this.merchant = new Array();
    this.Count = 0;
}
//请求
circumObj.prototype.pushInformaion = function () {
    var circum = this;
    $.ajax({
        url: "getSurroundingInfoServlet",
        dataType: "json",
        type: "POST",
        success: function (result) {
            var json = eval(result);
            console.log(json)
            circum.attractions = circum.attractions.concat(circum.attractions, json.attractions);
            circum.merchant = circum.merchant.concat(circum.merchant, json.merchant);
            setObj.apply(circum, [0]);
        },
        error: function () {
            alert("网络连接失败");
        }
    });
}
//获取json对象
function setObj(select) {
    var sort = new Array();
    this.Count == 0;
    $('#content').children().remove();
    if ($.isEmptyObject(this.attractions)) {
        alert("获取数据失败");
    } else if(select == 0){
        sort = this.attractions.concat(this.merchant);
        for (var i = 0; i < sort.length ;i++) {
            this.createNode(i);
        }
        this.setInformation(sort);
    }else if(select == 1){
        sort = this.attractions;
        for (var i = 0; i < sort.length; i++) {
            this.createNode(i);
        }
        this.setInformation(sort);
    }else if(select == 2){
        sort = this.merchant;
        for (var i = 0; i < sort.length; i++) {
            this.createNode(i);
        }
        this.setInformation(sort);
    }else if(select == 3){
        var sort;
        this.merchant.forEach(element => {
            sort = sort.concat(element.food);
        });
        for (var i = 0; i < sort.length; i++) {
            this.createNode(i);
        }
        this.setInformation(sort);
    }
    
}
//初始化
circumObj.prototype.init = function () {
    this.pushInformaion();
}
//显示信息
circumObj.prototype.setInformation = function (sort) {
    let random = Math.floor(Math.random() * (sort.length));
    let randoms = new Array();
    while (randoms.length < sort.length) {
        while (randoms.indexOf(random) != -1) {
            random = Math.floor(Math.random() * (sort.length));
        }
        randoms.push(random);
    }
    let count = 0;
    let post_name = $('#content > ul').find(".post-name");
    let content = $('#content > ul').find(".post-content");
    let address = $('#content > ul').find("address");
    let other = $('#content > ul').find(".post-other");
    while (count < sort.length) {
        content.eq(count)[0].children[0].innerHTML = ($.isEmptyObject(sort[randoms[count]]) ? "信息获取失败" : sort[randoms[count]].info);
        post_name.eq(count)[0].children[0].innerHTML = ($.isEmptyObject(sort[randoms[count]]) ? "信息获取失败" : sort[randoms[count]].name);
        address.eq(count)[0].innerHTML = "地址:" + ($.isEmptyObject(sort[randoms[count]]) ? "无" : sort[randoms[count]].address);
        if (randoms[count] < randoms.length / 2) {
            other.eq(count)[0].children[0].innerHTML = "<abbr title='Price'>价格：</abbr>" + ($.isEmptyObject(sort[randoms[count]]) ? "暂无" : sort[randoms[count]].price);
        } else {
            other.eq(count)[0].children[0].innerHTML = "<abbr title='Phone'>电话：</abbr>" + ($.isEmptyObject(sort[randoms[count]]) ? "暂无" : sort[randoms[count]].phone);
        }

        count++;
    }

}
//动态创建
circumObj.prototype.createNode = function (count) {
    //div and article
    var li = $("<li></li>");
    var article = $('<article></article>');

    article.addClass("post");
    article.attr('id', this.Count.toString());

    article.appendTo(li);
    //head
    var post_head = $('<div></div>');

    post_head.addClass("post-head");

    post_head.appendTo(article);

    //店铺头像
    var post_img = $('<div></div>');
    var post_img_content = $('<img>')

    post_img_content.addClass('img-rounded img-responsive img-circle');
    post_img_content.attr('src', './img/02.png');
    post_img.addClass('post-img');

    post_img_content.appendTo(post_img);
    post_img.appendTo(post_head);

    //店铺名称
    var post_name_div = $('<div></div>');
    var post_name_a = $('<a></a>');

    post_name_a.attr('href', "#");
    post_name_a.addClass("h2 pull-right");
    post_name_div.addClass("post-name");

    post_name_a.appendTo(post_name_div);
    post_name_div.appendTo(post_head);

    //店铺联系方式
    var post_other = $("<div></div>");
    var p = $("<p></p>");

    post_other.addClass('post-other');
    p.addClass('text-sm pull-left');

    p.appendTo(post_other);
    post_other.appendTo(post_head);


    //内容
    var post_content = $('<div></div>');
    var text = $('<p></p>');

    post_content.addClass("post-content");

    text.appendTo(post_content);
    post_content.appendTo(article);

    //底部
    var footer = $('<footer></footer>');
    var footer_div = $('<div></div>');
    var address = $('<address></address>');


    address.addClass('pull-left');
    footer_div.addClass('tag-clound');
    footer.addClass('post-footer');

    footer_div.appendTo(footer);
    address.appendTo(footer);
    footer.appendTo(article);
    //添加网页
    if ($('#content > ul').length <= Math.floor(count / 3)) {
        var ul = $('<ul></ul>');
        if (Math.floor(count / 3) == 0)
            ul.attr('class', 'item list-inline text-center active');
        else
            ul.attr('class', 'item list-inline text-center');
        ul.appendTo($('#content'));
    }
    $('#content > ul').eq(Math.floor(count / 3)).append(li);
    this.Count++;
}