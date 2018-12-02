<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html lang="en">
<head lang="zh-CN">
    <title>On</title>
    <meta charset="utf-8">
    <script src="js/main.js" type="text/javascript"></script>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link href="css/on.css" rel="stylesheet" type="text/css">
    <link type="text/css" href="css/font-awesome.min.css" rel="stylesheet">
</head>

<body class="ms-windows">
    <div class="Goods-home">
        <!--
		导航栏
		<div class="navbar-fixed-top navbar-inverse">
			
		</div>
		
-->
        <div class="Goods-content">
            <div class="Goods-content-cell-whiteBlock">
                <div class="Goods-content-cell-whiteBlockcontent">
                    <div class="whiteBlockcontent-Header">
                        <img class="imgLogo" src="src/LOGO1.gif" />
                    </div>
                    <h1 class="whiteBlockcontent-Title">发现校园周边新鲜事</h1>
                    <div class="whiteBlockcontentform">
                        <h2 class="whiteBlockcontentTitle">现在就加入Goods。</h2>
                        <div class="buttons">
                            <a class="EdgeButton EdgeButton-primary  EdgeButton-buttonRegister a-decoration" href="javascript:location.href='register.jsp'">注册</a>
                            <a class="EdgeButton EdgeButton-secondary EdgeButton-buttonLogin a-decoration" href="javascript:location.href='index.jsp?logout=exit'" onclick="setCookie('flag', false, 1)">登录</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="Goods-content-cell-blueBlock">
                <div class="Goods-content-cell-blueBlockcontent">
                    <div class="Goods-content-cell-blueBlockcontent-item">
                        <span class="Icon fa fa-search">
                        </span>关注你的兴趣所在。
                    </div>
                    <div class="Goods-content-cell-blueBlockcontent-item">
                        <span class="Icon fa fa-comment-o">
                        </span>畅谈身边趣事。
                    </div>
                    <div class="Goods-content-cell-blueBlockcontent-item">
                        <span class="Icon fa fa-home">
                        </span>丰富大学生活。
                    </div>
                </div>
            </div>
        </div>
        <div class="Goods-footer Goods-footer-fixed">
            <ul class="Goods-footer-list">
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">关于</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">帮助中心</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="http://baidu.com" rel="noopener">百度</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">广告</a>
                </li>
                <li class="Goods-footer-item">
                    <a class="a-style" href="#" rel="noopener">开发者</a>
                </li>
                <li class="Goods-footer-item Goods-footer-coryright">© 2018 Goods</li>
            </ul>
        </div>
    </div>
</body>

</html>
