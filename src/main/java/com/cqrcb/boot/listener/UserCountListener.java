package com.cqrcb.boot.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserCountListener implements HttpSessionListener {

	private static final Logger logger = LoggerFactory
			.getLogger(UserCountListener.class);

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		logger.info("session create");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		logger.info("session Destroy");
	}
}
