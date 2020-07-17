package com.bbs.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.pojo.Member;
import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.MemberService;
import com.bbs.service.VipconsumerService;
import com.github.pagehelper.PageInfo;




@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private VipconsumerService vipconsumerService;

	@Autowired
	private MemberService memberService;

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public VipconsumerService getVipconsumerService() {
		return vipconsumerService;
	}

	public void setVipconsumerService(VipconsumerService vipconsumerService) {
		this.vipconsumerService = vipconsumerService;
	}
	
	@RequestMapping("/main")
	public String main(){
		return "staff/main";
	}

	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("STAFF") != null) {
			session.setAttribute("STAFF",null);
			session.invalidate();
		}
		
		return "redirect:/staff_login_form";
	}
	
	@RequestMapping("/memcha")
	public String memcha(Member member,@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="3")Integer pageSize,HttpServletRequest request,Model model
			,@RequestParam(required=false)String vipname,@RequestParam(required=false)String vipstatus){
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		Vipconsumer vipconsumer = new Vipconsumer();
		vipconsumer.setVipid(staff.getStaid());
		vipconsumer.setVipname(vipname);
		vipconsumer.setVipstatus(vipstatus);
		
		PageInfo<Vipconsumer> pageInfo = vipconsumerService.search(vipconsumer, pageNum, pageSize);
		
		List<Vipconsumer> vipList = pageInfo.getList();
		
		PageInfo<Member> pageInfos = memberService.fingById(member, pageNum, pageSize); 
		
		List<Member> ListMem = pageInfos.getList();
		
		model.addAttribute("ListMem",ListMem);
		
		model.addAttribute("vipList",vipList);
		
		model.addAttribute("pageCount",pageInfo.getPages());
		
		return "staff/memcha";
		
	}
	
	
	
	
	
}
