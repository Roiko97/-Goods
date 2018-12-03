var workObj = function(){
    this.left_part = new Array();
    this.right_part = new Array();
    this.num = 0;
}
//初始化函数
workObj.prototype.init = function(){
    this.requireList();
}
//请求数据
workObj.prototype.requireList = function(){
    var work = this;
    $.ajax({
        url:"",
        type:"post",
        dataType:"JSON",
        data:"",
        success:function(res){
            var json = eval(res);
            console.log(res);
        },
        error:function(){

        }
    });
}
//显示信息,0上一页，1下一页

workObj.prototype.showList = function(flag){
    //分页
    var len = Math.floor(this.num / 2);
    var max = Math.floor(this.right_part.length / 2);
    if(len == 0 || len == 1){
        $('.pager > li').eq(0).attr('class','disabled');
        if(flag == 0)
            return;
    }else if(len == max){
        $('.pager > li').eq(1).attr('class','disabled');
        $('.pager > li').eq(0).attr('class','');
        if(flag == 1)
            return;
    }
    else{
        $('.pager > li').eq(1).attr('class','');
        $('.pager > li').eq(0).attr('class','');
    }
    //动态创建
    $('#content').children().remove();
    if (flag == 0) {
        for (var i = (len - 2) * 2; i <= (len-1) * 2 -1; i++) {
            this.createList(i, this.right_part);
            }
            this.num -= 2;
    } else {
        for (var i = len * 2; i < (len + 1) * 2; i++) {
            this.createList(i, this.right_part);
            this.num++;
        }
    }
    //分页
    if(Math.floor(this.num / 2) == 1){
        $('.pager > li').eq(0).attr('class','disabled');
        $('.pager > li').eq(1).attr('class','');
        if(flag == 0)
            return;
    }else if(Math.floor(this.num / 2) == max){
        $('.pager > li').eq(1).attr('class','disabled');
        $('.pager > li').eq(0).attr('class','');
        if(flag == 1)
            return;
    }
    else{
        $('.pager > li').eq(1).attr('class','');
        $('.pager > li').eq(0).attr('class','');
    }

}
//动态创建，创建元素的同时，将数据绑定。
workObj.prototype.createdList = function(id,array) {
    
}