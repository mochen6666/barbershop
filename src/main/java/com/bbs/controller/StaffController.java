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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.bbs.pojo.Member;
import com.bbs.pojo.Service;
import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.MemberService;
import com.bbs.service.StaffService;
import com.bbs.service.VipconsumerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private VipconsumerService vipconsumerService;

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private StaffService staffService;

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

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
	public String memcha(Member member,@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="6")Integer pageSize,HttpServletRequest request,Model model
			,@RequestParam(required=false)String vipname,@RequestParam(required=false)String vipstatus){
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		Vipconsumer vipconsumer = new Vipconsumer();
		vipconsumer.setVipid(staff.getStaid());
		vipconsumer.setVipname(vipname);
		vipconsumer.setVipstatus("1");
		
		PageInfo<Vipconsumer> pageInfo = vipconsumerService.search(vipconsumer, pageNum, pageSize);
		
		List<Vipconsumer> vipList = pageInfo.getList();
		
		PageInfo<Member> pageInfos = memberService.fingBy(member, pageNum, pageSize); 
		
		List<Member> listMem = pageInfos.getList();
		
		model.addAttribute("listMem",listMem);
		
		model.addAttribute("vipList",vipList);
		
		model.addAttribute("pageCount",pageInfo.getPages());
		
		return "staff/memcha";
	
	}
	
	@RequestMapping("/new")
	public String news(@ModelAttribute("member")Member member){
		return "staff/new";
	}
	
	@RequestMapping("/save")
	public String save(Member member,HttpServletRequest request,MultipartFile file){
		
		String newFileName = "";
		
		String savePath = "";
		
		if (file != null && !file.isEmpty()) {
			
			String targetFolder = request.getServletContext().getRealPath("/uploads");
			
			newFileName = String.valueOf(System.currentTimeMillis());
			
			String extName = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length -1];
			
			newFileName = newFileName + "." + extName;
			
			savePath = targetFolder + File.separator + newFileName;
			
			try {
				file.transferTo(new File(savePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if (!newFileName.equals("") && !savePath.equals("")) {
			member.setMemheadpath(newFileName);
		}
		int balance=member.getMembalance();
		if( balance>0 && balance<200 ){
			balance = member.getMembalance();
		}else if(balance>=200&&balance<400){
			balance =member.getMembalance()+100;
		}else if(balance>=400&&balance<1000){
			balance =member.getMembalance()+288;
		}else if(balance>=1000){
			balance =member.getMembalance()+600;
		}
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		member.setMemcreatestaid(staff.getStaid());
		
		member.setMemstatus(1);
		
		member.setMemcreatetime(new Date());
		member.setMembalance(balance);
		
		memberService.save(member);
		
		return "redirect:/staff/memcha";
	}
	
	@RequestMapping("/modify_form")
	public String modifyForm(@ModelAttribute("staff")Staff staff,Model model,int staid){
		
		staff = staffService.all(staid);
		
		model.addAttribute("staff",staff);
		
		return "staff/modify";
	}
	
	@RequestMapping("/modify")
	public String modify(Staff staff,HttpServletRequest request,MultipartFile file){
		
		String newFileName = "";
		
		String savePath = "";
		
		if (file != null && !file.isEmpty()) {
			
			String targetFolder = request.getServletContext().getRealPath("/uploads");
			
			newFileName = String.valueOf(System.currentTimeMillis());
			
			String extName = file.getOriginalFilename().split("\\.")[file.getOriginalFilename().split("\\.").length -1];
			
			newFileName = newFileName + "." + extName;
			
			savePath = targetFolder + File.separator + newFileName;
			
			try {
				file.transferTo(new File(savePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if (!newFileName.equals("") && !savePath.equals("")) {
			staff.setStaheadpath(newFileName);
		}
		
		
		staff.setStamodifydate(new Date());
		
		staffService.modify(staff);
		
		return "redirect:/staff/memcha";
	}
	
	@RequestMapping("/sta")
	@ResponseBody
	public List<Service> sta(){
		return staffService.sta();
	}
	
}
