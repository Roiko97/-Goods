package com.jung.base;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.User;
import com.jung.sql.UserDAO;

import java.io.IOException;

/**
 * 用户登录Servlet
 * @author jung
 *
 */
@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //用户登录 进行username的二次校验
        User user = new User();
        user.setUsername(username);
        UserDAO userDAO = new UserDAO();
        User isTrue = userDAO.userLogin(user);
        if(isTrue !=null) // 代表数据库中存在该信息
        {
        	//进行用户的登录操作
        	user = new User(username,password);
            userDAO = new UserDAO();
            User booleanUser = userDAO.userLogin(user);
            if(booleanUser!=null){
                request.getSession().setAttribute("userID", username);
                System.out.println("登录成功"); 

                JSONObject jsonObject;
        		jsonObject = new JSONObject("{result:true}");			
        		System.out.println(jsonObject.toString());
        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
                
            }else{
            	//进行跳转
                System.out.println("登录失败"); 
                
                JSONObject jsonObject;
        		// 返回true 代表数据库中未找到相关信息 即没有重复信息
        		jsonObject = new JSONObject("{result:false}");			
        		System.out.println(jsonObject.toString());
        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
        		
        		 
            }
        }else { //二次验证 失败，数据库中存在该信息
        	System.out.println("系统二次验证失败，数据库中存在该信息");
        }
    }
}
