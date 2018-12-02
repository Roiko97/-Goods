package com.jung.base;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jung.entity.User;
import com.jung.entity.*;
import com.jung.sql.UserDAO;

/**
 * Ȩ����֤ Servlet
 * @author LJL
 */
@WebServlet("/activateUseServlet")
public class activateUseServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String activate_type =request.getParameter("activate_type");
		Integer status = 1;
		Integer jurisdiction;
		String username= (String) request.getSession().getAttribute("userID");
		
		UserDAO userDAO = new UserDAO();
		String student_id = request.getParameter("student_id");
		String student_password = request.getParameter("student_password");
		
		String teacher_id = request.getParameter("teacher_id");
		String teacher_password = request.getParameter("teacher_password");

		String activation = request.getParameter("activation");	
		StringBuilder str = new StringBuilder(activation);
		   str.insert(4,"-");
		   str.insert(9, "-");
		   str.insert(14, "-");
	    activation = str.toString();
		if(activate_type.trim().equals("Activation_activate"))
		{
			Activation user = new Activation();
			user.setActivation(activation);
			System.out.println(user);
		    Activation isTrue = userDAO.userActivate(user);
		   
		    
			if(isTrue != null)//���ݿ���ڸü�����
			{				
				if(isTrue.getActivate_status() == 0) {//�ü�����δ����					
					isTrue.setActivate_status(status);															
					Integer True = userDAO.userStatus(isTrue);
							if(True == 0) {
								// ����ʧ��
								System.out.println("����ʧ��");
								//�˴��ڽ�����ת
							}else {															
									jurisdiction = 3;
									User user1 = new User();
									user1.setUsername(username);
									User booleanUser = userDAO.userLogin(user1);
									booleanUser.setJurisdiction(jurisdiction);
									userDAO.userRevice(booleanUser);
									//����ɹ�
									//�˴��ڽ�����ת
									System.out.println("����ɹ�");								
							}					
				}else {
					//�������Ѽ���
					//�˴��ڽ�����ת
					System.out.println("��������ʹ��");
				}
			}else {
				//���ݿⲻ���ڸü�����
				System.out.println("�ü����벻����");
				//�˴�������ת
			}
		}
		if(activate_type.trim().equals("Teacher_activate")){ 			
			Activation user = new Activation();
			user.setTeacher_id(teacher_id);
			user.setTeacher_password(teacher_password);
			Activation isTrue = userDAO.userTeacher(user);

			if(isTrue != null){//��ʦid.password��ȷ
				if(isTrue.getTeacher_activate_status()== 0)
				{//����״̬Ϊ0
					isTrue.setTeacher_activate_status(status);
					userDAO.userTeacherstatus(isTrue);
					if(isTrue.getTeacher_activate_status() == 0) {
						// ����ʧ��
						System.out.println("����ʧ��");
						//�˴��ڽ�����ת
					}else {						
							jurisdiction = 2;
							User user1 = new User();
							user1.setUsername(username);
							User booleanUser = userDAO.userLogin(user1);
							booleanUser.setJurisdiction(jurisdiction);						
							userDAO.userRevice(booleanUser);		
							//����ɹ�
							//�˴��ڽ�����ת
							System.out.println("����ɹ�");					
					}
				}else {
					//���û��Ѽ���
					//�˴��ڽ�����ת
					System.out.println("�û��Ѽ���");
				}
			}else {
				//��ʦID/�����������
				//������ת
                System.out.println("ID/�����������"); 
			}
		}
		if(activate_type.trim().equals("Student_activate")){ 
			Activation user = new Activation();
			user.setStudent_id(student_id);
			user.setStudent_password(student_password);
			Activation isTrue = userDAO.userStudent(user);
			
			if(isTrue != null){//ѧ��id,password������ȷ				
				if(isTrue.getStudent_activate_status()== 0)
				{//����״̬Ϊ0
					isTrue.setStudent_activate_status(status);
					userDAO.userStudentstatus(isTrue);
					if(isTrue.getStudent_activate_status() == 0) {
						// ����ʧ��
						System.out.println("����ʧ��");
						//�˴��ڽ�����ת
					}else {						
							jurisdiction = 1;
							User user1 = new User();
							user1.setUsername(username);
							User booleanUser = userDAO.userLogin(user1);
							booleanUser.setJurisdiction(jurisdiction);						
							userDAO.userRevice(booleanUser);							
							//����ɹ�
							//�˴��ڽ�����ת
							System.out.println("����ɹ�");
										
					}
				}else {
					//���û��Ѽ���
					//�˴��ڽ�����ת
					System.out.println("�û��Ѽ���");
				}
			}else {
				//��ʦID/�����������
				//������ת
                System.out.println("ID/�����������"); 
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
