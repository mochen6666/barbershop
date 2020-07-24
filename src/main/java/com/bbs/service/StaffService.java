package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;

public interface StaffService {

    Staff login(String stacode,String stapassword);
    
    //查询职工名字
    List<Staff> staname();
}
