package com.bbs.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bbs.pojo.Member;


public class MemberInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		
		Member staff = (Member) session.getAttribute("MEMBER");
		
		if (staff != null) {
			return true;
		}
		
		throw new RuntimeException("用户未登录请重新登录");
	}
	
}
