package com.jung.communicate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.Communication;
import com.jung.entity.LostAndFound;
import com.jung.entity.User;
import com.jung.sql.UserDAO;

/**
 * Servlet implementation class QueryMyselfServlet
 */
@WebServlet("/QueryMyselfServlet")
public class QueryMyselfServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String choose = request.getParameter("choose");
		String nickname = request.getSession().getAttribute("userID").toString();
		UserDAO userDAO = new UserDAO();
		List<LostAndFound> list_l = new ArrayList<LostAndFound>();
		List<Communication>list_c = new ArrayList<Communication>();
		System.out.println(choose);
		JSONObject jsonObject = new JSONObject();
		if(choose.equals("laf")) { //代表失物招领
			LostAndFound laf = new LostAndFound();
			laf.setNickname(nickname);
			list_l = userDAO.queryLaf(laf);
			jsonObject.put("queryResult", list_l);
		}else if(choose.equals("com")) { //代表交流
			Communication com = new Communication();
			com.setNickname(nickname);
			list_c = userDAO.queryCom(com);
			jsonObject.put("queryResult",list_c);
		}else {
			jsonObject.put("queryResult","error");
		}
		System.out.println(jsonObject);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
