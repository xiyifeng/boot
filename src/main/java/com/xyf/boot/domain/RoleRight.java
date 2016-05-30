package com.xyf.boot.domain;

import com.xyf.boot.domain.base.PageBase;

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