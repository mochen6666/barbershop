package com.bbs.pojo;

import java.util.Date;

public class Service {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service.serId
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    private Integer serid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service.serNum
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    private String sernum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service.serName
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    private String sername;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service.serprice
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    private Integer serprice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service.jobid
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    private Integer jobid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column service.serCreatetime
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    private Date sercreatetime;

    private String vipjobname;
    
    public String getVipjobname() {
		return vipjobname;
	}

	public void setVipjobname(String vipjobname) {
		this.vipjobname = vipjobname;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service.serId
     *
     * @return the value of service.serId
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public Integer getSerid() {
        return serid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service.serId
     *
     * @param serid the value for service.serId
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public void setSerid(Integer serid) {
        this.serid = serid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service.serNum
     *
     * @return the value of service.serNum
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public String getSernum() {
        return sernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service.serNum
     *
     * @param sernum the value for service.serNum
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public void setSernum(String sernum) {
        this.sernum = sernum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service.serName
     *
     * @return the value of service.serName
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public String getSername() {
        return sername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service.serName
     *
     * @param sername the value for service.serName
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public void setSername(String sername) {
        this.sername = sername;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service.serprice
     *
     * @return the value of service.serprice
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public Integer getSerprice() {
        return serprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service.serprice
     *
     * @param serprice the value for service.serprice
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public void setSerprice(Integer serprice) {
        this.serprice = serprice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service.jobid
     *
     * @return the value of service.jobid
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public Integer getJobid() {
        return jobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service.jobid
     *
     * @param jobid the value for service.jobid
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column service.serCreatetime
     *
     * @return the value of service.serCreatetime
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public Date getSercreatetime() {
        return sercreatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column service.serCreatetime
     *
     * @param sercreatetime the value for service.serCreatetime
     *
     * @mbggenerated Thu Jul 09 14:43:49 CST 2020
     */
    public void setSercreatetime(Date sercreatetime) {
        this.sercreatetime = sercreatetime;
    }
}