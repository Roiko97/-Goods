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
 * 进行用户登录的验证。当用户暂未登录时，无法进行页面的相关操作。
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
			//代表该用户没有进行登录操作，则禁止访问相关页面
			
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			
		}else {
			//代表已经登录成功。不进行拦截。
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
