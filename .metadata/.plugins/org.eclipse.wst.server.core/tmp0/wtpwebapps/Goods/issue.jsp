<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<haed>
    <meta charset="utf-8">
    <title>发布</title>
    <script src="./js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css">
    <script src="./js/bootstrap.min.js" type="text/javascript"></script>
</haed>

<body class="bg-warning">
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h2>发布</h2>
            </div>
            <div class="main">
                <form class="form-group col-md-12 bg-primary">
                    <div class="col-md-6">
                        <label for="title">标题</label>
                        <input type="text" id="title" class="form-control" name="title" placeholder="请输入标题">
                    </div>
                    <div class="col-md-2">
                        <label for="sort">类型</label>
                        <select name="sort" id="sort" class="form-control">
                            <option value="1">交流</option>
                            <option value="0">失物招领</option>
                        </select>
                    </div>

                    <div class="col-md-12">
                        <label for="content">内容</label>
                        <textarea name="content" id="content" cols="120" rows="10" class="form-control" placeholder="请输入50字符以上"></textarea>
                    </div>
                </form>
                <div class="btn-group col-md-2 pull-right">
                    <button class="btn btn-lg btn-success" id="submit" onclick="formPush()">发布</button>
                    <button class="btn btn-default  btn-lg" onclick="formEmpty()">重置</button>
                </div>
            </div>
        </div>
    </div>
    <script src="./js/issue.js" type="text/javascript"></script>
</body>

</html>