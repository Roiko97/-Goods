/**
 * 
 */
package com.ljl.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.User;
import com.jung.entity.*;
import com.jung.sql.UserDAO;
/**
 * @author DELL
 *
 */
@WebServlet("/getUserTableServlet")
public class getUserTableServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAO();
			
		//获取商家招聘信息
		List<Send> list = new ArrayList<Send>();
		list = userDAO.getUser();
		
		//获取具体招聘信息
		List<Table> table = new ArrayList<Table>();
		//Integer count = Integer.parseInt(request.getParameter("Count"));
		Table userInfo = new Table();
		userInfo.setRange(3);
		table = userDAO.getUserInformation(userInfo);
		
		//获取该条信息应聘的学生
		List<Send> user = new ArrayList<Send>();
		user = userDAO.getUser();
		Send []send = new Send[user.size()]; 
		for(int i =0;i<user.size();i++) {
			send[i] =user.get(i);
		}	
		List<Table> users = new ArrayList<Table>();		
		for(int i =0;i<user.size();i++)
		{
			users = userDAO.getStudent(send[i]);
			send[i].setStudents(users);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userInformation", table);
		jsonObject.put("information", list);
		jsonObject.put("context", send);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

