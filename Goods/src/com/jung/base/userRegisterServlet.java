package com.jung.base;

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
 * Servlet implementation class userRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("userName");
	        String password = request.getParameter("password");
	        String phone = request.getParameter("phone");
	        String name = request.getParameter("name");
	        User user = new User(username,password,name,phone);
	        UserDAO userDAO = new UserDAO();
	        //进行用户信息的二次检验
	        User userIsTrue = userDAO.verificationInfo(user);
	        if(userIsTrue ==null) //代表二次检验通过
	        {
	        	Integer isTrue = userDAO.userRegister(user);
		        if(isTrue == 1) {
					//此处在进行跳转
		        	System.out.println("注册成功");
		        	//此处flag = 1 暂时没有具体操作
	                JSONObject jsonObject;
	        		jsonObject = new JSONObject("{result:true}");			
	        		System.out.println(jsonObject.toString());
	        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
		        }else {
					//此处在进行跳转
		        	System.out.println("注册失败");
		        	JSONObject jsonObject;
		        	// 返回true 代表数据库中未找到相关信息 即没有重复信息
		        	jsonObject = new JSONObject("{result:false}");			
		        	System.out.println(jsonObject.toString());
		        	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
		        }
	        }else {  //二次检验失败
	        	System.out.println("二次检验失败");
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
