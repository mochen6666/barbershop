package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.ConsumptionMapper;
import com.bbs.pojo.Consumption;
import com.bbs.service.ConsumptionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ConsumptionServiceImpl implements ConsumptionService{

	@Autowired
	private ConsumptionMapper consumptionMapper;
	
	public ConsumptionMapper getConsumptionMapper() {
		return consumptionMapper;
	}

	public void setConsumptionMapper(ConsumptionMapper consumptionMapper) {
		this.consumptionMapper = consumptionMapper;
	}

	@Override
	public PageInfo<Consumption> search(Consumption consumption, Integer pageNum, Integer pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		
		List<Consumption> data = consumptionMapper.findBy(consumption);
		
		PageInfo<Consumption> pageInfo = new PageInfo<Consumption>(data);
		
		return pageInfo;
	}
}
