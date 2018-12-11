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
		//List<Table> list = new ArrayList<Table>();
		//list = userDAO.getUser();
		//System.out.print(list);
		
		//获取具体招聘信息
		//Integer count = Integer.parseInt(request.getParameter("Count"));
		//List<Table> table = new ArrayList<Table>();
		//Table userInfo = new Table();
		//userInfo.setRange(count);
		//table = userDAO.getUserInformation();
		
		//获取该条信息应聘的学生
		List<Send> user = new ArrayList<Send>();
		List<StudentSend> studentsend = new ArrayList<StudentSend>();
		user = userDAO.getUser();
		Send []send = new Send[user.size()];
		for(int i =0;i<user.size();i++) {
			send[i] =user.get(i);
			studentsend = userDAO.getStudent(send[i]);
			send[i].setStudents(studentsend);
		}
		JSONObject jsonObject = new JSONObject();
		//jsonObject.put("userInformation", table);//兼职具体消息
		//jsonObject.put("information", list);//兼职简介
		jsonObject.put("context", send);//学生应聘消息
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

