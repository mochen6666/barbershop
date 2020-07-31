package com.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.pojo.Consumption;
import com.bbs.pojo.Member;
import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.ConsumptionService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("con")
public class ConsumptionController {

	@Autowired
	private ConsumptionService consumptionService;

	public ConsumptionService getConsumptionService() {
		return consumptionService;
	}

	public void setConsumptionService(ConsumptionService consumptionService) {
		this.consumptionService = consumptionService;
	}
	
	@RequestMapping("/nonmemcha")
	public String memcha(Consumption consumption,@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="6")Integer pageSize,HttpServletRequest request,Model model){
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		consumption.setConid(staff.getStaid());
		
		PageInfo<Consumption> pageInfo = consumptionService.search(consumption, pageNum, pageSize);
		
		List<Consumption> conList = pageInfo.getList();
		
		model.addAttribute("conList",conList);
		
		model.addAttribute("pageCount",pageInfo.getPages());
		
		return "staff/nonmemcha";
	
	}
}
