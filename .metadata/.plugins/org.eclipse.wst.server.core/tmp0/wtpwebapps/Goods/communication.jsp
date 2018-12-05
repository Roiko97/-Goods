<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<%
	String flag = request.getParameter("logout");
	if(flag != null)	
	{
		session.removeAttribute("userID");
	}
%>

<head>
    <meta charset='utf-8'>
    <title title="communication">交流</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="./css/communication.css" rel="stylesheet" type="text/css">
    <script src="./js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./js/communiction.js" type="text/javascript"></script>
    <script src="./js/main.js" type="text/javascript"></script>
    <script src="./js/nav.js" type="text/javascript"></script>
</head>

<body onload="start()">
    <div id="nav">
        <p id="username">
            <%=session.getAttribute("userID")%>
        </p>
    </div>
    <div class="main row">
        <div class="jumbotron col-md-10 col-md-offset-1">
            <h1>你好，欢迎加入电子科技大学中山学院</h1>
            <p>位于中山市石岐区</p>
        </div>
        <div class="left-part col-md-7 col-md-offset-1">
            <div class="page-header">
                <h2>交流</h2>
                <p>沟通产生美</p>
            </div>
            <ul class="list-group content">

            </ul>
            <ul class="pager">
                <li class=""><a onclick="previous.apply(communication,[0])">上一页</a></li>
                <li><a onclick="next.apply(communication,[0])">下一页</a></li>
            </ul>
        </div>
        <div class="col-md-2 col-md-offset-1" role="main">
            <div class="right-part bs-docs-sideber affix">
                <h4>快捷键</h4>
                <button class="btn btn-success col-md-8 col-md-offset-2" onclick="location.href='issue.jsp'">发布</button>
                <button class="btn btn-default col-md-8 col-md-offset-2" onclick="seeList.apply(communication,[])">查看</button>
            </div>
        </div>
    </div>
    <!--login Modal -->
    <div class="modal fade" id="login-Modal" tabindex="-1" role="dialog" aria-labelledby="login-model-lbl">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="login-model-lbl">登录</h4>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-8">
                            <div class="row">
                                <form method="post" action="userLoginServlet" class="form-horizontal" role="form" id="login">
                                    <div class="form-group col-md-12">
                                        <div class="col-md-3 text-center ">
                                            <label for="inputUesrName" class="control-label">账号</label>
                                        </div>
                                        <div class="col-md-8">
                                            <input type="text" class="form-control" id="userName" name="userName"
                                                maxlength="20" autofocus="" placeholder="请输入账号" autocomplete="on" />
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-3 text-center">
                                            <label for="inputPassword" class="control-label">密码</label>
                                        </div>
                                        <div class="col-md-8">
                                            <input type="password" class="form-control" id="password" name="password"
                                                maxlength="20" placeholder="请输入密码" autocomplete="on" />
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-3">
                                            <label for="Code" class="control-label">验证码</label>
                                        </div>
                                        <div class="col-md-5">
                                            <input type="text" class="form-control" id="inputCode" name="inputCode"
                                                maxlength="20" placeholder="请输入验证码" maxlength="4" />
                                        </div>
                                        <div class="col-md-2">
                                            <input type="button" class="btn" id="code" onclick="createCode()">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12 text-center">
                                        <a href="./register.jsp">未注册，进入注册页面</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-md-4">
                            <img src="src/Logo.png" class="img-responsive" alt="LOGO">
                        </div>
                    </div>
                    <div class="row">
                        <div class="modal-footer center-block">
                            <input type="button" id="btn" class="btn btn-success col-md-4 col-md-offset-2" name="loginsubmit"
                                value="登录" onclick="login()"> <input type="button" id="btn-cancl" class="btn btn-default col-md-4"
                                value="取消" data-dismiss="modal">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!--information show in Modal-->
    <div id="modal-info" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modallabel">
        <div class="modal-dialog" role="document">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modallabel">标题</h4>
                </div>
                <div class="panel-body">
                    <div class="modal-left col-md-8">
                        <h1 class="text-center">标题</h1>
                        <h3 class="text-center">作者：<small>时间</small></h3>
                        <hr>
                        <p class="text-center">同学都争先恐后。这作文</p>
                    </div>
                    <div class="modal-right col-md-4">
                        <div class="head">
                            <h3 class="text-right">评论</h3>
                            <button class="btn btn-success" onclick="jQuery:$('.comment-add').show();">回复<span class="glyphicon glyphicon-plus-sign"></span></button>
                            <div class="comment-add">
                                <form class="form-group">
                                    <textarea type="text" class="form-control" id="comment-cont" name="reply"
                                        placeholder="请输入评论" value="" maxlength="400"></textarea>
                                </form>
                                <div class="btn-group">
                                    <button class=" btn btn-success" id="submit">提交</button>
                                    <button class=" btn btn-default" onclick="jQuery:$('.comment-add').hide();">取消</button>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <ul class="list-group" id="comment">
                        </ul>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="final">阅读完成</button>
                </div>
            </div>
        </div>
    </div>
    <!--information show in Modal-->
    <div id="modal-list" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modallabel">
        <div class="modal-dialog" role="document">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modallabel">标题</h4>
                </div>
                <div class="panel-body">
                    <div class="self-list col-md-8">
                        <ul class="list-group content">

                        </ul>
                        <ul class="pager">
                            <li class=""><a href="javascript:onclick= previous.apply(communication,[1])">上一页</a></li>
                            <li><a href="javascript:onclick= next.apply(communication,[1])">下一页</a></li>
                        </ul>
                    </div>
                    <div class="col-md-2 col-md-offset-1">
                        <ul class="list-group">
                            <a href="javascript:onclick=sort.apply(communication,[1])" class="btn btn-info list-group-item">交流</a>
                            <a href="javascript:onclick=sort.apply(communication,[0])" class="btn btn-info list-group-item">失物招领</a>
                        </ul>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</body>

</html>