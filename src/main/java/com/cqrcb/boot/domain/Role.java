package com.cqrcb.boot.domain;

/**
 * 用户角色
 * @author xiyifeng
 * @date 2016-5-27
 */
public class Role {
	// 角色代码
	private int roleCode;
	// 角色名称
	private String roleName;
	// 角色说明
	private String remark;

	public int getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(int roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
