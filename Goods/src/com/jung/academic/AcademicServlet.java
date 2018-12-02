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

import com.jung.entity.Academic;
import com.jung.sql.UserDAO;

@WebServlet("/AcademicServlet")
public class AcademicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		int types = Integer.parseInt(request.getParameter("types"));
		UserDAO userDAO = new UserDAO();
		List<Academic> list = new ArrayList<Academic>();
		list = userDAO.getAcademic(types);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("academicList", list);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
