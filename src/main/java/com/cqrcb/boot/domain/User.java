/**
* 
* User.java
* Copyright(c) 2015-2020 
* All Rights reserved. 
* -----------------------------------
* 2016-05-30creadted 
* @Auther xiyifeng
*/
package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class User extends PageBase {
    /**
     * 用户代码
     */
    private String user_code;

    /**
     * 用户名称
     */
    private String user_name;

    /**
     * 密码
     */
    private String password;

    /**
     * 职位
     */
    private String position;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 移动号码
     */
    private String mobil_phone;

    /**
     * 状�?(1-正常 2-锁定 3-失效)
     */
    private String status;

    /**
     * 语言
     */
    private String lang;

    /**
     * 主题
     */
    private String theme;

    /**
     * 登陆错误连续失败次数
     */
    private Integer error_login_times;

    /**
     * 备注
     */
    private String remark;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobil_phone() {
        return mobil_phone;
    }

    public void setMobil_phone(String mobil_phone) {
        this.mobil_phone = mobil_phone == null ? null : mobil_phone.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang == null ? null : lang.trim();
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Integer getError_login_times() {
        return error_login_times;
    }

    public void setError_login_times(Integer error_login_times) {
        this.error_login_times = error_login_times;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}