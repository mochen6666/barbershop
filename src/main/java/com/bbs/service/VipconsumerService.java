package com.bbs.service;

import com.bbs.pojo.Vipconsumer;
import com.github.pagehelper.PageInfo;

public interface VipconsumerService {

	
	//分页查询查询会员消费信息
	PageInfo<Vipconsumer> search(Vipconsumer vipconsumer,Integer pageNum,Integer pageSize);
	
	
	
}
