package com.xyf.boot.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xyf.boot.configure.Properties;
import com.xyf.boot.dao.Dao;
import com.xyf.boot.domain.FmtCode;
import com.xyf.boot.domain.info.FmtDetail;
import com.xyf.boot.service.FmtCodeService;
import com.xyf.boot.util.FileUtils;

@Service("fmtCodeService")
public class FmtCodeServiceImpl implements FmtCodeService {

	private static final Logger logger = LoggerFactory.getLogger(FmtCodeServiceImpl.class);
	
	@Autowired
	private Dao<FmtCode> dao;

	@Autowired
	private Properties properties;

	@Override
	public FmtCode save(FmtCode message) {
		return null;
	}

	@Override
	public FmtCode findFmtCode(String uuid) {
		FmtCode fc = new FmtCode();
		fc.setUuid(uuid);
		return (FmtCode) dao.selectOne(fc);
	}

	@Override
	public void deleteFmtCode(String uuid) {

	}

	@Override
	public void passFmtCode(String uuid) {

	}

	@Override
	public int selectTotalSize(FmtCode fmtCode) {
		return dao.selectTotalSize(fmtCode);
	}

	@Override
	public List<FmtCode> selectEverPage(FmtCode fmtCode) {
		return dao.selectEverPage(FmtCode.class.getName() + ".selectEverPage",
				fmtCode);
	}

	@Override
	public FmtDetail findFmtMessageByUuid(String uuid) {
		logger.info("配置参数："+properties);
		FmtCode fmtCode = findFmtCode(uuid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String dateString = sdf.format(new Date(Long.valueOf(fmtCode
				.getRequestTime())));
		return getPath(fmtCode, dateString);
	}

	private FmtDetail getPath(FmtCode fmtCode, String dateString) {
		FmtDetail fd = new FmtDetail();
		fd.setUuid(fmtCode.getUuid());
		
		String uuidPath = getStringByUuid(fmtCode.getUuid()); 
		// 原响应报文
		StringBuilder sb = new StringBuilder();
		sb.append(properties.getBasePath() + File.separator + dateString
				+ File.separator + properties.getResponsePath()
				+ uuidPath+File.separator+fmtCode.getUuid());
		fd.setResponseMsg(FileUtils.fileContent(sb.toString()));
		
		// 新响应报文
		sb = new StringBuilder();
		sb.append(properties.getBasePath() + File.separator + dateString
				+ File.separator + properties.getNewResponsePath()
				+ uuidPath+File.separator+fmtCode.getUuid());
		fd.setNewResponseMsg(FileUtils.fileContent(sb.toString()));
		
		// 差异性报文
		sb = new StringBuilder();
		sb.append(properties.getBasePath() + File.separator + dateString
				+ File.separator + properties.getDiffPath()
				+ uuidPath+File.separator+fmtCode.getUuid());
		fd.setCompResult(FileUtils.fileContent(sb.toString()));

		return fd;
	}

	private String getStringByUuid(String uuid) {
		StringBuilder sb = new StringBuilder();
		String spl = properties.getUuidSplit();
		String[] str = spl.split(",");
		int startLength = 0;
		for (String s : str) {
			if (s == null || s.trim().length() == 0) {
				continue;
			}
			int len = Integer.valueOf(s);
			sb.append(File.separator);
			sb.append(uuid.substring(startLength, startLength+len));
			startLength += len;
		}
		return sb.toString();
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public static void main(String[] args) {
		FmtCodeServiceImpl sn = new FmtCodeServiceImpl();
		Properties properties = new Properties();
		properties.setUuidSplit("2,3");
		sn.setProperties(properties);
		System.out.println(sn.getStringByUuid("123456789"));
		System.out.println(new Date().getTime());
	}
}
