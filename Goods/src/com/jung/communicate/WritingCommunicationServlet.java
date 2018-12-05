package com.jung.communicate;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;

import com.jung.ajax.insertOperating;
import com.jung.entity.Communication;
import com.jung.sql.UserDAO;

/**
 * 发布交流内容
 */
@WebServlet("/WritingCommunicationServlet")
public class WritingCommunicationServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String,String> hashMap = (HashMap)request.getParameterMap();
		Map<String, String[]> map = request.getParameterMap();
		Communication com = new Communication();
		System.out.println(map);
		//Set<Map.Entry<String, String[]>> set = map.entrySet();
		//Communication com = new Communication();
		try {
			BeanUtils.populate(com, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(com);
		insertOperating in = insertOperating.getInstance();
		JSONObject jsonObject = in.doInsert(com);
   		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}