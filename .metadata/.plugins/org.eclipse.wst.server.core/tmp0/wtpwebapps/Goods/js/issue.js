function formPush() {
    const title = $('#title').val();
    const content = $('#content').val();
    const url = $('#sort').val() == 0?"WritingLostAndFoundServlet":"WritingLostAndFoundServlet";
    const date = new Date();
    const year = date.getUTCFullYear();
    const month = date.getUTCMonth();
    const day = date.getUTCDate();
    const time = year+"年"+month+"月"+day+"日";
    let map = new Map();
    map.set("title",title);
    map.set("nickname","damu");
    map.set("releasetime",time);
    map.set("pagecontect",content);

    $.ajax({
        url:"WritingLostAndFoundServlet",
        type:"post",
        dataType:"json",
        data:{
            "title":title,
            "nickname":"damu",
            "releasetime":time,
            "pagecontect":content,
        },
        success:function(res){
            location:href = "communication.jsp";
        },
        error:function(){
            // alert("发布失败，网络问题！");
        }
    });
}

function formEmpty() {
    document.getElementsByName('title')[0].value = null;
    document.getElementsByName('content')[0].value = null;
}

function checkText() {

}