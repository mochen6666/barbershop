package com.bbs.mapper;

import java.util.List;

import com.bbs.pojo.Service;

public interface ServiceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int deleteByPrimaryKey(Integer serid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int insert(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int insertSelective(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    Service selectByPrimaryKey(Integer serid);
    
    /*Service selectByPrimaryKey1(Integer serid);*/
    

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int updateByPrimaryKeySelective(Service record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table service
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    int updateByPrimaryKey(Service record);

    
    List<Service> list(Service service);
    
    

    List<Service> serName();

}