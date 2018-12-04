var newsObj = function () {
    this.timeText = new Array();
    this.contentText = new Array();
    this.authorText = new Array();
    this.titleText = new Array();
    this.readCount = new Array();
    this.Count = 0;
}
newsObj.prototype.init = function () {
    window.addEventListener('scroll', debounce(loadInformation, 1000));
    this.requestInformation();
}
newsObj.prototype.requestInformation = function () {

    this.createNews();
    this.createNews();
    this.createNews();
    this.createNews();

    let title = new Array();
    let author = new Array();
    let time = new Array();
    let content = new Array();
    let reads = new Array();
    var news = this;
    $.ajax({
        url: "noteGettingServlet",
        type: "POST",
        dataType: "json",
        data: {
            "Count": Number(news.Count)
        },
        success: function (result) {
            let json = eval(result);
            json = json.context;
            $.each(json, function (index) {
                title[index] = json[index].title;
                author[index] = json[index].author;
                time[index] = json[index].releasetime;
                content[index] = json[index].pagecontect;
                reads[index] = json[index].readingvolume;
            });
            var j = 0;
            for (var i = news.Count - 4; i <= news.Count - 1; i++) {
                var dom = document.getElementById(i.toString()).children;
                dom[0].children[0].children[0].innerHTML = ($.isEmptyObject(title[j])) ? "null" : title[j];
                dom[0].children[1].children[0].children[0].innerHTML = ($.isEmptyObject(author[j]) ? "null" : author[j]);
                dom[0].children[1].children[1].innerHTML = ($.isEmptyObject(time[j])) ? "null" : time[j];
                dom[0].children[1].children[1].setAttribute("title", ($.isEmptyObject(time[j])) ? "null" : time[j]);
                dom[1].children[0].innerHTML = ($.isEmptyObject(content[j])) ? "内容加载失败" : content[j];
                dom[2].children[0].setAttribute("onclick", "showInformation.apply(news,[this])");
                dom[3].children[0].innerHTML = ($.isEmptyObject(reads[j])) ? 0 : reads[j] + "次";
                j++;
            }
            setInformation.apply(news, [title, author, time, content, reads]);
        },
        error: function () {}
    });
}

function setInformation(title, author, time, content, reads) {
    this.titleText = this.titleText.concat(title);
    this.timeText = this.timeText.concat(time);
    this.contentText = this.contentText.concat(content);
    this.readCount = this.readCount.concat(reads);
    this.authorText = this.authorText.concat(author);
}
function showInformation(obj) {
    let count = obj.parentNode.parentNode.getAttribute("id");
    let info_modal = $('#modal-info');
    info_modal.find('.modal-title')[0].innerHTML = this.titleText[count];
    info_modal.find('.panel-body')[0].children[0].innerHTML  = this.titleText[count];
    info_modal.find('.panel-body')[0].children[1].innerHTML = this.authorText[count]+"<small>"+this.timeText[count]+"</small>";
    info_modal.find('.panel-body')[0].children[3].innerHTML = this.contentText[count];
    info_modal.find('.panel-body')[0].children[4].children[0].innerHTML = this.readCount[count];
    info_modal.modal();

    let id = obj.parentNode.parentNode;
    $('#final').on('click',function(){
        id.style.backgroundColor = '#99ff99';
        this.setAttribute('data-dismiss','modal');
    });
    
}
newsObj.prototype.createNews = function () {
    var main = document.getElementById("main");
    var article = document.createElement("article");
    article.setAttribute("id", (this.Count).toString());
    article.setAttribute("class", "post");
    //head
    var post_head = document.createElement("div");
    var post_title = document.createElement("h4");
    var title = document.createElement("a");
    var post_meta = document.createElement("div");
    var author = document.createElement("span");
    var authorname = document.createElement("a");
    var time = document.createElement("time");

    post_head.setAttribute("class", "post-head");
    post_title.setAttribute("class", "post-title");
    title.setAttribute("href", "#");
    post_meta.setAttribute("class", "post-meta")
    author.setAttribute("class", "author")
    authorname.setAttribute("href", "#");
    //    time.setAttribute("title", timeText[this.Count]);
    //    time.setAttribute("datetime", timeText[this.Count]);
    //    time.appendChild(document.createTextNode(timeText[this.Count]));
    author.innerHTML = "作者：";
    //    authorname.appendChild(document.createTextNode(authorText[this.Count]));
    //    title.appendChild(document.createTextNode(titleText[this.Count]));
    post_title.appendChild(title);
    author.appendChild(authorname);
    post_meta.appendChild(author);
    post_meta.appendChild(time);
    post_head.appendChild(post_title);
    post_head.appendChild(post_meta);
    //content
    var post_content = document.createElement("div");
    var text = document.createElement("p");

    post_content.setAttribute("class", "post-content");
    //    text.appendChild(document.createTextNode(contentText[this.Count]));
    post_content.appendChild(text);
    //阅读全文
    var post_permalink = document.createElement("div");
    var read = document.createElement("button");

    post_permalink.setAttribute("class", "post-permalink pull-left")
    read.setAttribute("class", "btn btn-success");
    read.innerHTML = "阅读全文";
    post_permalink.appendChild(read);
    //阅读次数
    var post_readCount = document.createElement("div");
    var num = document.createElement("p");

    post_readCount.setAttribute("class", "post-readCount pull-right");
    //    num.innerHTML = readCount[this.Count] + "次";
    post_readCount.appendChild(num);
    //脚部
    var footer = document.createElement("footer");

    footer.setAttribute("class", "post-footer clearfix");

    //主体
    article.appendChild(post_head);
    article.appendChild(post_content);
    article.appendChild(post_permalink);
    article.appendChild(post_readCount);
    article.appendChild(footer);
    main.appendChild(article);
    //新闻数量
    this.Count++;
}
//加载信息
function loadInformation() {
    var wScrollY = window.scrollY;
    var wInnerH = window.innerHeight;
    var bScrollH = document.body.scrollHeight;
    if (wScrollY + wInnerH >= bScrollH) {
        news.requestInformation();
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