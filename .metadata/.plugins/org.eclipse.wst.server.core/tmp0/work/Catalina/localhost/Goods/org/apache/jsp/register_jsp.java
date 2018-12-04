/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.33
 * Generated at: 2018-12-03 08:45:02 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>register</title>\n");
      out.write("    <script src=\"./js/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <script src=\"./js/bootstrap.min.js\"></script>\n");
      out.write("    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"col-lg-8 col-md-offset-2\">\n");
      out.write("            <div class=\"panel panel-success\">\n");
      out.write("                <!--标题-->\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <h1>注册</h1>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <div class=\"row center-block\">\n");
      out.write("                        <!--注册信息表单-->\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <form class=\"form-horizontal\" method=\"post\" action=\"userRegisterServlet\" role=\"form\" id=\"register\">\n");
      out.write("                                <!--账号-->\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2 input-group\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"userName\">账号</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"text\" id=\"userName\" name=\"userName\" class=\"form-control\" placeholder=\"请输入账号\" onchange=\"checkusername()\" maxlength=\"20\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-certificate form-control-feedback\" style=\"color:red;\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"userNameHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!--密码-->\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-labelv\" for=\"password\">密码</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"password\" id=\"password\" name=\"password\" class=\"form-control\" placeholder=\"请输入密码\" onchange=\"checkuserpass()\" maxlength=\"20\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-certificate form-control-feedback\" style=\"color:red;\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"passwordHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!--手机-->\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"phone\">手机</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"tel\" id=\"phone\" name=\"phone\" class=\"form-control\" placeholder=\"请输入有效11位号码\" onchange=\"checkphone()\" maxlength=\"11\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-certificate form-control-feedback\" style=\"color:red;\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"phoneHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!--昵称-->\n");
      out.write("                                <div class=\"form-group col-md-12\">\n");
      out.write("                                    <div class=\"input-group col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"input-group-addon\">\n");
      out.write("                                            <label class=\"control-label\" for=\"name\">昵称</label>\n");
      out.write("                                        </span>\n");
      out.write("                                        <input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" placeholder=\"请输入昵称\" onchange=\"checknickname()\" maxlength=\"20\">\n");
      out.write("                                        <span class=\"glyphicon glyphicon-certificate form-control-feedback\" style=\"color:red;\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                                        <span class=\"help-block text-left\" id=\"nameHelp\"></span>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <!--已注册跳转-->\n");
      out.write("                                <div class=\"form-group col-md-12 text-center\">\n");
      out.write("                                    <a href=\"./index.jsp\">已注册用户，请点击进入登陆。</a>\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <!--LOGO-->\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <img src=\"src/Logo.png\" class=\"img-responsive\" alt=\"LOGO\">\n");
      out.write("                        </div>\n");
      out.write("                        <!--表单按钮-->\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"modal-footer center-block col-md-12\">\n");
      out.write("                                <input type=\"button\" id=\"btn\" class=\"btn btn-success col-md-4 col-md-offset-2\" value=\"注册\" name=\"registersubmit\" onclick=\"register()\">\n");
      out.write("                                <input type=\"button\" id=\"btn-cancl\" class=\"btn btn-default col-md-4\" data-dismiss=\"modal\" value=\"取消\" onclick=\"cnaclRegister()\">\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("<script src=\"./js/register.js\" type=\"text/javascript\"></script>\n");
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
