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
			
		//��ȡ�̼���Ƹ��Ϣ
		//List<Table> list = new ArrayList<Table>();
		//list = userDAO.getUser();
		//System.out.print(list);
		
		//��ȡ������Ƹ��Ϣ
		//Integer count = Integer.parseInt(request.getParameter("Count"));
		//List<Table> table = new ArrayList<Table>();
		//Table userInfo = new Table();
		//userInfo.setRange(count);
		//table = userDAO.getUserInformation();
		
		//��ȡ������ϢӦƸ��ѧ��
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
		//jsonObject.put("userInformation", table);//��ְ������Ϣ
		//jsonObject.put("information", list);//��ְ���
		jsonObject.put("context", send);//ѧ��ӦƸ��Ϣ
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

