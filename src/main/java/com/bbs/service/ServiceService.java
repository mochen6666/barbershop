package com.bbs.service;


import com.bbs.pojo.Service;
import com.github.pagehelper.PageInfo;

public interface ServiceService {

	//分页查询服务
	PageInfo<Service> list(Service service,Integer pageNum,Integer pageSize);
	
	//修改服务
	int modify(Service service);
	
	//根据id查询服务
	Service all(Integer serid);
	
	//增加服务
	int save(Service service);
	
	//删除服务
	int del(Integer serid);
}
