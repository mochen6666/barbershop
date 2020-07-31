package com.bbs.controller;


import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.StaffService;

@Controller
public class StaffLoginController {

	@Autowired
	private StaffService staffService;
	
	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	@RequestMapping("/staff_login_form")
	public String staffLoginForm(){
		return "staff/login";
	}
	
	@RequestMapping("/staff_login")
	public String staffLogin(String stacode,String stapassword,HttpServletRequest request){
		
		if (stacode != null && !stacode.trim().equals("") && stapassword != null && !stapassword.trim().equals("")) {
			
			Staff staff = staffService.login(stacode, stapassword);
			
			if (staff != null) {
				HttpSession session = request.getSession();
				
				session.setAttribute("STAFF", staff);
				
				return "redirect:/staff/main";
			}
		}
		
		return "redirect:/staff_login_form";
	}
	
	@RequestMapping("/register")
	public String register(String stacode,String stapassword,String staname,String staphone,int stasex,String staaddress,Model model){
		
		if (stacode != null && !stacode.trim().equals("")
				&& stapassword != null && !stapassword.trim().equals("")
				&& staname != null && !staname.trim().equals("")
				&& staphone != null && !staphone.trim().equals("")
				&& stasex > 0
				&& staaddress != null && !staaddress.trim().equals("")) {
			
			Staff staff = staffService.login(stacode, stapassword);
			
			if (staff == null) {
				Staff newStaff = new Staff();
				newStaff.setStacode(stacode);
				newStaff.setStapassword(stapassword);
				newStaff.setStaname(staname);
				newStaff.setStaphone(staphone);
				newStaff.setStasex(stasex);
				newStaff.setStaaddress(staaddress);
				//注册是死值
				newStaff.setStajob(3);
				newStaff.setStastatus(1);
				
				newStaff.setStacreatetime(new Date());
				
				model.addAttribute("message","职员注册成功");
				
				staffService.register(newStaff);
				
				return "staff/login";
			}
			
		}
		
		throw new RuntimeException("职员注册失败");
	}
	
}
