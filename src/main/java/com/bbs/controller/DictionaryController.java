package com.bbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbs.pojo.Dictionary;
import com.bbs.pojo.Service;
import com.bbs.pojo.Staff;
import com.bbs.service.DictionaryService;
import com.bbs.service.ServiceService;
import com.bbs.service.StaffService;

@Controller
@RequestMapping("/data")
public class DictionaryController {

	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private StaffService staffService;
	
	
	
	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public ServiceService getServiceService() {
		return serviceService;
	}

	public void setServiceService(ServiceService serviceService) {
		this.serviceService = serviceService;
	}

	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	@RequestMapping("/status")
	@ResponseBody
	public List<Dictionary> status(){
		return dictionaryService.listDictionary();
	}
	@RequestMapping("/sername")
	@ResponseBody
	public List<Service> sername(){
		return serviceService.serName();
	}
	@RequestMapping("/staname")
	@ResponseBody
	public List<Staff> staname(){
		return staffService.staname();
	}
	
}
