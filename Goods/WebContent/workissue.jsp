<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <!DOCTYPE html>
 <html lang="en">
 <head>
 	<meta charset="utf-8">
 	<title>兼职发布</title>
 	<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
 	<script src="js/bootstrap.min.js" type="text/javascript"></script>
	 <script src="js/workissue.js" type="text/javascript"></script>
 	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
 </head>
 <body>
 	<div class="container">
		<div class="row">
			<div class="page-header">
				<h2>兼职发布</h2>
			</div>
			<div class="main">
				<form class="form-group col-md-12 bg-primary">
					<div class="col-md-6">
						<label for="title">标题</label>
						<input type="text" id="title" class="form-control" name="title" placeholder="请输入标题">
					</div>
					<div class="col-md-3">
						<label for="shopname">商店名称</label>
						<input type="text" id="shopname" name="shopname" class="form-control" placeholder="请输入商店名称"> 
					</div>
					<div class="col-md-3">
						<label for="position">职位</label>
						<input type="text" id="position" name="position" class="form-control" placeholder="请输入招聘职位">
					</div>
					<div class="col-md-6">
						<label for="address">地址</label>
						<input type="text" id="address" name="address" class="form-control" placeholder="请输入地址">
					</div>
					<div class="col-md-3">
						<label for="linkman">联系人</label>
						<input type="text" id="linkman" name="linkman" class="form-control" placeholder="请输入联系人" value="<%=session.getAttribute("userID")%>">
					</div>
					<div class="col-md-3">
						<label for="phone">联系方式</label>
						<input type="number" id="phone" name="phone" class="form-control" placeholder="请输入电话或手机">
					</div>
					<div class="col-md-12">
						<label for="content">招聘内容</label>
						<textarea id="content" name="content" cols="120" rows="10" class="form-control" placeholder="请输入招聘内容"></textarea>
					</div>
					<div class="col-md-12">
						<br/>
					</div>
				</form>
				<div class="btn=group col-md-2 pull-right">
					<button class="btn btn-lg btn-success" id="submit" onclick="formSumbit()">发布</button>
					<button class="btn btn-lg btn-default" onclick="formClear()">重置</button>
				</div>
			</div>
		</div>
	 </div>
 </body>
 </html>