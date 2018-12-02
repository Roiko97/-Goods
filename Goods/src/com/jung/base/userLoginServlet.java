package com.jung.base;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.User;
import com.jung.sql.UserDAO;

import java.io.IOException;

/**
 * �û���¼Servlet
 * @author jung
 *
 */
@WebServlet("/userLoginServlet")
public class userLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("userName");
        String password = request.getParameter("password");
        
        //�û���¼ ����username�Ķ���У��
        User user = new User();
        user.setUsername(username);
        UserDAO userDAO = new UserDAO();
        User isTrue = userDAO.userLogin(user);
        if(isTrue !=null) // �������ݿ��д��ڸ���Ϣ
        {
        	//�����û��ĵ�¼����
        	user = new User(username,password);
            userDAO = new UserDAO();
            User booleanUser = userDAO.userLogin(user);
            if(booleanUser!=null){
                request.getSession().setAttribute("userID", username);
                System.out.println("��¼�ɹ�"); 

                JSONObject jsonObject;
        		jsonObject = new JSONObject("{result:true}");			
        		System.out.println(jsonObject.toString());
        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
                
            }else{
            	//������ת
                System.out.println("��¼ʧ��"); 
                
                JSONObject jsonObject;
        		// ����true �������ݿ���δ�ҵ������Ϣ ��û���ظ���Ϣ
        		jsonObject = new JSONObject("{result:false}");			
        		System.out.println(jsonObject.toString());
        		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
        		
        		 
            }
        }else { //������֤ ʧ�ܣ����ݿ��д��ڸ���Ϣ
        	System.out.println("ϵͳ������֤ʧ�ܣ����ݿ��д��ڸ���Ϣ");
        }
    }
}
