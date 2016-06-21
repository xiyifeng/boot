package com.xyf.boot.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.alibaba.fastjson.JSON;
import com.xyf.boot.cache.ErrorCodeCache;
import com.xyf.boot.domain.base.JsonResult;

public class JsonUtil {

	public static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

	/**
	 * 返回消息提示
	 * 
	 * @author xiyifeng
	 * @date 2016年6月16日
	 */
	static class ResultMessage implements Serializable {
		private static final long serialVersionUID = 3259486722003198580L;
		/**
		 * 标题
		 */
		private String title;
		/**
		 * 状态码(成功为"0000", 失败为其他4位数字)
		 */
		private String code;
		/**
		 * 消息
		 */
		private String message;

		public ResultMessage() {
			super();
		}

		public ResultMessage(String code, String message) {
			super();
			this.title = "信息";
			this.code = code;
			this.message = message;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

	}

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
	public static Serializable genResultMessage(BindingResult bindingResult) {
		List<ObjectError> ers = bindingResult.getAllErrors();
		StringBuffer sb = new StringBuffer();
		for (ObjectError oe : ers) {
			sb.append(oe.getDefaultMessage() + "; ");
		}

		ResultMessage rm = new ResultMessage();
		rm.setCode("9999");
		rm.setMessage(sb.toString());

		logger.info("表单验证: " + sb.toString());
		return rm;
	}

	/**
	 * 生成成功处理结果消息
	 * 
	 * @return 处理结果
	 */
	public static Serializable genSuccessResultMessage() {
		return genMessage("0000", "交易成功");
	}

	/**
	 * 生成成功处理结果消息
	 * 
	 * @param Message
	 *            返回显示消息
	 * @return 处理结果
	 */
	public static Serializable genSuccessResultMessage(String message) {
		return new ResultMessage("0000", message);
	}

	/**
	 * 生成失败处理结果消息
	 * 
	 * @param code
	 *            错误码
	 * @return
	 */
	public static Serializable genFailResultMessage(String code) {
		return genMessage(code, "交易失败");
	}

	private static Serializable genMessage(String code, String message) {
		ResultMessage rs = new ResultMessage();
		rs.setCode(code);
		String msg = ErrorCodeCache.errorCode.getProperty(code);
		if (msg == null || msg.trim().length() == 0) {
			rs.setMessage(message);
		} else {
			rs.setMessage(msg);
		}
		return rs;
	}

	/**
	 * 对象转换成Json格式字符串
	 * @param httpServletResponse 响应
	 * @param object 对象
	 */
	public static void OutputJson(HttpServletResponse httpServletResponse, Object object) {
		PrintWriter out = null;
		httpServletResponse.setContentType("application/json");
		httpServletResponse.setCharacterEncoding("utf-8");
		String json=null;
		try {
			out = httpServletResponse.getWriter();
			json = JSON.toJSONString(object);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("转换Json失败，{}", e.getCause());
		}
		out.print(json);
		out.close();
	}
}

