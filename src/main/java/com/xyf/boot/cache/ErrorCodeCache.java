package com.xyf.boot.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 状态码缓存
 * 
 * @author xiyifeng
 * @date 2016年6月16日
 */
public class ErrorCodeCache implements Serializable {

	private static final long serialVersionUID = 1816387648723493L;

	private static final Logger logger = LoggerFactory
			.getLogger(ErrorCodeCache.class);

	public static Properties errorCode = new Properties();

	public static void loadErrorCache() throws IOException {
		File file = new File(ErrorCodeCache.class.getResource("/").getPath()
				+ File.separator + "conf" + File.separator + "server"
				+ File.separator + "errorCode.properties");
		InputStream is = new FileInputStream(file);
		errorCode.load(is);
		logger.info("加载错误码为: \n {}", errorCode);
	}

}
