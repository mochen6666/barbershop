package com.bbs.mapper;

import java.util.List;

import com.bbs.pojo.Member;
import com.bbs.pojo.Vipconsumer;

public interface MemberMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int deleteByPrimaryKey(Integer memid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int insert(Member record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int insertSelective(Member record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    Member selectByPrimaryKey(Integer memid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int updateByPrimaryKey(Member record);
    
    //查询会员信息
    List<Member> findBy(Member member);
    

    //根据会员id查询会员信息
    List<Member> findById(Member member);
    
    Member  login(Member member);
    
}