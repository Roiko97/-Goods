package com.jung.communicate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.ajax.insertOperating;
import com.jung.entity.LostAndFound;
import com.jung.listener.sessionAttributeListener;

/**
 * Servlet implementation class WritingLostAndFoundServlet
 */
@WebServlet("/WritingLostAndFoundServlet")
public class WritingLostAndFoundServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String nickname = request.getSession().getAttribute("userID").toString();
		//String nickname = request.getParameter("nickname");
		String releasetime = request.getParameter("releasetime");
		String pagecontect= request.getParameter("pagecontect");
		LostAndFound laf = new LostAndFound(title,nickname,releasetime,pagecontect,0);
		insertOperating in = insertOperating.getInstance();
		JSONObject jsonObject = in.doInsert(laf);
   		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
