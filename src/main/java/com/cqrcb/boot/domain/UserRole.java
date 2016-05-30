package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class UserRole extends PageBase {
    private String userCode;

    private String roleCode;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }
}