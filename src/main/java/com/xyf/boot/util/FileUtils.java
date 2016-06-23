package com.xyf.boot.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件相关处理
 * 
 * @author xiyifeng
 * @date 2016年6月23日
 */
public class FileUtils {

	private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);
	/**
	 * 获取文件内容
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文件内容
	 */
	public static String fileContent(String filePath) {
		logger.info("文件路径为："+filePath);
		File file = new File(filePath);
		BufferedReader br = null;

		StringBuilder sb = new StringBuilder();
		String str = null;
		try {
			br = new BufferedReader(new FileReader(file));
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getCause());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 获取文件内容（需解压缩)
	 * 
	 * @param filePath
	 *            文件路径
	 * @return 文件内容
	 */
	public static String fileContentUnPress(String filePath) {
		return fileContent(filePath);
	}

}
