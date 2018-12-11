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

import com.jung.entity.Send;
import com.jung.entity.StudentSend;
import com.jung.entity.Table;
import com.jung.entity.User;
import com.jung.sql.UserDAO;

/**
 * Servlet implementation class Choosemyself
 */
@WebServlet("/Choosemyself")
public class ChoosemyselfServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nickname = request.getSession().getAttribute("userID").toString();
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setNickname(nickname);
		List<Send> list_u = new ArrayList<Send>();
		List<Table> list_s = new ArrayList<Table>();
		JSONObject jsonObject = new JSONObject();
		if(userDAO.userLogin(user).getJurisdiction() == 3) {//代表商家查看
			Send table = new Send();
			table.setLinkman(nickname);
			list_u = userDAO.queryUS(table);
			jsonObject.put("querySelfResult", list_u);
		}
		else if(userDAO.userLogin(user).getJurisdiction() == 1) { //代表学生查看
			Send com = new Send();
			com.setLinkman(nickname);
			list_s = userDAO.querySS(com);
			jsonObject.put("querySelfResult",list_s);
		}else {
			jsonObject.put("querySelfResult","error");
		}
		System.out.println(jsonObject);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
