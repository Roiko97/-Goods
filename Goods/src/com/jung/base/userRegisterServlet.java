package com.jung.base;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.User;
import com.jung.sql.UserDAO;

/**
 * Servlet implementation class userRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	String username = request.getParameter("userName");
	        String password = request.getParameter("password");
	        String phone = request.getParameter("phone");
	        String name = request.getParameter("name");
	        User user = new User(username,password,name,phone);
	        UserDAO userDAO = new UserDAO();
	        //�����û���Ϣ�Ķ��μ���
	        User userIsTrue = userDAO.verificationInfo(user);
	        if(userIsTrue ==null) //������μ���ͨ��
	        {
	        	Integer isTrue = userDAO.userRegister(user);
		        if(isTrue == 1) {
					//�˴��ڽ�����ת
		        	System.out.println("ע��ɹ�");
		        	//�˴�flag = 1 ��ʱû�о������
	                JSONObject jsonObject;
	        		jsonObject = new JSONObject("{result:true}");			
	        		System.out.println(jsonObject.toString());
	        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
		        }else {
					//�˴��ڽ�����ת
		        	System.out.println("ע��ʧ��");
		        	JSONObject jsonObject;
		        	// ����true �������ݿ���δ�ҵ������Ϣ ��û���ظ���Ϣ
		        	jsonObject = new JSONObject("{result:false}");			
		        	System.out.println(jsonObject.toString());
		        	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
		        }
	        }else {  //���μ���ʧ��
	        	System.out.println("���μ���ʧ��");
	        }
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
