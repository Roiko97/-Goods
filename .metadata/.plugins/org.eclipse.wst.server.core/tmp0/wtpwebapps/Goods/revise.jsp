<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>修改信息</title>
    <script src="./js/jquery-3.3.1.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <link href="./css/bootstrap.min.css" rel="stylesheet">
</head>

<body>
    <div class="row">
        <div class="col-lg-8 col-md-offset-2">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <h1> 修改资料</h1>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <!--修改信息表单-->
                        <div class="col-md-6 col-sm-8 col-xs-8 col-xxs-12">
                            <form class="form-horizontal" method="post" action="userReviseServlet" role="form" id="revise">
                                <div class="form-group col-md-12">
                                    <div class="col-md-10 col-md-offset-1 input-group">
                                        <span class="input-group-addon">
                                            <label class="cantrol-label" for="Uesrname">账号</label>
                                        </span>
                                        <input value='<%=session.getAttribute("userID") %>' type="text" id="userName" name="userName" class="form-control" placeholder="请输入账号" disabled="disabled">
                                    </div>
                                    <div class="col-md-8 col-md-offset-1">
                                        <span class="help-block text-left" id="userNameHelp"></span>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <span class="input-group-addon">
                                            <label class="control-labelv" for="password">密码</label>
                                        </span>
                                        <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" onchange="checkuserpass()" maxlength="20">
                                    </div>
                                    <div class="col-md-8 col-md-offset-1">
                                        <span class="help-block text-left" id="passwordHelp"></span>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <span class="input-group-addon">
                                            <label class="control-label" for="phone">手机</label>
                                        </span>
                                        <input type="tel" id="phone" name="phone" class="form-control" placeholder="请输入有效11位号码" onchange="checkphone()" maxlength="11">
                                    </div>
                                    <div class="col-md-8 col-md-offset-1">
                                        <span class="help-block text-left" id="phoneHelp"></span>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <span class="input-group-addon">
                                            <label class="control-label" for="name">昵称</label>
                                        </span>
                                        <input type="text" id="name" name="name" class="form-control" placeholder="请输入昵称" onchange="checknickname()" maxlength="20">
                                    </div>
                                    <div class="col-md-8 col-md-offset-2">
                                        <span class="help-block text-left" id="nameHelp"></span>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <span class="input-group-addon">
                                            <label class="control-label" for="email">邮箱</label>
                                        </span>
                                        <input type="text" id="email" name="email" class="form-control" placeholder="xxxx@163.com" onchange="checkemail()" value="" maxlength="20">
                                    </div>
                                    <div class="col-md-8 col-md-offset-1">
                                        <span class="help-block text-left" id="emailHelp"></span>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <span class="input-group-addon">
                                            <label class="control-label" for="age">年龄</label>
                                        </span>
                                        <input type="number" id="age" name="age" class="form-control" onchange="verifyage()" value="0" maxlength="4" min="0" max="100">
                                    </div>
                                    <div class="col-md-8 col-md-offset-1">
                                        <span class="help-block text-left" id="ageHelp"></span>
                                    </div>
                                </div>
                                <div class="form-group col-md-12">
                                    <div class="input-group col-md-10 col-md-offset-1">
                                        <span class="input-group-addon">
                                            <label class="control-label" for="gender">性别</label>
                                        </span>
                                        <span class="input-group-addon">
                                            <input type="radio" id="gendermale" name="gender" value="男" checked />男
                                        </span>
                                        <span class="input-group-addon">
                                            <input type="radio" id="genderfemale" name="gender" value="女" />女
                                        </span>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <!--权限认证-->
                        <div class="col-md-6">
                            <div class="form-group col-md-10 col-md-offset-1">
                                <div class="input-group col-md-6    ">
                                    <span class="input-group-addon">
                                        <label class="control-label" for="activate">权限认证
                                        </label>
                                    </span>
                                    <span class="input-group-addon">
                                        <input type="radio" id="Stu_activate" name="Activate" value="Student" onclick="student_show()" />学生
                                    </span>
                                    <span class="input-group-addon">
                                        <input type="radio" id="Tea_activate" name="Activate" value="Teacher" onclick="teacher_show()" />教师
                                    </span>
                                    <span class="input-group-addon">
                                        <input type="radio" id="Act_activate" name="Activate" value="Activation" onclick="activation_show()" />商家/组织
                                    </span>
                                </div>
                            </div>
                            <!-- 学生认证-->
                            <div class="col-md-9">
                                <form class="form-horizontal col-md-12" method="post" action="userReviseServlet" role="form" id="student_activate">
                                    <div class="form-group col-md-12">
                                        <div class="col-md-10 col-md-offset-1 input-group">
                                            <span class="input-group-addon">
                                                <label class="control-label" for="studentid">学号</label>
                                            </span>
                                            <input type="text" id="student_id" name="student_id" class="form-control" placeholder="请输入学号" onchange="checkstudentid()">
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">
                                            <span class="help-block text-left" id="studentidHelp"></span>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-10 col-md-offset-1 input-group">
                                            <span class="input-group-addon">
                                                <label class="control-label" for="studentpass">密码</label>
                                            </span>
                                            <input type="password" id="student_password" name="student_password" class="form-control" placeholder="请输入密码" onchange="checkstudentpass()" maxlength="20">
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">
                                            <span class="help-block text-left" id="studentpassHelp"></span>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-8 col-md-offset-2">
                                            <input type="button" id="btn_student_activate" class="btn btn-success pull-left" value="激活" onclick="student_activate()">
                                            <input type="button" id="btn-cancle1" class="btn btn-default pull-right" value="关闭" data-dismiss="modal" onclick="cancle1_close()">
                                        </div>
                                    </div>
                                </form>
                                <!-- 教师认证 -->
                                <form class="form-horizontal" method="post" action="userReviseServlet" role="form" id="teacher_activate">
                                    <div class="form-group col-md-12">
                                        <div class="col-md-10 col-md-offset-1 input-group">
                                            <span class="input-group-addon">
                                                <label class="control-label" for="teacherid">工号</label>
                                            </span>
                                            <input type="text" id="teacher_id" name="teacher_id" class="form-control" placeholder="请输入工号" onchange="checkteacherid()">
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">
                                            <span class="help-block text-left" id="teacheridHelp"></span>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-10 col-md-offset-1 input-group">
                                            <span class="input-group-addon">
                                                <label class="control-label" for="teacherpass">密码</label>
                                            </span>
                                            <input type="password" id="teacher_password" name="teacher_password" class="form-control" placeholder="请输入密码" onchange="checkteacherpass()" maxlength="20">
                                        </div>
                                        <div class="col-md-8 col-md-offset-2">
                                            <span class="help-block text-left" id="teacherpassHelp"></span>
                                        </div>
                                    </div>
                                    <div class="form-group col-md-12">
                                        <div class="col-md-8 col-md-offset-2">
                                            <input type="button" id="btn_teacher_activate" class="btn btn-success pull-left" value="激活" onclick="teacher_activate()">
                                            <input type="button" id="btn-cancle2" class="btn btn-default pull-right" value="关闭" data-dismiss="modal" onclick="cancle2_close()">
                                        </div>
                                    </div>
                                </form>
                                <!--激活码认证-->
                                <form class="form-horizontal" method="post" action="userReviseServlet" role="form" id="activation_activate">
                                    <div class="form-group col-md-12">
                                        <div class="col-md-4 input-group">
                                            <div>
                                                <h4 style="color:green"> 激活码</h4>
                                            </div>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <div class="col-md-10 input-group col-md-offset-2">
                                                <input id="activation1" name="activation1" tabindex="1" type="text" size="4" maxlength="4" onchange="checkactivation1()" onkeyup="checkLen(this,this.value)" onkeypress="return checkNum(event)" /> -
                                                <input id="activation2" name="activation2" tabindex="2" type="text" size="4" maxlength="4" onchange="checkactivation2()" onkeyup="checkLen(this,this.value)" onkeypress="return checkNum(event)" /> -
                                                <input id="activation3" name="activation3" tabindex="3" type="text" size="4" maxlength="4" onchange="checkactivation3()" onkeyup="checkLen(this,this.value)" onkeypress="return checkNum(event)" /> -
                                                <input id="activation4" name="activation4" tabindex="4" type="text" size="4" maxlength="4" onchange="checkactivation4()" onkeyup="checkLen(this,this.value)" onkeypress="return checkNum(event)" />
                                            </div>
                                            <span class="istrue" id="activationHelp"></span>
                                        </div>
                                        <div class="form-group col-md-12">
                                            <div class="col-md-8 col-md-offset-2">
                                                <input type="button" id="btn_activation_activate" class="btn btn-success pull-left" value="激活" onclick="activation_activate()">
                                                <input type="button" id="btn-cancle3" class="btn btn-default pull-right" value="关闭" data-dismiss="modal" onclick="cancle3_close()">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <!--LOGO-->
                        <div class="col-md-4 col-md-offset-1">
                            <img src="./src/LOGO128.ico" class="col-md-12" id="revise_logo">
                        </div>
                        <!--提交按钮-->
                        <div class="modal-footer center-block  center-block col-md-12">
                            <input type="button" id="btn" class="btn btn-success col-md-4 col-md-offset-2" value="修改" name="reviseSubmit" onclick="revise()">
                            <input type="button" id="btn-cancl" class="btn btn-default col-md-4" data-dismiss="modal" value="取消" onclick="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="./js/revise.js"></script>
</body>

</html>
