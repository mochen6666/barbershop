package com.bbs.service;

import java.util.List;

import com.bbs.pojo.Staff;
import com.bbs.pojo.Vipconsumer;

public interface StaffService {

    Staff login(String stacode,String stapassword);
    
    
}
