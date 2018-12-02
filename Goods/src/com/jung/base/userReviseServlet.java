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
 *    �����û��޸���Ϣ
 * @author jung
 *
 */
@WebServlet("/userReviseServlet")
public class userReviseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String username = request.getParameter("userName");// ͨ��Session�Ự Ҳ���Եõ�����Ϣ
		String username = (String)request.getSession().getAttribute("userID");
		String userpass = request.getParameter("password");
		String phone = request.getParameter("phone");
		String nickname =request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		Integer age = Integer.parseInt(request.getParameter("age"));
		UserDAO userDao = new UserDAO();
		//�����޸���Ϣ�Ķ��μ���
		if(nickname =="")
			nickname = null;
		if(phone =="")
			phone =null;
		if(email =="")
			email =null;
		User user = new User(nickname,phone,email);
		System.out.println(user);
		User userIsTrue = userDao.verificationInfo(user);
		if(userIsTrue ==null)//������֤ͨ��
		{
			user = new User();
			user.setUsername(username);
			if(userpass !="")
				user.setUserpass(userpass);
			if(phone !="")
				user.setPhone(phone);
			if(nickname!="")
				user.setNickname(nickname);
			if(email!="")
				user.setEmail(email);
			if(age !=0)
				user.setAge(age);
			if(gender !="")
				user.setGender(gender);
			System.out.println(user);
			Integer isTrue = userDao.userRevice(user);
			if(isTrue == 0) {
				// �޸�ʧ��
				System.out.println("�޸�ʧ��");
				JSONObject jsonObject;
	        	// ����true �������ݿ���δ�ҵ������Ϣ ��û���ظ���Ϣ
	        	jsonObject = new JSONObject("{result:false}");			
	        	System.out.println(jsonObject.toString());
	        	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
				//�˴��ڽ�����ת
			}else {
				//�޸ĳɹ�
				//�˴��ڽ�����ת
				System.out.println("�޸ĳɹ�");
                JSONObject jsonObject;
        		jsonObject = new JSONObject("{result:true}");			
        		System.out.println(jsonObject.toString());
        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
			}
		}else {  //��֤ʧ�ܣ����ݿ��ڴ�����ͬ����Ϣ
			System.out.println("��֤ʧ��");
			JSONObject jsonObject;
        	// ����true �������ݿ���δ�ҵ������Ϣ ��û���ظ���Ϣ
        	jsonObject = new JSONObject("{result:false}");			
        	System.out.println(jsonObject.toString());
        	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
