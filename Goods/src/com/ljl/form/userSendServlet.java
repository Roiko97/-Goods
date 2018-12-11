package com.ljl.form;

import java.io.IOException;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;

import com.jung.ajax.insertOperating;
import com.jung.entity.Communication;
import com.jung.entity.Send;
import com.jung.entity.Table;
import com.jung.entity.User;
import com.jung.sql.UserDAO;
@WebServlet("/userSendServlet")
public class userSendServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> map = request.getParameterMap();
        Send user = new Send();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		insertOperating in = insertOperating.getInstance();
		JSONObject jsonObject = in.doInsert(user);
    	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));    
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
