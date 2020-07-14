package com.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.StaffMapper;
import com.bbs.pojo.Staff;
import com.bbs.service.StaffService;
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

}
