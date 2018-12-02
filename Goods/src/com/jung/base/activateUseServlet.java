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
 * 权限验证 Servlet
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
		   
		    
			if(isTrue != null)//数据库存在该激活码
			{				
				if(isTrue.getActivate_status() == 0) {//该激活码未激活					
					isTrue.setActivate_status(status);															
					Integer True = userDAO.userStatus(isTrue);
							if(True == 0) {
								// 激活失败
								System.out.println("激活失败");
								//此处在进行跳转
							}else {															
									jurisdiction = 3;
									User user1 = new User();
									user1.setUsername(username);
									User booleanUser = userDAO.userLogin(user1);
									booleanUser.setJurisdiction(jurisdiction);
									userDAO.userRevice(booleanUser);
									//激活成功
									//此处在进行跳转
									System.out.println("激活成功");								
							}					
				}else {
					//激活码已激活
					//此处在进行跳转
					System.out.println("激活码已使用");
				}
			}else {
				//数据库不存在该激活码
				System.out.println("该激活码不存在");
				//此处进行跳转
			}
		}
		if(activate_type.trim().equals("Teacher_activate")){ 			
			Activation user = new Activation();
			user.setTeacher_id(teacher_id);
			user.setTeacher_password(teacher_password);
			Activation isTrue = userDAO.userTeacher(user);

			if(isTrue != null){//教师id.password正确
				if(isTrue.getTeacher_activate_status()== 0)
				{//激活状态为0
					isTrue.setTeacher_activate_status(status);
					userDAO.userTeacherstatus(isTrue);
					if(isTrue.getTeacher_activate_status() == 0) {
						// 激活失败
						System.out.println("激活失败");
						//此处在进行跳转
					}else {						
							jurisdiction = 2;
							User user1 = new User();
							user1.setUsername(username);
							User booleanUser = userDAO.userLogin(user1);
							booleanUser.setJurisdiction(jurisdiction);						
							userDAO.userRevice(booleanUser);		
							//激活成功
							//此处在进行跳转
							System.out.println("激活成功");					
					}
				}else {
					//该用户已激活
					//此处在进行跳转
					System.out.println("用户已激活");
				}
			}else {
				//教师ID/密码输入错误
				//进行跳转
                System.out.println("ID/密码输入错误"); 
			}
		}
		if(activate_type.trim().equals("Student_activate")){ 
			Activation user = new Activation();
			user.setStudent_id(student_id);
			user.setStudent_password(student_password);
			Activation isTrue = userDAO.userStudent(user);
			
			if(isTrue != null){//学生id,password输入正确				
				if(isTrue.getStudent_activate_status()== 0)
				{//激活状态为0
					isTrue.setStudent_activate_status(status);
					userDAO.userStudentstatus(isTrue);
					if(isTrue.getStudent_activate_status() == 0) {
						// 激活失败
						System.out.println("激活失败");
						//此处在进行跳转
					}else {						
							jurisdiction = 1;
							User user1 = new User();
							user1.setUsername(username);
							User booleanUser = userDAO.userLogin(user1);
							booleanUser.setJurisdiction(jurisdiction);						
							userDAO.userRevice(booleanUser);							
							//激活成功
							//此处在进行跳转
							System.out.println("激活成功");
										
					}
				}else {
					//该用户已激活
					//此处在进行跳转
					System.out.println("用户已激活");
				}
			}else {
				//教师ID/密码输入错误
				//进行跳转
                System.out.println("ID/密码输入错误"); 
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
