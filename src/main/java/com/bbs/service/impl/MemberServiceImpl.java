package com.bbs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbs.mapper.MemberMapper;
import com.bbs.pojo.Member;
import com.bbs.service.MemberService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;

	public MemberMapper getMemberMapper() {
		return memberMapper;
	}

	public void setMemberMapper(MemberMapper memberMapper) {
		this.memberMapper = memberMapper;
	}

	@Override
	public PageInfo<Member> fingById(Member member, Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<Member> data = memberMapper.findById(member);
		
		PageInfo<Member> pageInfo = new PageInfo<Member>(data);
		
		return pageInfo;
	}

	@Override
	public Member login(String memcode, String mempassword) {
		Member member = new Member();
		member.setMemcode(memcode);
		member.setMempassword(mempassword);
		return memberMapper.login(member);
	}

	@Override
	public Member selectByPrimaryKey(Integer memid) {
		// TODO Auto-generated method stub
		return memberMapper.selectByPrimaryKey(memid);
	}

	@Override
	public int updateByPrimaryKeySelective(Member member) {
		// TODO Auto-generated method stub
		return memberMapper.updateByPrimaryKeySelective(member);
	}
	
	
	
}
