<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang=en>
<%
	String flag = request.getParameter("logout");
	if(flag != null)	
	{
		session.removeAttribute("userID");
	}
%>

<head>
    <meta charset='utf'>
    <title title="work">兼职</title>
    <script src="./js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript"></script>
    <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="./css/work.css" rel='stylesheet' type="text/css">
    <script src="./js/main.js" type="text/javascript"></script>
    <script src="./js/nav.js" type="text/javascript"></script>
    <script src="./js/work.js" type="text/javascript"></script>
</head>

<body onload="start()">
    <div id="nav">
        <p id="username">
            <%=session.getAttribute("userID")%>
        </p>
    </div>
    <div class="main row">
        <div class="left-list col-md-2 col-md-offset-1">
            <ul class="list-group">
                <li class="list-group-item"><span class="badge">热</span><a href="index.jsp">学校各党支部深入学习习近平总书记视察广东重要讲话精神</a></li>
                <li class="list-group-item"><span class="badge">新</span><a href="circum.jsp">中山詹园</a></li>
            </ul>
        </div>
        <div class="right-list col-md-7 col-md-offset-1">
            <div class="page-header">
                <div class="row">
                    <div class="clearfix"></div>
                    <div class="col-md-2">
                        <h2 class="h2">兼职</h2>
                    </div>
                    <div class="col-md-1 col-md-offset-9">
                        <button class="btn btn-success button pull-right" onclick="submitwork()">发布</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <p class="p">让大学生活不品凡</p>
                    </div>
                    <div class="col-md-1 col-md-offset-7">
                        <button class="btn btn-default pull-right" onclick="seeList.apply(work,[])">查看</button>
                    </div>
                </div>
            </div>
            <ul class="list-group" id="content">
                <!--
                         <li class="list-group-item"><span class="badge">兼职</span><a href="#">321654</a></li>
                        <li class="list-group-item"><span class="badge">兼职</span><a href="#">321654</a></li>
                        <li class="list-group-item"><span class="badge">兼职</span><a href="#">321654</a></li>
                        <li class="list-group-item"><span class="badge">兼职</span><a onclick="showInformation.apply(work,[this])">321654</a></li> 
-->
            </ul>
            <ul class="pager">
                <li class="">
                    <a onclick="previous.apply(work,[0])">上一页</a>
                </li>
                <li>
                    <a onclick="next.apply(work,[0])">下一页</a>
                </li>
            </ul>
        </div>
        <div class="bottom-part">
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
                                            <input type="text" class="form-control" id="userName" name="userName" maxlength="20" autofocus="" placeholder="请输入账号" autocomplete="on" />
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-3 text-center">
                                            <label for="inputPassword" class="control-label">密码</label>
                                        </div>
                                        <div class="col-md-8">
                                            <input type="password" class="form-control" id="password" name="password" maxlength="20" placeholder="请输入密码" autocomplete="on" />
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-3">
                                            <label for="Code" class="control-label">验证码</label>
                                        </div>
                                        <div class="col-md-5">
                                            <input type="text" class="form-control" id="inputCode" name="inputCode" maxlength="20" placeholder="请输入验证码" maxlength="4" />
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
                            <img src="src/LOGO/Logo.png" class="img-responsive" alt="LOGO">
                        </div>
                    </div>
                    <div class="row">
                        <div class="modal-footer center-block">
                            <input type="button" id="btn" class="btn btn-success col-md-4 col-md-offset-2" name="loginsubmit" value="登录" onclick="login()"> <input type="button" id="btn-cancl" class="btn btn-default col-md-4" value="取消" data-dismiss="modal">
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
                    <div class="col-md-12">
                        <button class="btn btn-success pull-right" onclick="applywork.apply(this)">报名<span class="glyphicon glyphicon-plus-sign"></span></button>
                    </div>
                    <div class="modal-left col-md-8 col-md-offset-2">
                        <h1 class="text-center">标题</h1>
                        <h3 class="text-center">作者：<small>时间</small></h3>
                        <hr>
                        <p>同学都争先恐后。这作文</p>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="final">阅读完成</button>
                </div>
            </div>
        </div>
    </div>
    <!--contribute show in Modal-->
    <div id="modal-contribute" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modallabel">
        <div class="modal-dialog" role="document">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="modalabel">兼职应聘</h4>
                </div>
                <div class="panel-body bg-success">
                    <form class="form-group col-md-12">
                        <div class="col-md-6">
                            <label for="name">姓名</label>
                            <input type="text" id="name" name="name" class="form-control" placeholder="请输入姓名">
                        </div>
                        <div class="col-md-6">
                            <label for="age">年龄</label>
                            <input type="number" id="age" name="age" class="form-control" placeholder="请输入年龄">
                        </div>
                        <div class="col-md-6">
                            <label for="sex">性别</label>
                            <select name="sex" id="sex" class="form-control">
                                <option value="男">男</option>
                                <option value="女">女</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label for="phone">联系方式</label>
                            <input type="tel" id="phone" name="phone" class="form-control" placeholder="请输入手机号码">
                        </div>
                        <div class="col-md-12">
                            <label for="selfcontent">个人简介</label>
                            <textarea id="selfcontent" name="selfcontent" cols="120" rows="10" class="form-control" placeholder="请输入自己的优点，特长和上班时间等，能提高被录用的记录哦"></textarea>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-primary" id="submit" onclick="workformSubmit()">提交</button>
                </div>
            </div>
        </div>
    </div>
    <!--self-information show in Modal-->
    <div id="modal-list" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modallabel">
        <div class="modal-dialog" role="document">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modallabel">个人相关</h4>
                </div>
                <div class="panel-body">
                    <div class="modal-left col-md-6">
                        <h2 class="text-center">标题</h2>
                        <h3 class="text-center">商家：test&nbsp;&nbsp;<small>职位：test</small></h3>
                        <hr>
                        <p>优衣库急招一名导购员</p>
                        <ul class="pager navbar-fixed-bottom">
                            <li class=""><a onclick="previousinfo()">上一条</a></li>
                            <li><a onclick="nextinfo()">下一条</a></li>
                        </ul>
                    </div>
                    <div class="modal-right col-md-6">
                        <h3 class="text-right"> 简历</h3>
                        <ul class="list-group" id="comment">
                            <div class="list-group-item">
                                <h4 class="text-center">姓名：小明</h4>
                                <div class="text-left">
                                    <p>性别：男</p>
                                    <p>年龄：20</p>
                                    <p>电话：1341238821</p>
                                    <p>自我介绍：输入自己的优点，特长和上班时间等，能提高被录用的记录哦</p>
                                </div>
                            </div>
                            <div class="list-group-item">
                                <h4 class="text-center">姓名：小红</h4>
                                <div class="text-left">
                                    <p>性别：女</p>
                                    <p>年龄：21</p>
                                    <p>电话：1341238821</p>
                                    <p>自我介绍：输入自己的优点，特长和上班时间等，能提高被录用的记录哦</p>
                                </div>
                            </div>
                            <div class="list-group-item">
                                <h4 class="text-center">姓名：小红</h4>
                                <div class="text-left">
                                    <p>性别：女</p>
                                    <p>年龄：21</p>
                                    <p>电话：1341238821</p>
                                    <p>自我介绍：输入自己的优点，特长和上班时间等，能提高被录用的记录哦</p>
                                </div>
                            </div>
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
