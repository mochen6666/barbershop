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
	public PageInfo<Member> fingBy(Member member, Integer pageNum, Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		
		List<Member> data = memberMapper.findBy(member);
		
		PageInfo<Member> pageInfo = new PageInfo<Member>(data);
		
		return pageInfo;
	}

	@Override
	public int save(Member member) {
		return memberMapper.insertSelective(member);
	}
	
	
	
}
