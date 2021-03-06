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

import com.jung.entity.LostAndFound;
import com.jung.sql.UserDAO;

/**
 *  失物招领页面
 *  1——查找所有为解决的内容 并且以对象数组的形式进行返回
 * @author jung
 *
 */
@WebServlet("/LostAndFoundServlet")
public class LostAndFoundServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		List<LostAndFound> list = new ArrayList<LostAndFound>();
		list = userDAO.getLostAndFound();
		System.out.println(list);
		LostAndFound []lostAndFound = new LostAndFound[list.size()];
		for(int i =0;i<list.size();i++) {
			lostAndFound[i] = list.get(i);
		}
		
		JSONObject jsonObject = new JSONObject();
		//System.out.println(jsonObject);
		jsonObject.put("lostAndFound", lostAndFound);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
