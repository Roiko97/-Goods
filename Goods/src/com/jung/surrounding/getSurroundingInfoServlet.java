package com.jung.surrounding;
import com.jung.entity.Attractions;
import com.jung.entity.Food;
import com.jung.entity.Merchant;
import com.jung.sql.UserDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
/**
 *  获取周边模块下的信息
 * @author jung
 *
 */
@WebServlet("/getSurroundingInfoServlet")
public class getSurroundingInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//先获取周边景点信息
		UserDAO userDAO = new UserDAO();
		List<Attractions> list = new ArrayList<Attractions>();
		list = userDAO.getAttraction();
		
		//获取周边美食信息
		List<Merchant>mer = new ArrayList<Merchant>();
		mer = userDAO.getMerchant();
		Merchant []merchant = new Merchant[mer.size()]; 
		//初始化商户数组
		for(int i =0;i<mer.size();i++) {
			merchant[i] =mer.get(i);
		}	
		List<Food>food = new ArrayList<Food>();		
		for(int i =0;i<mer.size();i++)
		{
			food = userDAO.getFood(merchant[i]);
			merchant[i].setFood(food);
		}
		//将merchan数组信息装载完毕
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("attractions", list);
		jsonObject.put("merchant", merchant);
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
