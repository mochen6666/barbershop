package com.bbs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.pojo.Member;
import com.bbs.service.MemberService;
import com.github.pagehelper.PageInfo;

/*@Controller
@RequestMapping("/member")*/
public class MemberController {

/*	@Autowired
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/search")
	private String search(Member member,@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="3")Integer pageSize,Model model){
		
		
		
		return "staff/memcha";
	}*/
	
}
