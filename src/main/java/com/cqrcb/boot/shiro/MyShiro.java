package com.cqrcb.boot.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cqrcb.boot.domain.Role;
import com.cqrcb.boot.domain.User;
import com.cqrcb.boot.service.UserService;

/**
 * 权限控制
 * 
 * @author xiyifeng
 * @date 2016年5月30日
 */
@Component
public class MyShiro extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		// 获取登录时输入的用户名
		String loginName = (String) principalCollection.fromRealm(getName()).iterator().next();
		// 到数据库查是否有此对象
		User user = userService.findByName(loginName);
		if (user != null) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			info.setRoles(user.getRolesName());
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
			List<Role> roleList = user.getRoleList();
			for (Role role : roleList) {
				info.addStringPermissions(role.getPermissionsName());
			}
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken arg0) throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

}
