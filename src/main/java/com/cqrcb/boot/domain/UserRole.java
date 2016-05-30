/**
* 
* UserRole.java
* Copyright(c) 2015-2020 
* All Rights reserved. 
* -----------------------------------
* 2016-05-30creadted 
* @Auther xiyifeng
*/
package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class UserRole extends PageBase {
    /**
     * 用户代码
     */
    private String user_code;

    /**
     * 角色代码
     */
    private String role_code;

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public String getRole_code() {
        return role_code;
    }

    public void setRole_code(String role_code) {
        this.role_code = role_code == null ? null : role_code.trim();
    }
}