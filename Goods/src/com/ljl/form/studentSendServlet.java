package com.ljl.form;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;

import com.jung.entity.Table;
import com.jung.entity.User;
import com.jung.sql.UserDAO;

public class studentSendServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Map<String, String[]> map = request.getParameterMap();
        Table user = new Table();
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        UserDAO userdao = new UserDAO();
        Integer userIsTrue = userdao.StudentSend(user);
        JSONObject jsonObject;
        if(userIsTrue == 1) //������μ���ͨ��
        {        
			//�˴��ڽ�����ת
	        System.out.println("�ύ�ɹ�");
	        //�˴�flag = 1 ��ʱû�о������
        	jsonObject = new JSONObject("{result:true}");			
        	System.out.println(jsonObject.toString());   
        }else {  //�ύʧ��
        	System.out.println("�ύʧ��");
        	jsonObject = new JSONObject("{result:false}");	
        }
    	response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));     
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}