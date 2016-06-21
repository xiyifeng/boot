package com.xyf.boot.shiro;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyf.boot.domain.User;
import com.xyf.boot.service.UserService;
import com.xyf.boot.util.Constants;

/**
 * 权限控制
 * 
 * @author xiyifeng
 * @date 2016年5月30日
 */
@Component
public class MyShiro extends AuthorizingRealm {

	private static final Logger logger = LoggerFactory.getLogger(MyShiro.class);

	@Autowired
	private UserService userService;

	/**
	 * 授权操作，决定那些角色可以使用那些资源
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		// 获取登录时输入的用户名
		String userCode = (String) principalCollection.fromRealm(getName())
				.iterator().next();

		logger.info("授权操作{}", userCode);
		// 到数据库查是否有此对象
		User user = userService.findByName(userCode);
		if (user != null) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户权限添加
			List<String> rights = userService.getUserPermission(userCode);
			if (rights == null) {
				return null;
			}
			info.addStringPermissions(rights);
			return info;
		}
		return null;
	}

	/**
	 * 认证操作，判断一个请求是否被允许进入系统
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		logger.info("认证操作{}====", token);

		User user = userService.findByName(token.getUsername());
		if (user != null) {
			setSession(Constants.KEY_USER, user);
			return new SimpleAuthenticationInfo(user.getUsercode(),
					user.getPassword(), getName());
		}
		return null;
	}

	/**
	 * 将一些数据放到ShiroSession中,以便于其它地方使用
	 * 
	 * @see 比如Controller,使用时直接用HttpSession.getAttribute(key)就可以取到
	 */
	public void setSession(Object key, Object value) {
		Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			Session session = currentUser.getSession();
			logger.info("Session默认会话时间为[" + session.getTimeout() + "]毫秒");
			if (null != session) {
				session.setAttribute(key, value);
			}
		}
	}

	@PostConstruct
	public void initCredentialsMatcher() {
		setCredentialsMatcher(new PasswordCredentialsMatcher());
	}

}
