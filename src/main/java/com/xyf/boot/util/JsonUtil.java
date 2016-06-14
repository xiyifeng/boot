package com.xyf.boot.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.xyf.boot.domain.base.JsonResult;
import com.xyf.boot.domain.base.ResultMessage;

public class JsonUtil {

	public static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	/**
	 * JOSN表数据结构
	 * 
	 * @param total
	 *            总记录数
	 * @param data
	 *            数据
	 * @return
	 */
	public static JsonResult genJsonResultModel(int total, List<?> data) {
		JsonResult jsonResult = new JsonResult();
		jsonResult.setTotal(total);
		jsonResult.setRows(data);
		return jsonResult;
	}

	/**
	 * 表单验证错误
	 * 
	 * @param bindingResult
	 *            验证错误集
	 * @return 返回结果
	 */
	public static ResultMessage genResultMessage(BindingResult bindingResult) {
		List<ObjectError> ers = bindingResult.getAllErrors();
		StringBuffer sb = new StringBuffer();
		for (ObjectError oe : ers) {
			sb.append(oe.getDefaultMessage() + "; ");
		}

		ResultMessage rm = new ResultMessage();
		rm.setStatus(ResultMessage.FAIL);
		rm.setMessage(sb.toString());

		logger.info("表单验证: " + sb.toString());
		return rm;
	}

}
