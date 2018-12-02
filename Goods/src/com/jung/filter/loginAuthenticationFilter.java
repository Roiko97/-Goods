package com.jung.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �����û���¼����֤�����û���δ��¼ʱ���޷�����ҳ�����ز�����
 * @author jung
 *
 */
@WebFilter("/loginAuthenticationFilter")
public class loginAuthenticationFilter implements Filter {
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request_temp, ServletResponse response_temp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request =(HttpServletRequest)request_temp;
		HttpServletResponse response = (HttpServletResponse)response_temp;
		String userID = (String)request.getSession().getAttribute("userID");
		if(userID==null)
		{
			//������û�û�н��е�¼���������ֹ�������ҳ��
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}else {
			//�����Ѿ���¼�ɹ������������ء�
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
