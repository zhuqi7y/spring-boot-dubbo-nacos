package com.youzi.modules.sys.vo;

import java.time.LocalDateTime;

/**
 * @Description: 登录用户显示层
 * @author: zhuqi
 * @date: 2020年07月22日 14:44
 */
public class SysLoginVo {
    private String userName;
    private String phone;
    private LocalDateTime lastLoginTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
