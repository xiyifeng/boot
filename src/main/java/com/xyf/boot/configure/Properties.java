package com.xyf.boot.configure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "fmt")
public class Properties {
	/**
	 * 报文存放路径
	 */
	private String basePath;
	/**
	 * 请求报文路径
	 */
	private String requestPath;
	/**
	 * 响应报文路径
	 */
	private String responsePath;
	/**
	 * 新核心响应报文路径
	 */
	private String newResponsePath;
	/**
	 * 报文差异路径
	 */
	private String diffPath;
	/**
	 * uuid生成
	 */
	private String uuidSplit;

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	public String getRequestPath() {
		return requestPath;
	}

	public void setRequestPath(String requestPath) {
		this.requestPath = requestPath;
	}

	public String getResponsePath() {
		return responsePath;
	}

	public void setResponsePath(String responsePath) {
		this.responsePath = responsePath;
	}

	public String getNewResponsePath() {
		return newResponsePath;
	}

	public void setNewResponsePath(String newResponsePath) {
		this.newResponsePath = newResponsePath;
	}

	public String getDiffPath() {
		return diffPath;
	}

	public void setDiffPath(String diffPath) {
		this.diffPath = diffPath;
	}

	public String getUuidSplit() {
		return uuidSplit;
	}

	public void setUuidSplit(String uuidSplit) {
		this.uuidSplit = uuidSplit;
	}

	@Override
	public String toString() {
		return "Properties [basePath=" + basePath + ", requestPath="
				+ requestPath + ", responsePath=" + responsePath
				+ ", newResponsePath=" + newResponsePath + ", diffPath="
				+ diffPath + ", uuidSplit=" + uuidSplit + "]";
	}

	
}
