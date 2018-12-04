package com.jung.communicate;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.ajax.insertOperating;
import com.jung.entity.Reply;
import com.jung.sql.UserDAO;

/**
 * Servlet implementation class ReplyServlet
 */
@WebServlet("/ReplyServlet")
public class ReplyServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int target = Integer.parseInt(request.getParameter("target"));
		String nickname = request.getSession().getAttribute("userID").toString();
		//String nickname = request.getParameter("nickname");
		String releasetime = request.getParameter("releasetime"); 
		String pagecontect = request.getParameter("pagecontect"); //»Ø¸´ÄÚÈÝ
		Reply  reply = new Reply(target,nickname,releasetime,pagecontect);
		UserDAO userDao =new UserDAO();
		insertOperating in = insertOperating.getInstance();
		JSONObject jsonObject = in.doInsert(reply);
   		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
