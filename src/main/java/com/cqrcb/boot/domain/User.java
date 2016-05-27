package com.cqrcb.boot.domain;

/**
 * 用户
 * 
 * @author xiyifeng
 * @date 2016-5-27
 */
public class User {
	// 用户编码
	private String userCode;
	// 用户名称
	private String userName;
	// 用户密码
	private String password;
	// 职位
	private String position;
	// 邮箱
	private String email;
	// 移动电话
	private String mobilPhone;
	// 状态
	private String status;
	// 备注
	private String remark;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilPhone() {
		return mobilPhone;
	}

	public void setMobilPhone(String mobilPhone) {
		this.mobilPhone = mobilPhone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
