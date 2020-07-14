package com.bbs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bbs.pojo.Staff;
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
				
				return "/staff/main";
			}
			
		}
		
		return "redirect:/staff_login_form";
	}
	
}
