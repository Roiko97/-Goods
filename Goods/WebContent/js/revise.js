        // 验证手机重复
        function checkphone() {
            var phone = jQuery('#phone').val();
            var phonehelp = jQuery('#phoneHelp');
            if (phone.trim().lastIndexOf(" ") == -1 && (phone.trim() == null || phone.trim() == "" || phone.trim() == undefined)) {
                phonehelp.html('手机为空，提交后不修改原来信息！');
                phonehelp.css('color', '#c60');
                flagphone = true;
                phone = null;
                return true;
            } else {
                if (!verifyphone()) {
                    flagphone = false;
                    return false;
                } else
                    phonehelp.html('');
            }
            jQuery.ajax({
                url: "duplicatedUserServlet",
                data: {
                    "phone": phone
                },
                dataType: "json",
                type: "POST",
                success: function(result) {
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
        // 验证邮箱重复
        function checkemail() {
            var email = jQuery('#email').val();
            var emailHelp = jQuery('#emailHelp');
            if (email.trim().lastIndexOf(" ") == -1 && (email.trim() == null || email.trim() == "" || email.trim() == undefined)) {
                emailHelp.html('邮箱为空，提交后不修改原来信息！');
                emailHelp.css('color', '#c60');
                flagemail = true;
                email = null;
                return true;
            } else {
                if (!verifyemail()) {
                    flagemail = false;
                    return false;
                } else
                    emailHelp.html('');
            }
            jQuery.ajax({
                url: "duplicatedUserServlet",
                data: {
                    "email": email
                },
                dataType: "json",
                type: "POST",
                success: function(result) {
                    var re = result.result;
                    if (!re) {
                        emailHelp.html('该邮箱已被注册，请重新输入！');
                        emailHelp.css('color', 'red');
                        flagemail = false;
                        return false;
                    } else {
                        emailHelp.html('');
                        flagemail = true;
                        return true;
                    }

                }
            });
        }
        // 验证密码
        function checkuserpass() {
            var password = jQuery('#password').val();
            var passwordHelp = jQuery('#passwordHelp');
            if (password.trim().lastIndexOf(" ") == -1 && (password.trim() == null || password.trim() == "" || password.trim() == undefined)) {
                passwordHelp.html('密码为空，提交后不修改原来信息！');
                passwordHelp.css('color', '#c60');
                flagpassword = true;
                password = null;
                return true;
            } else {
                if (!verifyuserpass()) {
                    flagpassword = false;
                    return false;
                } else
                    passwordHelp.html('');
            }
        }
        // 验证昵称重复
        function checknickname() {
            var name = jQuery('#name').val();
            var nameHelp = jQuery('#nameHelp');
            if (name.trim().lastIndexOf(" ") == -1 && (name.trim() == null || name.trim() == "" || name.trim() == undefined)) {
                nameHelp.html('名字为空，提交后不修改原来信息！');
                nameHelp.css('color', '#c60');
                flagname = true;
                name = null;
                return true;
            } else {
                if (!verifyname()) {
                    flagname = false;
                    return false;
                } else
                    nameHelp.html('');
            }
            jQuery.ajax({
                url: "duplicatedUserServlet",
                data: {
                    "name": name
                },
                dataType: "json",
                type: "POST",
                success: function(result) {
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
        //验证邮箱
        function verifyemail() {
            var myreg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
            if (!myreg.test(jQuery('#email').val()) || jQuery('#email').val().trim().lastIndexOf(" ") != -1) {
                $("#emailHelp").html("邮箱格式错误!");
                $("#emailHelp").css('color', "red");
                flagemail = false;
                return false;
            } else if (jQuery('#email').val().trim().lastIndexOf(" ") == -1) {
                $("#emailHelp").html("");
                flagemail = true;
                return true;
            }
        }
        //验证年龄
        function verifyage() {
            var myreg = /^[-+]?\d*$/;
            if (!myreg.test(jQuery('#age').val()) || jQuery('#age').val().trim().lastIndexOf(" ") != -1) {
                $("#ageHelp").html("年龄格式错误!");
                $("#ageHelp").css('color', "red");
                flagage = false;
                return false;
            } else if (jQuery('#age').val().trim().lastIndexOf(" ") == -1) {
                $("#ageHelp").html("");
                flagage = true;
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
        var flagage;
        var flagpassword;
        var flagname;
        var flagemail;
        var flagphone;
        var flaggender;
        //提交修改信息
        function revise() {
            var password = jQuery('#password');
            var name = jQuery("#name");
            var email = jQuery("#email");
            var phone = jQuery("#phone");
            var age = jQuery("#age");
            var gender = document.getElementsByName("gender");
            if (typeof flagpassword === 'undefined') {
                password.value = null;
                flagpassword = true;
            }
            if (typeof flagname === 'undefined') {
                name.value = null;
                flagname = true;
            }
            if (typeof flagemail === 'undefined') {
                email.value = null;
                flagemail = true;
            }
            if (typeof flagphone === 'undefined') {
                phone.value = null;
                flagphone = true;
            }
            if (typeof flagage === 'undefined') {
                age.value = 0;
                flagage = true;
            }
            if (typeof flaggender === 'undefined') {
                gender.value = '男';
                flaggender = true;
            }
            var sendgender;
            if (gender[0].checked == true)
                sendgender = gender[0].value;
            else
                sendgender = gender[1].value;
            //          console.log(flagpassword);
            // 	         console.log(flagname);
            // 	         console.log(flagemail);
            // 	         console.log(flagphone);
            // 	         console.log(flagage);
            // 	         console.log(flaggender);
            //             console.log(typeof password.val()+"/"+password.val()+123);
            //             console.log(phone.value+456);
            //             console.log(email.value+123);
            //             console.log(name.value+321);
            //             console.log(age.value);
            //             console.log(typeof gender.value+"/"+gender.value);
            if (!flagemail || !flagphone || !flagname || !flagpassword || !flagage)
                return false;
            if (flagemail && flagphone && flagname && flagpassword && flagage) {
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "userReviseServlet",
                    data: {
                        "password": password.val(),
                        "phone": phone.val(),
                        "name": name.val(),
                        "gender": sendgender,
                        "email": email.val(),
                        "age": Number(age.val())
                    },
                    success: function(result) {}
                });
                return true;
            }
        }
        //#student_activate hide
        $('#student_activate').hide();
        $('#teacher_activate').hide();
        $('#activation_activate').hide();

        function student_show() {
            if ($('#student_activate').is(":hidden")) {
                $('#teacher_activate').hide();
                $('#activation_activate').hide();
                $('#student_activate').show();
                document.getElementById("student_activate").parentElement.className = "jumbotron col-md-9";
                $('#revise_logo').attr("src", "./src/LOGO1.gif");
            }
            //            else {
            //                $('#student_activate').hide();
            //            }
        }

        function teacher_show() {
            if ($('#teacher_activate').is(':hidden')) {
                $('#student_activate').hide();
                $('#activation_activate').hide();
                $('#teacher_activate').show();
                document.getElementById("teacher_activate").parentElement.className = "jumbotron col-md-9";
                $('#revise_logo').attr("src", "./src/LOGO1.gif");
            }
            //            else {
            //                $('#teacher_activate').hide();
            //            }
        }

        function activation_show() {
            if ($('#activation_activate').is(':hidden')) {
                $('#student_activate').hide();
                $('#teacher_activate').hide();
                $('#activation_activate').show();
                document.getElementById("activation_activate").parentElement.className = "jumbotron col-md-9";
                $('#revise_logo').attr("src", "./src/LOGO1.gif");
            }
            //            else{
            //                $('#activation_activate').hide();
            //            }
        }

        //学生认证隐藏
        function cancle1_close() {
            document.getElementById("student_id").value = "";
            document.getElementById("student_password").value = "";
            $('#student_activate').hide();
            document.getElementById("student_activate").parentElement.className = "col-md-9";
            $('#revise_logo').attr("src", "./src/LOGO128.ico");
        }
        //教师认证隐藏
        function cancle2_close() {
            document.getElementById("teacher_id").value = "";
            document.getElementById("teacher_password").value = "";
            $('#teacher_activate').hide();
            document.getElementById("teacher_activate").parentElement.className = "col-md-9";
            $('#revise_logo').attr("src", "./src/LOGO128.ico");
        }
        //激活码认证隐藏
        function cancle3_close() {
            document.getElementById("activation1").value = "";
            document.getElementById("activation2").value = "";
            document.getElementById("activation3").value = "";
            document.getElementById("activation4").value = "";
            $('#activation_activate').hide();
            document.getElementById("activation_activate").parentElement.className = "col-md-9";
            $('#revise_logo').attr("src", "./src/LOGO128.ico");
        }
        //激活码跳转输入框
        function checkLen(x, y) {
            if (y.length == x.maxLength) {
                var next = x.tabIndex;
                //是否到了最后一个文本框
                if (next < document.getElementById("activation_activate").length) {
                    document.getElementById("activation_activate").elements[next].focus();
                }
            }
        }
        //检测数字正则表达式
        function checkNum(e) {
            var keynum;
            var keychar;
            var numcheck;
            if (window.event) {
                keynum = e.keyCode;
            } else if (e.which) {
                keynum = e.which;
            }
            keychar = String.fromCharCode(keynum);
            numcheck = /\d/;
            return numcheck.test(keychar);
        }
        //验证工号
        function checkteacherid() {
            var teacher_id = jQuery('#teacher_id').val();
            var teacheridHelp = jQuery('#teacheridHelp');
            if (teacher_id == null || teacher_id == "") {
                return false;
            } else {
                teacheridHelp.html('');
            }
            return true;
        }
        //验证教师密码
        function checkteacherpass() {
            var teacher_password = jQuery('#teacher_password').val();
            var teacherpassHelp = jQuery('#teacherpassHelp');
            if (teacher_password == null || teacher_password == "") {
                return false;
            } else {
                teacherpassHelp.html('');
            }
            return true;
        }
        //验证学号
        function checkstudentid() {
            var student_id = jQuery('#student_id').val();
            var studentidHelp = jQuery('#studentidHelp');
            if (student_id == null || student_id == "") {
                return false;
            } else {
                studentidHelp.html('');
            }
            return true;
        }
        //验证学生密码
        function checkstudentpass() {
            var student_password = jQuery('#student_password').val();
            var studentpassHelp = jQuery('#studentpassHelp');
            if (student_password == null || student_password == "") {
                return false;
            } else {
                studentpassHelp.html('');
            }
            return true;
        }

        //提交表单 学生
        function student_activate() {
            var studentpassHelp = jQuery('#studentpassHelp');
            var studentidHelp = jQuery('#studentidHelp');
            if (!checkstudentid()) {
                studentidHelp.html('请输入学号');
                studentidHelp.css('color', '#c60');
                return false;
            }
            if (!checkstudentpass()) {
                studentpassHelp.html('请输入密码');
                studentpassHelp.css('color', '#c60');
                return false;
            }
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "userReviseServlet",
                data: $('#student_activate').serialize(),
                success: function(result) {
                    var re = result.result;
                    if (!re) {
                        window.location.href = "./revise.jsp";
                    } else {
                        window.location.href = "./index.jsp";
                    }
                }
            });
            return true;
        }
        //提交表单 教师
        function teacher_activate() {
            var teacheridHelp = jQuery('#teacheridHelp');
            var teacherpassHelp = jQuery('#teacherpassHelp');
            if (!checkteacherid()) {
                teacheridHelp.html('请输入工号');
                teacheridHelp.css('color', '#c60');
                return false;
            }
            if (!checkteacherpass()) {
                teacherpassHelp.html('请输入密码');
                teacherpassHelp.css('color', '#c60');
                return false;
            }
            $.ajax({
                type: "POST",
                dataType: "json",
                url: "userReviseServlet",
                data: $('#teacher_activate').serialize(),
                success: function(result) {
                    var re = result.result;
                    if (!re) {
                        window.location.href = "./revise.jsp";
                    } else {
                        window.location.href = "./index.jsp";
                    }
                }
            });
            return true;
        }

        var activationHelp = jQuery('#activationHelp');
        //检验激活码格式
        function checkactivation1() {
            var activation1 = jQuery('#activation1').val();
            if (activation1 == null || activation1 == "" || typeof activation1 === 'undefined' || activation1.length < 4) {
                activationHelp.html('×');
                activationHelp.css('color', 'red');
                return false;
            } else {
                activationHelp.html('');
            }
            return true;
        }

        function checkactivation2() {
            var activation2 = jQuery('#activation2').val();
            if (activation2 == null || activation2 == "" || typeof activation2 === 'undefined' || activation2.length < 4) {
                activationHelp.html('×');
                activationHelp.css('color', 'red');
                return false;
            } else {
                activationHelp.html('');
            }
            return true;
        }

        function checkactivation3() {
            var activation3 = jQuery('#activation3').val();
            if (activation3 == null || activation3 == "" || typeof activation3 === 'undefined' || activation3.length < 4) {
                activationHelp.html('×');
                activationHelp.css('color', 'red');
                return false;
            } else {
                activationHelp.html('');
            }
            return true;
        }

        function checkactivation4() {
            var activation4 = jQuery('#activation4').val();
            if (activation4 == null || activation4 == "" || typeof activation4 === 'undefined' || activation4.length < 4) {
                activationHelp.html('×');
                activationHelp.css('color', 'red');
                return false;
            } else {
                activationHelp.html('');
            }
            return true;
        }
        //验证激活码
        function checkactivation() {
            var activation1 = jQuery('#activation1').val();
            var activation2 = jQuery('#activation2').val();
            var activation3 = jQuery('#activation3').val();
            var activation4 = jQuery('#activation4').val();
            var activation;
            if (checkactivation1() && checkactivation2() && checkactivation3() && checkactivation4()) {
                activation = activation1 + activation2 + activation3 + activation4;
                /*	console.log(activation1);
                	console.log(activation2);
                	console.log(activation3);
                	console.log(activation4);
                	console.log(activation);*/
                $.ajax({
                    url: "duplicatedUserServlet",
                    data: {
                        "activation": activation
                    },
                    dataType: "json",
                    type: "POST",
                    success: function(result) {
                        var re = result.result;
                        if (!re) {
                            activationHelp.html('×');
                            activationHelp.css('color', 'red');
                            return false;
                        } else {
                            activationHelp.html('√');
                            activationHelp.css('color', 'green');
                            return true;
                        }
                    }
                });
            }
            return true;
        }
        //提交表单 激活码
        function activation_activate() {
            if (!checkactivation()) {
                return false;
            } else {
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: "userReviseServlet",
                    data: $('#activation_activate').serialize(),
                    success: function(result) {
                        var re = result.result;
                        if (!re) {
                            window.location.href = "./revise.jsp";
                        } else {
                            window.location.href = "./index.jsp";
                        }
                    }
                });
                return true;
            }
        }