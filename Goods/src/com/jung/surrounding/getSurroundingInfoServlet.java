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
 *  ��ȡ�ܱ�ģ���µ���Ϣ
 * @author jung
 *
 */
@WebServlet("/getSurroundingInfoServlet")
public class getSurroundingInfoServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ȼ�ȡ�ܱ߾�����Ϣ
		UserDAO userDAO = new UserDAO();
		List<Attractions> list = new ArrayList<Attractions>();
		list = userDAO.getAttraction();
		
		//��ȡ�ܱ���ʳ��Ϣ
		List<Merchant>mer = new ArrayList<Merchant>();
		mer = userDAO.getMerchant();
		Merchant []merchant = new Merchant[mer.size()]; 
		//��ʼ���̻�����
		for(int i =0;i<mer.size();i++) {
			merchant[i] =mer.get(i);
		}	
		List<Food>food = new ArrayList<Food>();		
		for(int i =0;i<mer.size();i++)
		{
			food = userDAO.getFood(merchant[i]);
			merchant[i].setFood(food);
		}
		//��merchan������Ϣװ�����
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
