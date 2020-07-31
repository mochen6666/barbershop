package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.ServiceMapper;

import com.bbs.pojo.Vipconsumer;
import com.bbs.service.ServiceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public PageInfo<com.bbs.pojo.Service> list(com.bbs.pojo.Service service, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		List<com.bbs.pojo.Service> data = serviceMapper.list(service);
		
		PageInfo<com.bbs.pojo.Service> pageInfo = new PageInfo<com.bbs.pojo.Service>(data);
		return pageInfo;
	}

	@Override
	public int modify(com.bbs.pojo.Service service) {
		return serviceMapper.updateByPrimaryKeySelective(service);
	}

	@Override
	public com.bbs.pojo.Service all(Integer serid) {
		return serviceMapper.selectByPrimaryKey(serid);
	}

	@Override
	public int save(com.bbs.pojo.Service service) {
		return serviceMapper.insertSelective(service);
	}

	@Override
	public int del(Integer serid) {
		return serviceMapper.deleteByPrimaryKey(serid);
	}




	@Override
	public List<com.bbs.pojo.Service> serName() {
		// TODO Auto-generated method stub
		return serviceMapper.serName();
	}


}
