package com.flexible.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: chendom
 * Date: 2018-10-12
 * Time: 21:46
 */
public class LoginLog {
    /**
     * 登陆日志id
     */
    private Integer loginLogId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * ip
     */
    private String ip;
    /**
     * 登陆日期
     */
    private Date loginDate;

    public LoginLog() {
    }

    public Integer getLoginLogId() {
        return loginLogId;
    }

    public void setLoginLogId(Integer loginLogId) {
        this.loginLogId = loginLogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }
}
