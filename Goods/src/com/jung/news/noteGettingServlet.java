package com.jung.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.Note;
import com.jung.sql.UserDAO;

/**
 * Servlet implementation class noteGettingServlet
 */
@WebServlet("/noteGettingServlet")
public class noteGettingServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Note note = new Note();
		Integer count = Integer.parseInt(request.getParameter("Count"));
		System.out.println(count);
		//此处需要增强逻辑性
		note.setRange(count-3);
		note.setRangeto(count);
		System.out.println(note);
		UserDAO userDao = new UserDAO();
		List<Note> list = userDao.getDetailNote(note);
		System.out.println(list);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("context", list);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
