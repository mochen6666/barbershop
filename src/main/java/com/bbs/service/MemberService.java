package com.bbs.service;


import com.bbs.pojo.Member;
import com.github.pagehelper.PageInfo;

public interface MemberService {

	//分页查询全部会员信息

	PageInfo<Member> fingBy(Member member,Integer pageNum,Integer pageSize);
	
	//增加会员
	int save(Member member);

	PageInfo<Member> fingById(Member member,Integer pageNum,Integer pageSize);
	//登录
	Member  login(String memcode,String mempassword);
	//根据id查会员
	 Member selectByPrimaryKey(Integer memid);
	//修改会员信息
	 int  updateByPrimaryKeySelective(Member member);

}
