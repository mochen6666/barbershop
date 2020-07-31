package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Service;
import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;

public interface StaffService {

	//登录
    Staff login(String stacode,String stapassword);
    
    //修改职工信息
    int modify(Staff staff);
    
    //查看职员(上个修改职员)
    Staff all(Integer staid);
    
    List<Service> sta();
    
    //职员注册
    int register(Staff staff);
}
