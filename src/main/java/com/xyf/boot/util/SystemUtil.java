package com.xyf.boot.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.xyf.boot.domain.User;

/**
 * 获取相应参数
 * 
 * @author xiyifeng
 * @date 2016年6月14日
 */
public class SystemUtil {

	/**
	 * 获取当前用户的ID
	 * 
	 * @return 用户ID
	 */
	public static String currentUserCode() {
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getSession()
				.getAttribute(Constants.KEY_USER);
		if (user == null) {
			throw new RuntimeException("获取登陆用户信息失败!");
		}
		return user.getUsercode();
	}
}
