package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.ServiceMapper;
import com.bbs.service.ServiceService;

@Service
public class ServiceServiceImpl implements ServiceService{
	@Autowired
	private ServiceMapper serviceMapper;
	
	public ServiceMapper getServiceMapper() {
		return serviceMapper;
	}

	public void setServiceMapper(ServiceMapper serviceMapper) {
		this.serviceMapper = serviceMapper;
	}

	@Override
	public List<com.bbs.pojo.Service> serName() {
		// TODO Auto-generated method stub
		return serviceMapper.serName();
	}

}
