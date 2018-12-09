package com.jung.academic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.Titleacademic;
import com.jung.sql.UserDAO;

/**
 * 获取所有信息
 */
@WebServlet("/GetAcademicInfoServlet")
public class GetAcademicInfoServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO  userDao = new UserDAO();
		List<Titleacademic> list = new ArrayList<>();
		list = userDao.getTitleAcademic();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("allAcademic", list);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
