 // 验证手机重复
 function checkphone() {
     var phone = jQuery('#phone').val();
     var phonehelp = jQuery('#phoneHelp');
     if (phone == null || phone == "") {
         phonehelp.html('手机为空，请重新输入！');
         phonehelp.css('color', 'red');
         flagphone = false;
         return false;
     } else
         phonehelp.html('');
     if (!verifyphone()) {
         flagphone = false;
         return false;
     }
     jQuery.ajax({
         url: "duplicatedUserServlet",
         data: {
             "phone": phone
         },
         dataType: "json",
         type: "POST",
         success: function (result) {
             var re = result.result;
             if (!re) {
                 phonehelp.html('该手机已被注册，请重新输入！');
                 phonehelp.css('color', 'red');
                 flagphone = false;
                 return false;
             } else {
                 phonehelp.html('');
                 flagphone = true;
                 return true;
             }

         }
     });
 }
 // 验证账号重复
 function checkusername() {
     var userName = jQuery('#userName').val();
     var userNameHelp = jQuery('#userNameHelp');
     if (userName == null || userName == "") {
         userNameHelp.html('账号为空，请重新输入！');
         userNameHelp.css('color', 'red');
         flagusername = false;
         return false;
     } else
         userNameHelp.html('');
     if (jQuery('#userName').val().trim().lastIndexOf(" ") != -1) {
         $("#userNameHelp").html("账号格式错误，不能包含空格！");
         $("#userNameHelp").css('color', "red");
         flagusername = false;
         return false;
     }
     jQuery.ajax({
         url: "duplicatedUserServlet",
         data: {
             "userName": userName
         },
         dataType: "json",
         type: "POST",
         success: function (result) {
             var re = result.result;
             if (!re) {
                 userNameHelp.html('账号已被使用，请重新输入！');
                 userNameHelp.css('color', 'red');
                 flagusername = false;
                 return false;
             } else {
                 userNameHelp.html('');
                 flagusername = true;
                 return true;
             }
         }
     });
 }
 // 验证密码
 function checkuserpass() {
     var myreg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$/;
     if (!myreg.test(jQuery('#password').val()) || jQuery('#password').val().trim().lastIndexOf(" ") != -1) {
         $("#passwordHelp").html("密码格式错误!");
         $("#passwordHelp").css('color', "red");
         flagpassword = false;
         return false;
     } else if (jQuery('#password').val().trim().lastIndexOf(" ") == -1) {
         $("#passwordHelp").html("");
         flagpassword = true;
         return true;
     }
 }
 // 验证昵称重复
 function checknickname() {
     var name = jQuery('#name').val();
     var nameHelp = jQuery('#nameHelp');
     if (name == null || name == "") {
         nameHelp.html('昵称为空，请重新输入！');
         nameHelp.css('color', 'red');
         flagname = false;
         return false;
     } else
         nameHelp.html('');
     if (!verifyname()) {
         flagname = false;
         return false;
     }
     jQuery.ajax({
         url: "duplicatedUserServlet",
         data: {
             "name": name
         },
         dataType: "json",
         type: "POST",
         success: function (result) {
             var re = result.result;
             if (!re) {
                 nameHelp.html('昵称已被使用，请重新输入！');
                 nameHelp.css('color', 'red');
                 flagname = false;
                 return false;
             } else {
                 nameHelp.html('');
                 flagname = true;
                 return true;
             }
         }
     });
 }
 //验证手机号码
 function verifyphone() {
     var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
     if (!myreg.test(jQuery('#phone').val()) || jQuery('#phone').val().trim().lastIndexOf(" ") != -1) {
         $("#phoneHelp").html("手机格式错误!");
         $("#phoneHelp").css('color', "red");
         flagphone = false;
         return false;
     } else if (jQuery('#phone').val().trim().lastIndexOf(" ") == -1) {
         $("#phoneHelp").html("");
         flagphone = true;
         return true;
     }
 }
 //验证密码
 function verifyuserpass() {
     var myreg = /^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,}$/;
     if (!myreg.test(jQuery('#password').val()) || jQuery('#password').val().trim().lastIndexOf(" ") != -1) {
         $("#passwordHelp").html("密码格式错误!");
         $("#passwordHelp").css('color', "red");
         flagpassword = false;
         return false;
     } else if (jQuery('#password').val().trim().lastIndexOf(" ") == -1) {
         $("#passwordHelp").html("");
         flagpassword = true;
         return true;
     }
 }
 //验证昵称
 function verifyname() {
     if (jQuery('#name').val().trim().lastIndexOf(" ") != -1) {
         $("#nameHelp").html("昵称格式错误，不能包含空格！");
         $("#nameHelp").css('color', "red");
         flagname = false;
         return false;
     } else if (jQuery('#name').val().trim().lastIndexOf(" ") == -1) {
         $("#nameHelp").html("");
         flagname = true;
         return true;
     }
 }
 var flagusername;
 var flagpassword;
 var flagname;
 var flagphone;
 //提交表单
 function register() {
     if (!flagusername || !flagpassword || !flagname || !flagphone)
         return false;
     if (flagusername && flagpassword && flagname && flagphone) {
         $.ajax({
             type: "POST",
             dataType: "json",
             url: "userRegisterServlet",
             data: $('#register').serialize(),
             success: function (result) {
                 var re = result.result;
                 if (!re) {
                     window.location.href = "./register.jsp";
                 } else {
                     window.location.href = "./index.jsp";
                 }
             }
         });
         return true;
     }
 }
 //取消提交
 function cnaclRegister() {
     window.location.href = "./index.jsp";
 }
