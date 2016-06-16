package com.xyf.boot.domain;

import javax.validation.constraints.NotNull;

import com.xyf.boot.domain.base.PageBase;

public class User extends PageBase {
	private static final long serialVersionUID = -1542612948724816135L;

	@NotNull(message = "用户号不能为空")
	private String usercode;

	@NotNull(message = "用户名不能为空")
	private String username;

	private String password;

	private String position;

	private String email;

	private String mobilPhone;

	@NotNull(message = "状态不能为空")
	private String status;

	private String lang;

	private String theme;

	private Integer errorLoginTimes;

	private String remark;

	public String getUsercode() {
		return usercode;
	}

	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getMobilPhone() {
		return mobilPhone;
	}

	public void setMobilPhone(String mobilPhone) {
		this.mobilPhone = mobilPhone == null ? null : mobilPhone.trim();
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

	public Integer getErrorLoginTimes() {
		return errorLoginTimes;
	}

	public void setErrorLoginTimes(Integer errorLoginTimes) {
		this.errorLoginTimes = errorLoginTimes;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	@Override
	public String toString() {
		return "User [usercode=" + usercode + ", username=" + username
				+ ", password=" + password + ", position=" + position
				+ ", email=" + email + ", mobilPhone=" + mobilPhone
				+ ", status=" + status + ", lang=" + lang + ", theme=" + theme
				+ ", errorLoginTimes=" + errorLoginTimes + ", remark=" + remark
				+ "]";
	}

}