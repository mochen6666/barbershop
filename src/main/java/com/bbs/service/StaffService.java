package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;

public interface StaffService {

	//登录
    Staff login(String stacode,String stapassword);
    
    //查看并修改职工信息
    int modify(Staff staff);
    
    //查看职员(上个修改职员)
    Staff all(Staff staff);
    
}
