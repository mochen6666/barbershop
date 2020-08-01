package com.bbs.controller;


import java.io.File;
import java.io.IOException;

import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import com.bbs.pojo.Member;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.MemberService;

import com.bbs.service.VipconsumerService;



@Controller
@RequestMapping("/member")
public class MemberController {


	@Autowired
	private MemberService memberService;
	@Autowired
	private VipconsumerService vipconsumerService;
	

	public VipconsumerService getVipconsumerService() {
		return vipconsumerService;
	}

	public void setVipconsumerService(VipconsumerService vipconsumerService) {
		this.vipconsumerService = vipconsumerService;
	}

	public MemberService getMemberService() {
		return memberService;
	}

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}


	/*
	@RequestMapping("/search")
	private String search(Member member,@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="3")Integer pageSize,Model model){
			
		return "staff/memcha";
	}*/
	@RequestMapping("/main")
	public String main(){
		return "member/main";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		if (session.getAttribute("MEMBER") != null) {
			session.setAttribute("MEMBER",null);
			session.invalidate();
		}
		
		return "redirect:/member_login_form";
	}
	@RequestMapping("/modify_form")
	public String modifyForm(@ModelAttribute("member")Member member, Model  model,int memid){
		 member =memberService.selectByPrimaryKey(memid);
		model.addAttribute("member",member);
		return "member/update";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request ,MultipartFile file,Member member){
		//上传文件部分
		String newFileName="";
		String savePath="";
		if(file != null && !file.isEmpty()){
			String targetFolder=request.getServletContext().getRealPath("/uploads");
			
			newFileName=String.valueOf(System.currentTimeMillis());
			
			String extName=file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length-1];
			
			newFileName=newFileName+"."+extName;
			
		 savePath=targetFolder+File.separator+newFileName; 
			
			try {
				file.transferTo(new File(savePath));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if(!newFileName.equals("") && !savePath.equals("")){
			
			member.setMemheadpath(newFileName);
		}
		member.setMemmodifyby(member.getMemid());
		member.setMemcreatetime(new Date());
		memberService.updateByPrimaryKeySelective(member);
		
		return"member/main";
	}

	
	@RequestMapping("/cha")
	public String chaFormf(Model model,HttpServletRequest request,@RequestParam(required=false)String servicename,@RequestParam(required=false)Long vipjobid){
		HttpSession session=request.getSession();
		Member member=(Member) session.getAttribute("MEMBER");
		Vipconsumer vipconsumer= new Vipconsumer();
			vipconsumer.setVipnum(member.getMemid());	
			vipconsumer.setServicename(servicename);
			vipconsumer.setVipjobid(vipjobid);
			System.out.println(vipjobid);
			List<Vipconsumer>list=vipconsumerService.cha(vipconsumer);
			model.addAttribute("listvip", list);
			return"member/xiaofei";
	}
	@RequestMapping("/cz_form")
	public String czForm(@ModelAttribute("member")Member member, Model  model,int memid){
		 member =memberService.selectByPrimaryKey(memid);
		model.addAttribute("member",member);
		return "member/chongzhi";
	}
	@RequestMapping("/cz")
	public String modify(HttpServletRequest request ,Member member){
		HttpSession session=request.getSession();
		Member members=(Member) session.getAttribute("MEMBER");
		int x= members.getMembalance();
		int balance=member.getMembalance();
		if( balance>0 && balance<200 ){
			balance = member.getMembalance()+x;
		}else if(balance>=200&&balance<400){
			balance =member.getMembalance()+100+x;
		}else if(balance>=400&&balance<1000){
			balance =member.getMembalance()+288+x;
		}else if(balance>=1000){
			balance =member.getMembalance()+600+x;
		}
		member.setMembalance(balance);
		member.setMemmodifyby(member.getMemid());
		member.setMemcreatetime(new Date());
		memberService.updateByPrimaryKeySelective(member);
		
		return"member/main";
	}
}
