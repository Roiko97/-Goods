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
 *    接收用户修改信息
 * @author jung
 *
 */
@WebServlet("/userReviseServlet")
public class userReviseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username = request.getParameter("userName");// 通过Session会话 也可以得到该信息
		String username = (String)request.getSession().getAttribute("userID");
		String userpass = request.getParameter("password");
		String phone = request.getParameter("phone");
		String nickname =request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		Integer age = Integer.parseInt(request.getParameter("age"));
		UserDAO userDao = new UserDAO();
		//进行修改信息的二次检验
		if(nickname =="")
			nickname = null;
		if(phone =="")
			phone =null;
		if(email =="")
			email =null;
		User user = new User(nickname,phone,email);
		System.out.println(user);
		User userIsTrue = userDao.verificationInfo(user);
		if(userIsTrue ==null)//代表验证通过
		{
			user = new User();
			user.setUsername(username);
			if(userpass !="")
				user.setUserpass(userpass);
			if(phone !="")
				user.setPhone(phone);
			if(nickname!="")
				user.setNickname(nickname);
			if(email!="")
				user.setEmail(email);
			if(age !=0)
				user.setAge(age);
			if(gender !="")
				user.setGender(gender);
			System.out.println(user);
			Integer isTrue = userDao.userRevice(user);
			if(isTrue == 0) {
				// 修改失败
				System.out.println("修改失败");
				JSONObject jsonObject;
	        	// 返回true 代表数据库中未找到相关信息 即没有重复信息
	        	jsonObject = new JSONObject("{result:false}");			
	        	System.out.println(jsonObject.toString());
	        	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
				//此处在进行跳转
			}else {
				//修改成功
				//此处在进行跳转
				System.out.println("修改成功");
                JSONObject jsonObject;
        		jsonObject = new JSONObject("{result:true}");			
        		System.out.println(jsonObject.toString());
        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
			}
		}else {  //验证失败，数据库内存在相同的信息
			System.out.println("验证失败");
			JSONObject jsonObject;
        	// 返回true 代表数据库中未找到相关信息 即没有重复信息
        	jsonObject = new JSONObject("{result:false}");			
        	System.out.println(jsonObject.toString());
        	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
