package com.cqrcb.boot.util;

import java.util.List;

import com.cqrcb.boot.domain.page.JsonResult;

public class JsonUtil {

	/**
	 * JOSN数据结构
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

}
