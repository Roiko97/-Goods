/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.33
 * Generated at: 2018-12-05 09:05:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class revise_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>修改信息</title>\n");
      out.write("    <script src=\"./js/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"./js/bootstrap.min.js\"></script>\n");
      out.write("    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-8 col-md-offset-2\">\n");
      out.write("            <div class=\"panel panel-info\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h1> 修改资料</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <!--修改信息表单-->\n");
      out.write("                        <div class=\"col-md-6 col-sm-8 col-xs-8 col-xxs-12\">\n");
      out.write("                            <form class=\"form-horizontal\" method=\"post\" action=\"userReviseServlet\" role=\"form\" id=\"revise\">\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"col-md-10 col-md-offset-1 input-group\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"cantrol-label\" for=\"Uesrname\">账号</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input value='");
      out.print(session.getAttribute("userID") );
      out.write("' type=\"text\" id=\"userName\" name=\"userName\" class=\"form-control\" placeholder=\"请输入账号\" disabled=\"disabled\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-1\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"userNameHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-10 col-md-offset-1\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-labelv\" for=\"password\">密码</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" placeholder=\"请输入密码\" onchange=\"checkuserpass()\" maxlength=\"20\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-1\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"passwordHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-10 col-md-offset-1\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"phone\">手机</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"tel\" id=\"phone\" name=\"phone\" class=\"form-control\" placeholder=\"请输入有效11位号码\" onchange=\"checkphone()\" maxlength=\"11\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-1\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"phoneHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-10 col-md-offset-1\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"name\">昵称</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" placeholder=\"请输入昵称\" onchange=\"checknickname()\" maxlength=\"20\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"nameHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-10 col-md-offset-1\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"email\">邮箱</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"text\" id=\"email\" name=\"email\" class=\"form-control\" placeholder=\"xxxx@163.com\" onchange=\"checkemail()\" value=\"\" maxlength=\"20\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-1\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"emailHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-10 col-md-offset-1\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"age\">年龄</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"number\" id=\"age\" name=\"age\" class=\"form-control\" onchange=\"verifyage()\" value=\"0\" maxlength=\"4\" min=\"0\" max=\"100\">\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-1\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"ageHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-10 col-md-offset-1\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"gender\">性别</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <input type=\"radio\" id=\"gendermale\" name=\"gender\" value=\"男\" checked />男\n");
      out.write("                                        </span>\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <input type=\"radio\" id=\"genderfemale\" name=\"gender\" value=\"女\" />女\n");
      out.write("                                        </span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <!--权限认证-->\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <div class=\"form-group col-md-10 col-md-offset-1\">\n");
      out.write("                                <div class=\"input-group col-md-6    \">\n");
      out.write("                                    <span class=\"input-group-addon\">\n");
      out.write("                                        <label class=\"control-label\" for=\"activate\">权限认证\n");
      out.write("                                        </label>\n");
      out.write("                                    </span>\n");
      out.write("                                    <span class=\"input-group-addon\">\n");
      out.write("                                        <input type=\"radio\" id=\"Stu_activate\" name=\"Activate\" value=\"Student\" onclick=\"student_show()\" />学生\n");
      out.write("                                    </span>\n");
      out.write("                                    <span class=\"input-group-addon\">\n");
      out.write("                                        <input type=\"radio\" id=\"Tea_activate\" name=\"Activate\" value=\"Teacher\" onclick=\"teacher_show()\" />教师\n");
      out.write("                                    </span>\n");
      out.write("                                    <span class=\"input-group-addon\">\n");
      out.write("                                        <input type=\"radio\" id=\"Act_activate\" name=\"Activate\" value=\"Activation\" onclick=\"activation_show()\" />商家/组织\n");
      out.write("                                    </span>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- 学生认证-->\n");
      out.write("                            <div class=\"col-md-9\">\n");
      out.write("                                <form class=\"form-horizontal col-md-12\" method=\"post\" action=\"userReviseServlet\" role=\"form\" id=\"student_activate\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-10 col-md-offset-1 input-group\">\n");
      out.write("                                            <span class=\"input-group-addon\">\n");
      out.write("                                                <label class=\"control-label\" for=\"studentid\">学号</label>\n");
      out.write("                                            </span>\n");
      out.write("                                            <input type=\"text\" id=\"student_id\" name=\"student_id\" class=\"form-control\" placeholder=\"请输入学号\" onchange=\"checkstudentid()\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                            <span class=\"help-block text-left\" id=\"studentidHelp\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-10 col-md-offset-1 input-group\">\n");
      out.write("                                            <span class=\"input-group-addon\">\n");
      out.write("                                                <label class=\"control-label\" for=\"studentpass\">密码</label>\n");
      out.write("                                            </span>\n");
      out.write("                                            <input type=\"password\" id=\"student_password\" name=\"student_password\" class=\"form-control\" placeholder=\"请输入密码\" onchange=\"checkstudentpass()\" maxlength=\"20\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                            <span class=\"help-block text-left\" id=\"studentpassHelp\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                            <input type=\"button\" id=\"btn_student_activate\" class=\"btn btn-success pull-left\" value=\"激活\" onclick=\"student_activate()\">\n");
      out.write("                                            <input type=\"button\" id=\"btn-cancle1\" class=\"btn btn-default pull-right\" value=\"关闭\" data-dismiss=\"modal\" onclick=\"cancle1_close()\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                                <!-- 教师认证 -->\n");
      out.write("                                <form class=\"form-horizontal\" method=\"post\" action=\"userReviseServlet\" role=\"form\" id=\"teacher_activate\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-10 col-md-offset-1 input-group\">\n");
      out.write("                                            <span class=\"input-group-addon\">\n");
      out.write("                                                <label class=\"control-label\" for=\"teacherid\">工号</label>\n");
      out.write("                                            </span>\n");
      out.write("                                            <input type=\"text\" id=\"teacher_id\" name=\"teacher_id\" class=\"form-control\" placeholder=\"请输入工号\" onchange=\"checkteacherid()\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                            <span class=\"help-block text-left\" id=\"teacheridHelp\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-10 col-md-offset-1 input-group\">\n");
      out.write("                                            <span class=\"input-group-addon\">\n");
      out.write("                                                <label class=\"control-label\" for=\"teacherpass\">密码</label>\n");
      out.write("                                            </span>\n");
      out.write("                                            <input type=\"password\" id=\"teacher_password\" name=\"teacher_password\" class=\"form-control\" placeholder=\"请输入密码\" onchange=\"checkteacherpass()\" maxlength=\"20\">\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                            <span class=\"help-block text-left\" id=\"teacherpassHelp\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                            <input type=\"button\" id=\"btn_teacher_activate\" class=\"btn btn-success pull-left\" value=\"激活\" onclick=\"teacher_activate()\">\n");
      out.write("                                            <input type=\"button\" id=\"btn-cancle2\" class=\"btn btn-default pull-right\" value=\"关闭\" data-dismiss=\"modal\" onclick=\"cancle2_close()\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                                <!--激活码认证-->\n");
      out.write("                                <form class=\"form-horizontal\" method=\"post\" action=\"userReviseServlet\" role=\"form\" id=\"activation_activate\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-4 input-group\">\n");
      out.write("                                            <div>\n");
      out.write("                                                <h4 style=\"color:green\"> 激活码</h4>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-12\">\n");
      out.write("                                            <div class=\"col-md-10 input-group col-md-offset-2\">\n");
      out.write("                                                <input id=\"activation1\" name=\"activation1\" tabindex=\"1\" type=\"text\" size=\"4\" maxlength=\"4\" onchange=\"checkactivation1()\" onkeyup=\"checkLen(this,this.value)\" onkeypress=\"return checkNum(event)\" /> -\n");
      out.write("                                                <input id=\"activation2\" name=\"activation2\" tabindex=\"2\" type=\"text\" size=\"4\" maxlength=\"4\" onchange=\"checkactivation2()\" onkeyup=\"checkLen(this,this.value)\" onkeypress=\"return checkNum(event)\" /> -\n");
      out.write("                                                <input id=\"activation3\" name=\"activation3\" tabindex=\"3\" type=\"text\" size=\"4\" maxlength=\"4\" onchange=\"checkactivation3()\" onkeyup=\"checkLen(this,this.value)\" onkeypress=\"return checkNum(event)\" /> -\n");
      out.write("                                                <input id=\"activation4\" name=\"activation4\" tabindex=\"4\" type=\"text\" size=\"4\" maxlength=\"4\" onchange=\"checkactivation4()\" onkeyup=\"checkLen(this,this.value)\" onkeypress=\"return checkNum(event)\" />\n");
      out.write("                                            </div>\n");
      out.write("                                            <span class=\"istrue\" id=\"activationHelp\"></span>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group col-md-12\">\n");
      out.write("                                            <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                                <input type=\"button\" id=\"btn_activation_activate\" class=\"btn btn-success pull-left\" value=\"激活\" onclick=\"activation_activate()\">\n");
      out.write("                                                <input type=\"button\" id=\"btn-cancle3\" class=\"btn btn-default pull-right\" value=\"关闭\" data-dismiss=\"modal\" onclick=\"cancle3_close()\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <!--LOGO-->\n");
      out.write("                        <div class=\"col-md-4 col-md-offset-1\">\n");
      out.write("                            <img src=\"./src/LOGO128.ico\" class=\"col-md-12\" id=\"revise_logo\">\n");
      out.write("                        </div>\n");
      out.write("                        <!--提交按钮-->\n");
      out.write("                        <div class=\"modal-footer center-block  center-block col-md-12\">\n");
      out.write("                            <input type=\"button\" id=\"btn\" class=\"btn btn-success col-md-4 col-md-offset-2\" value=\"修改\" name=\"reviseSubmit\" onclick=\"revise()\">\n");
      out.write("                            <input type=\"button\" id=\"btn-cancl\" class=\"btn btn-default col-md-4\" data-dismiss=\"modal\" value=\"取消\" onclick=\"\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <script type=\"text/javascript\" src=\"./js/revise.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
