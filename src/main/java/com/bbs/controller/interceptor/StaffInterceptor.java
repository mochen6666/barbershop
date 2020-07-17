package com.bbs.controller.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bbs.pojo.Staff;

public class StaffInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		if (staff != null) {
			return true;
		}
		
		throw new RuntimeException("登录未授权");
	}

	
	
	
}
