package com.jung.ajax;

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
 * ��������Ajax��������֤��Ϣ
 * @author jung
 *
 */
@WebServlet("/duplicatedUserServlet")
public class duplicatedUserServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�ֻ�����
		String phone = request.getParameter("phone");
		//��ȡ�û�����
		String userName = request.getParameter("userName");
		// ��ȡ�û�����
		String nickname = request.getParameter("name");
		//��ȡ����
		String email = request.getParameter("email");
		//���ж���ĳ�ʼ��
		User user = new User();
		if(phone !=null)
			user.setPhone(phone);
		if(userName!=null)
			user.setUsername(userName);
		if(nickname !=null)
			user.setNickname(nickname);
		if(email !=null)
			user.setEmail(email);
		UserDAO userDao = new UserDAO();
		
		//�ش���Ajax
		JSONObject jsonObject;
		// ����true �������ݿ���δ�ҵ������Ϣ ��û���ظ���Ϣ
		if(userDao.userLogin(user) == null) {
			jsonObject = new JSONObject("{result:true}");			
		}else {
			jsonObject = new JSONObject("{result:false}");			
		}
		System.out.println(jsonObject.toString());
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
