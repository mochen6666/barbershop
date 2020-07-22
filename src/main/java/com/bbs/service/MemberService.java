package com.bbs.service;


import com.bbs.pojo.Member;
import com.github.pagehelper.PageInfo;

public interface MemberService {

	//分页查询全部会员信息
	PageInfo<Member> fingBy(Member member,Integer pageNum,Integer pageSize);
	
	//增加会员
	int save(Member member);
}
