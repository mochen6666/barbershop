package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.StaffMapper;
import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;
import com.bbs.service.StaffService;
import com.github.pagehelper.PageHelper;
@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	private StaffMapper staffMapper;
	
	public StaffMapper getStaffMapper() {
		return staffMapper;
	}

	public void setStaffMapper(StaffMapper staffMapper) {
		this.staffMapper = staffMapper;
	}

	@Override
	public Staff login(String stacode, String stapassword) {
		
		Staff staff = new Staff();
		staff.setStacode(stacode);
		staff.setStapassword(stapassword);
		return staffMapper.findBy(staff);
	}

	@Override
	public int modify(Staff staff) {
		return staffMapper.updateByPrimaryKeySelective(staff);
	}

	@Override
	public Staff all(Staff staff) {
		return staffMapper.findBy(staff);
	}


}
