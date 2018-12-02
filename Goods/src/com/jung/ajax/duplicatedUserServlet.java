package com.jung.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.User;
import com.jung.sql.UserDAO;

/**
 * 用来接收Ajax发来的验证消息
 * @author jung
 *
 */
@WebServlet("/duplicatedUserServlet")
public class duplicatedUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取手机号码
		String phone = request.getParameter("phone");
		//获取用户名称
		String userName = request.getParameter("userName");
		// 获取用户密码
		String nickname = request.getParameter("name");
		//获取邮箱
		String email = request.getParameter("email");
		//进行对象的初始化
		User user = new User();
		if(phone !=null)
			user.setPhone(phone);
		if(userName!=null)
			user.setUsername(userName);
		if(nickname !=null)
			user.setNickname(nickname);
		if(email !=null)
			user.setEmail(email);
		UserDAO userDao = new UserDAO();
		
		//回传给Ajax
		JSONObject jsonObject;
		// 返回true 代表数据库中未找到相关信息 即没有重复信息
		if(userDao.userLogin(user) == null) {
			jsonObject = new JSONObject("{result:true}");			
		}else {
			jsonObject = new JSONObject("{result:false}");			
		}
		System.out.println(jsonObject.toString());
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
