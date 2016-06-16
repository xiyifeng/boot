package com.xyf.boot.auto;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import com.xyf.boot.cache.ErrorCodeCache;

/**
 * 错误码系统初始化
 * 
 * @author xiyifeng
 * @date 2016年6月16日
 */
@Component
public class CacheInit implements CommandLineRunner, Ordered {

	private static final Logger logger = LoggerFactory
			.getLogger(CacheInit.class);

	@Override
	public int getOrder() {
		return 0;
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			ErrorCodeCache.loadErrorCache();
			logger.debug("加载错误码成功");
		} catch (IOException e) {
			logger.error("加载错误码失败, {}", e.getCause());
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
	}

}
