package com.jung.academic;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.json.JSONObject;

import com.jung.entity.Academic;
import com.jung.entity.Application;
import com.jung.entity.Communication;
import com.jung.entity.DependAcademic;
import com.jung.sql.UserDAO;

@WebServlet("/AcademicServlet")
public class AcademicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		// flag = 0  -> ����
		// flag = 1  -> ����
		// flag = 2  -> �鿴
		//System.out.println(request.getParameter("flag"));
		
		int userChoose =  Integer.parseInt(request.getParameter("flag"));
		String nickname = request.getSession().getAttribute("userID").toString();
		// 1 ���� ������Ϣ 2���������Ϣ 3��������Ϣ
		//int type = Integer.parseInt(request.getParameter("types"));
		UserDAO userDAO = new UserDAO();
		JSONObject jsonObject = new JSONObject();
		if(userChoose == 0) {
			Map<String,String[]> map = request.getParameterMap();
			Academic academic = new Academic();
			try {
				BeanUtils.populate(academic, map);
				academic.setAnnouncer(nickname);
				int isTrue = userDAO.insertAcademic(academic);
				if(isTrue!=0) {
					System.out.println("ִ�е�����");
					int id = userDAO.getAcademicId(academic);
					System.out.println(id);
					List<DependAcademic> list =  academic.getDependAcademic();
					for(int i=0;i<list.size();i++) {
						list.get(i).setMark(id);
					}
					isTrue = userDAO.insertDependAcademic(list);
					if(isTrue !=0) { //����ɹ�		   	
					   	jsonObject = new JSONObject("{result:success}");	
					}else {
						jsonObject = new JSONObject("{result:fail}");	
					}
				}else {
					jsonObject = new JSONObject("{result:fail}");	
				}
			} catch (Exception e) {
				e.printStackTrace();
				jsonObject = new JSONObject("{result:fail}");	
			}
		}else if(userChoose ==1 ) {
			Map<String,String[]> map = request.getParameterMap();
			List<Application> list = new ArrayList<>();
			//Application application = new Application();
			try {
				BeanUtils.populate(list, map);
				int isTrue =  userDAO.insertApplication(list);
				if(isTrue !=0) { //����ɹ�
					jsonObject = new JSONObject("{result:success}");	
				}else {
					jsonObject = new JSONObject("{result:fail}");	
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				jsonObject = new JSONObject("{result:fail}");	
			}
		}else if(userChoose ==2) { //�鿴���˷�������
			List<Application> list = new ArrayList<>();			
			int id = Integer.parseInt(request.getParameter("mark"));
			Application application = new Application(id,nickname);
			list = userDAO.selectApplication(application);
			if(list.size()!=0) {
				jsonObject.put("list", list);
			}else {
				jsonObject = new JSONObject("{result:fail}");	
			}
		}
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
