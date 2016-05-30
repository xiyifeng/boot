package com.cqrcb.boot.domain;

import com.cqrcb.boot.domain.page.PageBase;

public class RoleRight extends PageBase {
    private Integer roleCode;

    private Integer rightId;

    public Integer getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(Integer roleCode) {
        this.roleCode = roleCode;
    }

    public Integer getRightId() {
        return rightId;
    }

    public void setRightId(Integer rightId) {
        this.rightId = rightId;
    }
}