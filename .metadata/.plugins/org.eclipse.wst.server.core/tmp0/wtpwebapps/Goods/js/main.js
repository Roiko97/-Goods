var news;
var circum;
var bussness;
var communication;
var work;
var flag;
//Title标题
var title = (function getTitle() {
    return $('title').attr('title');
}());
/*主要*/
function start() {
    createNav('nav');
    createCode();
    checkCookie();
    init(title);
}
//初始化
function init(title) {
    switch (title) {
        case "index":
            {
                news = new newsObj();
                news.init(window);
                break;
            }
        case "circum":
            {
                circum = new circumObj();
                circum.init();
                break;
            }
        case "bussness":
            {
                bussness = new bussessObj();
                bussness.init();
                break;
            }
        case "communication":
            {
                communication = new communicationObj();
                var sort = getCookie('sort');
                if (sort == 'true') {
                    communication.flag = 0;
                } else if(sort == 'false') {
                    communication.flag = 1;
                }
                clearCookie('sort');
                communication.init();
                break;
            }
            case "work":
            {
                work = new workObj();
                work.init();
                break;
            }
    }

}

function pushPassage() {
    location.href = './index.jsp';
}

function circum() {
    location.href = './circum.jsp';
}

function bussness() {
    location.href = './bussness.jsp';
}

function communication_1() {
    setCookie('sort', true, 1);
    location.href = './communication.jsp?1';
}
function communication_2() {
    setCookie('sort', false, 1);
    location.href = './communication.jsp?2';
}
function work(){
    location.href = './work.jsp';
}
// 验证账号
function checkuserName() {
    var userName = jQuery('#userName').val();
    if (userName == null || userName == "")
        return false;
    else
        return true;
}
// 验证密码
function checkpassword() {
    var password = jQuery('#password').val();
    if (password == "" || password == null)
        return false;
    else
        return true;
}
var code;
//验证验证码
function verification() {
    var inputCode = document.getElementById("inputCode").value.toUpperCase();
    if (inputCode.length <= 0) {
        $("#inputCode").focus();
        alert("请输入验证码");
        return false;
    }
    if (inputCode != code) {
        alert("验证码错误");
        document.getElementById("inputCode").value = "";
        document.getElementById("userName").value = "";
        document.getElementById("password").value = "";
        $("#userName").focus();
        createCode();
        return false;
    } else
        return true;
}
//创建验证码
function createCode() {
    code = "";
    var codeLength = 4;
    var checkCode = document.getElementById("code");
    var random = new Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D',
        'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
        'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
    for (var i = 0; i < codeLength; i++) {
        var index = Math.floor(Math.random() * 36);
        code += random[index];
    }
    checkCode.value = code;
}
//登录验证
function login() {
    if (!verification()) {
        return false;
    } else if (!checkpassword() || !checkuserName()) {
        alert("账号或密码错误，登录失败！");
        document.getElementById("inputCode").value = "";
        document.getElementById("userName").value = "";
        document.getElementById("password").value = "";
        createCode();
        return false;
    } else {
        //ajax表单提交
        jQuery.ajax({
            type: "POST",
            dataType: "json",
            url: "userLoginServlet",
            data: $('#login').serialize(),
            success: function (result) {
                var re = result.result;
                if (!re) {
                    setCookie('flag', false, 1);
                    location.href = "./" + title + ".jsp";
                } else {
                    setCookie('flag', true, 1);
                    location.href = "./" + title + ".jsp";
                }
            },
            error: function () {
                setCookie('flag', false, 1);
                location.href = "./" + title + ".jsp";
            }
        });
        //表单提交
        //        var form = document.getElementById('login');
        //        form.submit();
        return true;
    }
}
//刷新登录信息
function checkCookie() {
    $('#log-status').hide();
    let login = document.getElementById('log-button').childNodes[0];
    let logou = document.getElementById('log-button').childNodes[1];
    logou.onclick = function () {
        location.href = "./" + title + ".jsp?logout=exit";
    };
    login.style.display = 'inline';
    logou.style.display = 'none';
    var sessionText = $.trim(document.getElementById('username').innerHTML);
    console.log(sessionText);
    flag = getCookie("flag");
    if (flag == "false" && sessionText == 'null') {
        $("#login-Modal").modal();
        clearCookie("flag");
    } else if (flag == 'true' && sessionText != 'null') {
        $('#log-status').html(sessionText);
        $('#log-status').show();
        login.style.display = 'none';
        logou.style.display = 'inline';
        $('#log-status').attr('href', 'revise.jsp');
        clearCookie("flag");
    } else if (flag == 'true' && sessionText == 'null') {
        $("#login-Modal").modal();
        clearCookie("flag");
    } else if (flag == "false" && sessionText != 'null') {
        clearCookie("flag");
        location.href = "./" + title + ".jsp?logout=exit";
    } else if (sessionText == 'null') {

    } else if (sessionText != 'null') {
        $('#log-status').html(sessionText);
        $('#log-status').show();
        login.style.display = 'none';
        logou.style.display = 'inline';
        $('#log-status').attr('href', 'revise.jsp');
        clearCookie("flag");
    }
}
//获取cookies
function getCookie(c_name) {
    if (document.cookie.length > 0) {
        c_start = document.cookie.indexOf(c_name + "=");
        if (c_start != -1) {
            c_start = c_start + c_name.length + 1;
            c_end = document.cookie.indexOf(";", c_start);
            if (c_end == -1)
                c_end = document.cookie.length;
            return decodeURI(document.cookie.substring(c_start, c_end));
        }
        return "";
    }
}
//设置cookies
function setCookie(c_name, value, expiredays) {
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + expiredays);
    document.cookie = c_name + "=" + encodeURI(value) + ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());

}
//清除cookies    
function clearCookie(c_name) {
    setCookie(c_name, "", -1);
}