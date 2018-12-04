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
import com.jung.entity.Reply;
import com.jung.sql.UserDAO;
/**
 * ·µ»ØÏûÏ¢
 * @author jung
 *
 */
@WebServlet("/CommunicationServlet")
public class CommunicationServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO  userDAO = new UserDAO();
		List<Communication> comList = new ArrayList<Communication>();
		List<Reply> replyList = new ArrayList<Reply>();
		comList = userDAO.getCommunication();
		Communication [] communications = new Communication[comList.size()];
		for(int i =0;i<comList.size();i++) {
			communications[i] = comList.get(i);
			replyList = userDAO.getReply(communications[i]);
			communications[i].setReply(replyList);
		}
		for (Communication communication : communications) {
			System.out.println(communication);
		}
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("communication", communications);
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
