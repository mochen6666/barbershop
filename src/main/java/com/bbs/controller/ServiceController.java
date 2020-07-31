package com.bbs.controller;

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

import com.bbs.pojo.Service;
import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.ServiceService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/service")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;
	
	public ServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}

	@RequestMapping("/service_list")
	public String serviceList(HttpServletRequest request,Model model,@RequestParam(required=false,defaultValue="1")Integer pageNum, @RequestParam(required=false,defaultValue="6")Integer pageSize){
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		Service service = new Service();
		service.setJobid(staff.getStaid());
		
		PageInfo<Service> pageInfo = serviceService.list(service, pageNum, pageSize);
		
		List<Service> serList = pageInfo.getList();
		
		model.addAttribute("serList", serList);
		
		model.addAttribute("pageCount",pageInfo.getPages());
		
		return "staff/servicecha";
	}
	
	@RequestMapping("modify_form")
	public String modifyForm(@ModelAttribute("service") Service service,Model model,int serid){
		
		service = serviceService.all(serid);
		
		model.addAttribute("service",service);
		
		return "staff/servicemodify";
	}
	
	@RequestMapping("/modify")
	public String modify(Service service){
		
		serviceService.modify(service);
		
		service.setSercreatetime(new Date());
		
		return "redirect:/service/service_list";
	}
	
	@RequestMapping("/servicecha")
	public String serviceCha(){
		return "staff/servicecha";
	}
	
	@RequestMapping("/save_form")
	public String saveForm(@ModelAttribute("service")Service service){
		return "staff/save";
	}
	
	@RequestMapping("/save")
	public String save(Service service,HttpServletRequest request){
		
		HttpSession session = request.getSession();
		
		Staff staff = (Staff) session.getAttribute("STAFF");
		
		service.setJobid(staff.getStaid());
		
		service.setSercreatetime(new Date());
		
		serviceService.save(service);
		
		return "redirect:/service/service_list";
	}
	
	@RequestMapping("/del")
	public String del(int serid){
		serviceService.del(serid);
		return "redirect:/service/service_list";
	}
	
}
