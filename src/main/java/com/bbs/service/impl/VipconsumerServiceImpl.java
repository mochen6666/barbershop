package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.VipconsumerMapper;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.VipconsumerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class VipconsumerServiceImpl implements VipconsumerService{

	@Autowired
	private VipconsumerMapper VipconsumerMapper;
	
	public VipconsumerMapper getVipconsumerMapper() {
		return VipconsumerMapper;
	}

	public void setVipconsumerMapper(VipconsumerMapper vipconsumerMapper) {
		VipconsumerMapper = vipconsumerMapper;
	}

	@Override
	public PageInfo<Vipconsumer> search(Vipconsumer vipconsumer, Integer pageNum, Integer pageSize) {
			
		PageHelper.startPage(pageNum, pageSize);
		
		List<Vipconsumer> data = VipconsumerMapper.search(vipconsumer);
		
		PageInfo<Vipconsumer> pageInfo = new PageInfo<Vipconsumer>(data);
		
		return pageInfo;
	}

	@Override
	public List<Vipconsumer> cha(Vipconsumer vipconsumer) {
		// TODO Auto-generated method stub
		List<Vipconsumer> data = VipconsumerMapper.cha(vipconsumer);

		return data;
	}

	
	
}
