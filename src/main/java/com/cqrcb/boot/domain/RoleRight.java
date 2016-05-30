/**
* 
* RoleRight.java
* Copyright(c) 2015-2020 
* All Rights reserved. 
* -----------------------------------
* 2016-05-30creadted 
* @Auther xiyifeng
*/
package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class RoleRight extends PageBase {
    /**
     * 角色代码
     */
    private Integer role_code;

    /**
     * 权限ID
     */
    private Integer right_id;

    public Integer getRole_code() {
        return role_code;
    }

    public void setRole_code(Integer role_code) {
        this.role_code = role_code;
    }

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
    }
}