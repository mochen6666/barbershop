package com.bbs.service;

import com.bbs.pojo.Consumption;
import com.github.pagehelper.PageInfo;

public interface ConsumptionService {

	//分页查询查询非会员消费信息
  	PageInfo<Consumption> search(Consumption consumption,Integer pageNum,Integer pageSize);
	
	
}
