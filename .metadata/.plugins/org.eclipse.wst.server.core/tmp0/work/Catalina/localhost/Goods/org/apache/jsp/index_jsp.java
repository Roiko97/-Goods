/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.33
 * Generated at: 2018-12-11 05:07:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE HTML>\n");
      out.write("<html lang=\"en\">\n");

	String flag = request.getParameter("logout");
	if(flag != null)	
	{
		session.removeAttribute("userID");
	}

      out.write("\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <title title=\"index\">新闻</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <script src=\"./js/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"./js/bootstrap.min.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"./js/jquery.jSlider.js\" type=\"text/javascript\"></script>\n");
      out.write("    <link href=\"./css/jSlider.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href=\"./css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href=\"css/index-css.css\" rel=\"stylesheet\">\n");
      out.write("    <script src=\"./js/nav.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"./js/news.js\" type=\"text/javascript\"></script>\n");
      out.write("    <script src=\"./js/main.js\" type=\"text/javascript\"></script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"goods-home\" onload=\"start()\">\n");
      out.write("    <div id=\"nav\">\n");
      out.write("        <p id=\"username\">\n");
      out.write("            ");
      out.print(session.getAttribute("userID"));
      out.write("\n");
      out.write("        </p>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"row\">\n");
      out.write("        <div class=\"jSlider col-md-6 col-md-offset-3\" id=\"slider1\" data-loop=\"true\">\n");
      out.write("            <div>\n");
      out.write("                <img src=\"images/photo1.jpg\" alt=\"sample photo\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <img src=\"images/photo2.jpg\" alt=\"sample photo\">\n");
      out.write("                <div class=\"sub-content-sample\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <img src=\"images/photo3.jpg\" alt=\"sample photo\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <img src=\"images/photo4.jpg\" alt=\"sample photo\">\n");
      out.write("            </div>\n");
      out.write("            <div>\n");
      out.write("                <img src=\"images/photo5.jpg\" alt=\"sample photo\">\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
      out.write("        <section class=\"content-wrap col-md-12 col-md-offset-0\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <main class=\"col-md-6 col-md-offset-3\" id=\"main\">\n");
      out.write("                </main>\n");
      out.write("                <div class=\"advertising col-md-2\">\n");
      out.write("                    <aside class=\"col-md-12 sidebar\">\n");
      out.write("                        <div class=\"widget\">\n");
      out.write("                            <h4 class=\"title\">联系</h4>\n");
      out.write("                            <div class=\"content community\">\n");
      out.write("                                <p>QQ:497304787</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"widget\">\n");
      out.write("                            <h4 class=\"title\">广告招商</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"widget\">\n");
      out.write("                            <h4 class=\"title\">热门</h4>\n");
      out.write("                            <div class=\"content tag-cloud\">\n");
      out.write("                                <a href=\"#\">鸡煲</a>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </aside>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("    </div>\n");
      out.write("    <!--login Modal -->\n");
      out.write("    <div class=\"modal fade\" id=\"login-Modal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"login-model-lbl\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <div class=\"modal-header\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                    </button>\n");
      out.write("                    <h4 class=\"modal-title\" id=\"login-model-lbl\">登录</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-body\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-8\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <form method=\"post\" action=\"userLoginServlet\" class=\"form-horizontal\" role=\"form\" id=\"login\">\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-3 text-center \">\n");
      out.write("                                            <label for=\"inputUesrName\" class=\"control-label\">账号</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"userName\" name=\"userName\" maxlength=\"20\" autofocus=\"\" placeholder=\"请输入账号\" autocomplete=\"on\" />\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-3 text-center\">\n");
      out.write("                                            <label for=\"inputPassword\" class=\"control-label\">密码</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-8\">\n");
      out.write("                                            <input type=\"password\" class=\"form-control\" id=\"password\" name=\"password\" maxlength=\"20\" placeholder=\"请输入密码\" autocomplete=\"on\" />\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12\">\n");
      out.write("                                        <div class=\"col-md-3\">\n");
      out.write("                                            <label for=\"Code\" class=\"control-label\">验证码</label>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-5\">\n");
      out.write("                                            <input type=\"text\" class=\"form-control\" id=\"inputCode\" name=\"inputCode\" maxlength=\"20\" placeholder=\"请输入验证码\" maxlength=\"4\" />\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-2\">\n");
      out.write("                                            <input type=\"button\" class=\"btn\" id=\"code\" onclick=\"createCode()\">\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"form-group col-md-12 text-center\">\n");
      out.write("                                        <a href=\"./register.jsp\">未注册，进入注册页面</a>\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-4\">\n");
      out.write("                            <img src=\"src/Logo.png\" class=\"img-responsive\" alt=\"LOGO\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"modal-footer center-block\">\n");
      out.write("                            <input type=\"button\" id=\"btn\" class=\"btn btn-success col-md-4 col-md-offset-2\" name=\"loginsubmit\" value=\"登录\" onclick=\"login()\"> <input type=\"button\" id=\"btn-cancl\" class=\"btn btn-default col-md-4\" value=\"取消\" data-dismiss=\"modal\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <!--information show in Modal-->\n");
      out.write("    <div id=\"modal-info\" class=\"modal fade\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"modallabel\">\n");
      out.write("        <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("            <div class=\"panel panel-primary\">\n");
      out.write("                <div class=\"panel-heading\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <h4 class=\"modal-title\" id=\"modallabel\">标题</h4>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"panel-body\">\n");
      out.write("                    <h1 class=\"text-center\">标题</h1>\n");
      out.write("                    <p class=\"h3 text-center\">作者：<small>时间</small></p>\n");
      out.write("                    <hr>\n");
      out.write("                    <p class=\"text-center\">紧张的一调考试结束了，当知道成绩时，我激动坏了。学习成绩并不是很好的我，这次一调考试居然冲进了班级前十，超越了成绩一直在我前面的一些同学。前十并不是那么容易就能进的，是通过不懈的努力而得来的。月考前一周，我与爸妈约定，这次考试一定要有所进步。在复习阶段，我找到了适合我自己的学习法宝。我把老师在课堂上讲的重要知识点用一个本子记录下来，下课与同学分析错题，并不断找老师加强基础知识的巩固。初三了，你必须要高效地、用心地去完成课下老师布置的作业。初三学习环境与之前也大不一样，每个同学都争先恐后的去找自己薄弱科目的老师进行辅导，老师总是会悉心的给我们一一解答。这样的一个月下来，我的成绩有了突飞猛进的进步。成绩的提高让我更有信心去面对最后的中考。　我们要把每一次的考试当作中考去认真对待，尽自己最大的努力去争取每一分。每一节课要认真去听讲，做好笔记，下课后巩固课堂所学知识，解决自己困惑的知识点。一定要相信自己能够成功！让我们一起备战中考，向自己的目标前进，不畏惧，不放弃，加油！绳上的世界作文 有趣的吹鸡毛比赛作文伟大的文化传承作文有趣的吹鸡毛比赛作文</p>\n");
      out.write("                    <footer>阅读次数：<span class=\"badge\">123456.0</span></footer>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"modal-footer\">\n");
      out.write("                    <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">取消</button>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-primary\">阅读完成</button>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
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
