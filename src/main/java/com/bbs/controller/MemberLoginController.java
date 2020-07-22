package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.pojo.Member;
import com.bbs.service.MemberService;

@Controller
public class MemberLoginController {
		 @Autowired
		 private MemberService memberService;

		public MemberService getMemberService() {
			return memberService;
		}

		public void setMemberService(MemberService memberService) {
			this.memberService = memberService;
		}
		 @RequestMapping("/member_login_form")
		 public String memberLoginForm(){
			 return"member/login";
		 }
		 @RequestMapping("/member_login")
		 public String memberLogin(String  memcode,String mempassword,HttpServletRequest request){
			 if(memcode!=null &&!memcode.trim().equals("")&& mempassword!=null &&!mempassword.trim().equals("")){
				Member member= memberService.login(memcode, mempassword);
				HttpSession session=request.getSession();
				session.setAttribute("MEMBER", member);
				return "redirect:/member/main";
			 }
			 return "redirect:/member/login";
		 }
 
}
