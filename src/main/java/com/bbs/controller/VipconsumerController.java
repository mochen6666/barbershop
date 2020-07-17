package com.bbs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.VipconsumerService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("vip")
public class VipconsumerController {

	/*@Autowired
	private VipconsumerService vipconsumerService;

	public VipconsumerService getVipconsumerService() {
		return vipconsumerService;
	}

	public void setVipconsumerService(VipconsumerService vipconsumerService) {
		this.vipconsumerService = vipconsumerService;
	}*/
	
	/*@RequestMapping("/memcha")
	public String list(@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="3")Integer pageSize,HttpServletRequest request,Model model){
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		Vipconsumer vipconsumer = new Vipconsumer();
		vipconsumer.setVipid(staff.getStaid());
		
		PageInfo<Vipconsumer> pageInfo = vipconsumerService.search(vipconsumer, pageNum, pageSize);
		
		List<Vipconsumer> vipList = pageInfo.getList();
		
		model.addAttribute("vipList",vipList);
		
		model.addAttribute("pageCount",pageInfo.getPages());
		
		return "staff/memcha";
	}*/
	
}
