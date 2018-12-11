<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
    
<head>
    <meta charset="utf-8">
    <title title="table">表格</title>
    <link href="./css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="./js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="./js/bootstrap.min.js" type="text/javascript"></script>
    <script src="./js/academic.js" type="text/javascript"></script>
</head>

<body onload="init()">
    <div class="container row">
        <div class="col-md-12 col-md-offset-4 bg-info">
            <div class="page-header">
                <h3 class="text-center">发布</h3>
                <p class="text-center">填写表格</p>
            </div>
            <div class="col-md-12 table-responsive">
                <div class="pull-left col-md-6">
                    <label class="h4" for="types">选择表类型</label>
                    <select name="types" id="types" onchange="changeType(this)">
                        <option value="1">竞赛</option>
                        <option value="2">科研</option>
                        <option value="3">讲座</option>
                    </select>
                </div>
                <table class="table table-bordered table-hover" summary="摘要" role="table">
                    <thead>
                        <tr>
                            <th class="text-center">名称</th>
                            <th class="text-center">内容</th>
                            <th class="text-center">注释</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="text-center"><label for="username">姓名</label></td>
                            <td class="text-center"><input tyoe="text" name="username" id="username" class="col-md-8 col-md-offset-2"
                                    required="required" placeholder="请输入真实姓名!" maxlength="11"></td>
                            <td class="text-center">请在左边输入真实姓名!</td>
                        </tr>
                        <tr>
                            <td class="text-center"><label for="grade">年级</label></td>
                            <td class="text-center">
                                <select name="grade" id="grade" class="col-md-8 col-md-offset-2">
                                    <option value="1">大学一年级</option>
                                    <option value="2">大学二年级</option>
                                    <option value="3">大学三年级</option>
                                    <option value="4">大学四年级</option>
                                </select>
                            </td>
                            <td class="text-center">请选择目前真实所在年级</td>
                        </tr>
                        <tr>
                            <td class="text-center"><label for="confact">联系方式</label></td>
                            <td class="text-center"><input type="text" placeholder="请输入联系方式" name="confact" id="confact"
                                    class="col-md-8 col-md-offset-2" required="required" maxlength="50"></td>
                            <td class="text-center">请在左边输入真实有效的联系方式,例如手机号码、QQ、微信、邮箱等</td>
                        </tr>
                        <tr>
                            <td class="text-center"><label for="sex">性别</label></td>
                            <td class="text-center"><select name="sex" id="sex" class="col-md-8 col-md-offset-2">
                                    <option value="男">男</option>
                                    <option value="女">女</option>
                                </select>
                            </td>
                            <td class="text-center">请在左边选择真实性别</td>
                        </tr>
                        <tr>
                            <td class="text-center"><label for="major">学院</label></td>
                            <td class="text-center"><select name="major" id="major" class="col-md-8 col-md-offset-2">
                                    <option value="计算机学院">计算机学院</option>
                                    <option value="外国语学院">外国语学院</option>
                                    <option value="电子信息学院">电子信息学院</option>
                                    <option value="艺术设计学院">艺术设计学院</option>
                                    <option value="人文学院">人文学院</option>
                                    <option value="管理学院">管理学院</option>
                                    <option value="机电学院">机电学院</option>
                                    <option value="材料与食品学院">材料与食品学院</option>
                                    <option value="经贸学院">经贸学院</option>
                                </select>
                            </td>
                            <td class="text-center">请在左边选择就读学院</td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td class="text-center">
                                <button class="btn btn-primary" onclick="addTr()">添加DIY行</button>
                                <button class="btn btn-danger" onclick="removeTr()">删除DIY行</button>
                            </td>
                            <td class="text-center"><button class="btn btn-success" onclick="submit()">提交</button></td>
                            <td class="text-center"><button class="btn btn-default" onclick="out()">退出</button></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
    <script src="./js/table.js" type="text/javascript"></script>
</body>

</html>