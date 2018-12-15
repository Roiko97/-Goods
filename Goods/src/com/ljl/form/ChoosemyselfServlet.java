package com.ljl.form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.jung.entity.Send;
import com.jung.entity.StudentSend;
import com.jung.entity.Table;
import com.jung.entity.User;
import com.jung.sql.UserDAO;

/**
 * Servlet implementation class Choosemyself
 */
@WebServlet("/ChoosemyselfServlet")
public class ChoosemyselfServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getSession().getAttribute("userID").toString();
		UserDAO userDAO = new UserDAO();
		User user = new User();
		user.setUsername(username);
		List<Send> list_u = new ArrayList<Send>();
		List<StudentSend> StuList = new ArrayList<>();
		List<List<Send>> list = new ArrayList<>();

		JSONObject jsonObject = new JSONObject();
		if(userDAO.userLogin(user).getJurisdiction() == 3) {//�����̼Ҳ鿴
			Send table = new Send();
			table.setLinkman(username);
			list_u = userDAO.queryUS(table);		
			System.out.println(list_u);
			jsonObject.put("jusristion",userDAO.userLogin(user).getJurisdiction());
			jsonObject.put("querySelfResult", list_u);
		}
		/** 	
		 * ֪���ǳ� ͨ���ǳ� -> �鿴ѧ��Ȩ�� -> ͨ���ǳ�ȥ���ҷ���ӦƸ��StudentSend)
		 * -> ��Ҫ����һ����Ӧ�ļ�ְ���� ��ͨ��StudentSend�е�target�ֶ� ��Ӧ Send(form)���id��
		 */
		else if(userDAO.userLogin(user).getJurisdiction() == 1) { //����ѧ���鿴
			jsonObject.put("jusristion",userDAO.userLogin(user).getJurisdiction());
			UserDAO useDao = new UserDAO();
			StuList = useDao.getStudentSendById(username);
			for(int i =0;i<StuList.size();i++) {
				list.add(useDao.getSendByTarget(StuList.get(i).getTarget()));	
			}
			for(int i=0;i<list.size();i++) {
				for(int j =0;j<list.get(i).size();j++) {	
						list.get(i).get(j).setStudents(StuList);
				}
			}
			jsonObject.put("querySelfResult",list);
		}else {
			jsonObject.put("querySelfResult","error");
		}
		System.out.println(jsonObject);
		
		response.getOutputStream().write(jsonObject.toString().getBytes("utf-8"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}