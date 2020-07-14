package com.bbs.service;

import com.bbs.pojo.Staff;

public interface StaffService {

	 //业务层会员登录
    Staff login(String stacode,String stapassword);
	
}
