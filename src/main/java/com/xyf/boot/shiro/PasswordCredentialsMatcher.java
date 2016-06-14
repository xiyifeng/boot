package com.xyf.boot.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PasswordCredentialsMatcher
 * 
 * @author xiyifeng
 * @date 2016年6月14日
 */
public class PasswordCredentialsMatcher extends SimpleCredentialsMatcher {

	private static final Logger logger = LoggerFactory
			.getLogger(PasswordCredentialsMatcher.class);

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		boolean res = super.doCredentialsMatch(token, info);
		logger.info("密码检验[" + new String((char[]) token.getCredentials())
				+ "],[" + info.getCredentials() + "],[" + res + "]");
		return res;
	}

}
